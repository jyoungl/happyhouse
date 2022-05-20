<template>
  <b-container fluid class="bv-example-row mt-3 text-center">
    <b-row>
      <div id="map"></div>
    </b-row>
  </b-container>
</template>

<script>
import { mapState } from "vuex";

const houseStore = "houseStore";

export default {
  name: "HouseMap",
  data() {
    return {
      map: "",
      markers: [],
    };
  },
  computed: {
    ...mapState(houseStore, ["house", "houses"]),
    // house() {
    //   return this.$store.state.house;
    // },
  },
  watch: {
    house() {
      this.moveMap(this.house);
    },
    houses() {
      this.initMap(this.houses[0]);
      this.displayMarker();
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
    initMap(house) {
      const container = document.getElementById("map");
      const options = {
        center: new kakao.maps.LatLng(house.lat, house.lng),
        level: 5,
      };
      //지도 객체를 등록합니다.
      //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
      this.map = new kakao.maps.Map(container, options);
    },
    moveMap(house) {
      var moveLatLon = new kakao.maps.LatLng(house.lat, house.lng);
      if (this.map) {
        this.map.panTo(moveLatLon);
      } else {
        this.initMap(house);
      }
    },
    displayMarker() {
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
        imageSize = new kakao.maps.Size(50, 55), // 마커이미지의 크기입니다
        imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.
      var markerImage = new kakao.maps.MarkerImage(
        imageSrc,
        imageSize,
        imageOption,
      );
      if (positions.length > 0) {
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: this.map,
              position,
              image: markerImage,
            }),
        );

        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds(),
        );

        this.map.setBounds(bounds);
      }
    },
  },
};
</script>

<style scoped>
#map {
  width: 100%;
  height: 1000px;
}
</style>
