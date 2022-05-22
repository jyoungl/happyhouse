<template>
  <b-container v-if="houses && houses.length != 0" class="bv-example-row mt-3">
    <house-list-item
      v-for="(house, index) in housesperpage"
      :key="index"
      :house="house"
    />
    <div class="overflow-auto">
      <b-pagination
        v-model="currentPage"
        :total-rows="houses.length"
        :per-page="6"
      ></b-pagination>
    </div>
  </b-container>
  <b-container v-else class="bv-example-row mt-3">
    <b-row>
      <b-col><b-alert show>주택 목록이 없습니다.</b-alert></b-col>
    </b-row>
  </b-container>
</template>

<script>
import HouseListItem from "@/components/house/HouseListItem.vue";
import { mapState } from "vuex";

const houseStore = "houseStore";

export default {
  name: "HouseList",
  components: {
    HouseListItem,
  },
  data() {
    return {
      currentPage: 1,
      housesperpage: [],
    };
  },
  computed: {
    ...mapState(houseStore, ["houses"]),
    // houses() {
    //   return this.$store.state.houses;
    // },
  },
  watch: {
    houses() {
      this.housesperpage = [];
      for (let i = 1; i <= 5; i++) {
        if (this.houses[i - 1]) {
          this.housesperpage.push(this.houses[i - 1]);
        }
      }
    },
    currentPage() {
      const pagesize = 5,
        startpage = (this.currentPage - 1) * pagesize + 1,
        endpage = this.currentPage * pagesize + 1;
      this.housesperpage = [];
      if (this.currentPage > 1) {
        for (let i = startpage; i < endpage; i++) {
          if (this.houses[i - 1]) {
            this.housesperpage.push(this.houses[i - 1]);
          }
        }
      } else {
        for (let i = 1; i <= 5; i++) {
          if (this.houses[i - 1]) {
            this.housesperpage.push(this.houses[i - 1]);
          }
        }
      }
    },
  },
  methods: {},
};
</script>

<style></style>
