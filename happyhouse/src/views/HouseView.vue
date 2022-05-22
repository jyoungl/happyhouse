<template>
  <b-container fluid class="bexample-col text-center">
    <b-row>
      <b-col cols="3">
        <b-row>
          <b-col align="left" class="mt-3 ml-3 bg-light">
            <house-search-bar></house-search-bar>
          </b-col>
        </b-row>

        <b-row>
          <b-col align="left" class="ml-3 bg-light">
            <house-list />
          </b-col>
        </b-row>
      </b-col>
      <b-col cols="9">
        <house-map />
      </b-col>
    </b-row>
    <div class="detail" v-if="house">
      <b-col class="ml-3 bg-light">
        <house-detail />
      </b-col>
    </div>
  </b-container>
</template>
<script>
import HouseSearchBar from "@/components/house/HouseSearchBar.vue";
import HouseList from "@/components/house/HouseList.vue";
import HouseDetail from "@/components/house/HouseDetail.vue";
import HouseMap from "@/components/house/HouseMap.vue";
import { mapState } from "vuex";
const houseStore = "houseStore";
export default {
  name: "HouseView",
  components: {
    HouseSearchBar,
    HouseList,
    HouseDetail,
    HouseMap,
  },
  computed: {
    ...mapState(houseStore, ["house"]),
    // house() {
    //   return this.$store.state.house;
    // },
  },
};
</script>
<style scoped>
.underline-orange {
  display: inline-block;
  background: linear-gradient(
    180deg,
    rgba(255, 255, 255, 0) 70%,
    rgba(231, 149, 27, 0.3) 30%
  );
}
.detail {
  position: absolute;
  top: 97px;
  left: 81.87%;
  width: 17%;

  z-index: 3;
  background-color: aliceblue;
}
</style>
