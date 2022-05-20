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
        <b-row>
          <b-col class="ml-3 bg-light">
            <house-detail />
          </b-col>
        </b-row>
      </b-col>
      <b-col cols="9">
        <house-map />
      </b-col>
    </b-row>
  </b-container>
</template>
<script>
import HouseSearchBar from "@/components/house/HouseSearchBar.vue";
import HouseList from "@/components/house/HouseList.vue";
import HouseDetail from "@/components/house/HouseDetail.vue";
import HouseMap from "@/components/house/HouseMap.vue";
export default {
  name: "HouseView",
  components: {
    HouseSearchBar,
    HouseList,
    HouseDetail,
    HouseMap,
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
</style>
