<template>
  <b-container fluid class="bv-example-row mt-3 text-center">
    <b-row>
      <div id="map"></div>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapActions } from "vuex";
import axios from "axios";
const houseStore = "houseStore";

export default {
  name: "HouseMap",
  data() {
    return {
      map: "",
      markers: [],
      subways: [],
      subwayMarkers: [],
      commMarkers: [],
    };
  },
  computed: {
    ...mapState(houseStore, ["house", "houses", "comms"]),
    // house() {
    //   return this.$store.state.house;
    // },
  },
  watch: {
    house() {
      this.moveMap(this.house.lat, this.house.lng);
    },
    houses() {
      if (this.houses.length > 0) {
        this.initMap(this.houses[0].lat, this.houses[0].lng);
        this.displayMarkerSubway();
        this.displayMarker(this.houses);
        if (this.comms) {
          this.displayMarkerComm();
        }
      } else {
        this.moveMap(37.5643819, 126.9756308);
      }
    },
    comms() {
      this.initMap(this.houses[0].lat, this.houses[0].lng);
      this.displayMarkerSubway();
      this.displayMarker(this.houses);
      this.displayMarkerComm();
    },
  },
  mounted() {
    const script = document.createElement("script");
    /* global kakao */
    script.onload = () => kakao.maps.load(this.initMap);
    script.src =
      "//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=d22915962877f7248fc7225edf9c16a2";
    document.head.appendChild(script);
  },
  methods: {
    ...mapActions(houseStore, ["detailHouse"]),

    initMap(houselat, houselng) {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(houselat, houselng),
        level: 3,
      };
      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);
    },
    moveMap(houselat, houselng) {
      var moveLatLon = new kakao.maps.LatLng(houselat, houselng);
      if (this.map) {
        this.map.panTo(moveLatLon);
      } else {
        this.initMap(houselat, houselng);
      }
    },
    displayMarker(houses) {
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }
      const markerPositions = [];
      this.houses.forEach((house) => {
        markerPositions.push([house.lat, house.lng]);
      });

      const positions = markerPositions.map(
        (position) => new kakao.maps.LatLng(...position),
      );

      var imageSrc = require("@/assets/apticon.png"), // 마커이미지의 주소입니다
        imageSize = new kakao.maps.Size(50), // 마커이미지의 크기입니다
        imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      var markerImage = new kakao.maps.MarkerImage(
        imageSrc,
        imageSize,
        imageOption,
      );
      var mks = [];
      if (positions.length > 0) {
        for (let i = 0, len = positions.length; i < len; i++) {
          var marker = new kakao.maps.Marker({
            map: this.map,
            position: positions[i],
            image: markerImage,
          });
          mks.push(marker);
          var map = this.map;
          kakao.maps.event.addListener(marker, "click", function () {
            // 마커 위에 인포윈도우를 표시합니다
            var iwContent = `<div style="width:250px; padding:5px;">${houses[i].aptName}</div>`, // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
              iwRemoveable = true; // removeable 속성을 ture 로 설정하면 인포윈도우를 닫을 수 있는 x버튼이 표시됩니다
            var infowindow = new kakao.maps.InfoWindow({
              content: iwContent,
              removable: iwRemoveable,
            });
            infowindow.open(map, mks[i]);
            console.log(infowindow);
          });
        }
      }
    },
    displayMarkerComm() {
      const markerPositions = [];
      if (this.comms) {
        this.comms.forEach((comm) => {
          markerPositions.push([comm.lat, comm.lng]);
        });
      }
      const positions = markerPositions.map(
        (position) => new kakao.maps.LatLng(...position),
      );

      var imageSrc = require("@/assets/commercialIcon.png"), // 마커이미지의 주소입니다
        imageSize = new kakao.maps.Size(50), // 마커이미지의 크기입니다
        imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      var markerImage = new kakao.maps.MarkerImage(
        imageSrc,
        imageSize,
        imageOption,
      );
      var mks = [];
      if (positions.length > 0) {
        for (let i = 0, len = positions.length; i < len; i++) {
          var marker = new kakao.maps.Marker({
            map: this.map,
            position: positions[i],
            image: markerImage,
          });
          mks.push(marker);
        }
      }
    },
    displayMarkerSubway() {
      axios
        .get("http://localhost:9999/subway?dong=0")
        .then((response) => {
          this.subways = response.data;
          const markerPositions = [];

          this.subways.forEach((swbway) => {
            markerPositions.push([swbway.lat, swbway.lng]);
          });

          const positions = markerPositions.map(
            (position) => new kakao.maps.LatLng(...position),
          );

          var imageSrc = require("@/assets/subwayicon.png"), // 마커이미지의 주소입니다
            imageSize = new kakao.maps.Size(50, 55), // 마커이미지의 크기입니다
            imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
          var markerImage = new kakao.maps.MarkerImage(
            imageSrc,
            imageSize,
            imageOption,
          );
          if (positions.length > 0) {
            this.subwayMarkers = positions.map(
              (position) =>
                new kakao.maps.Marker({
                  map: this.map,
                  position,
                  image: markerImage,
                }),
            );
          }
        })
        .catch((error) => {
          console.dir(error);
        });
    },
  },
};
// 마커에 click 이벤트를 등록합니다
</script>

<style scoped>
#map {
  width: 100%;
  height: 1000px;
}
</style>
