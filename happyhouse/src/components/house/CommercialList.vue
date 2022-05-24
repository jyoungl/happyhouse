<template>
  <b-container v-if="comms && comms.length != 0" class="bv-example-row mt-3">
    <b-row class="text-center mb-1">
      <b-col><strong>상권 정보</strong></b-col>
    </b-row>
    <commercial-list-item
      v-for="(comm, index) in commsperpage"
      :key="index"
      :comm="comm"
    />
    <div class="overflow-auto">
      <b-pagination
        v-model="currentPage"
        :total-rows="comms.length"
        :per-page="6"
      ></b-pagination>
    </div>
  </b-container>
  <b-container v-else class="bv-example-row mt-3">
    <b-row>
      <b-col><b-alert show>상권 목록이 없습니다.</b-alert></b-col>
    </b-row>
  </b-container>
</template>

<script>
import CommercialListItem from "@/components/house/CommercialListItem.vue";
import { mapState } from "vuex";

const houseStore = "houseStore";

export default {
  name: "HouseList",
  components: {
    CommercialListItem,
  },
  data() {
    return {
      currentPage: 1,
      commsperpage: [],
    };
  },
  computed: {
    ...mapState(houseStore, ["comms"]),
    // houses() {
    //   return this.$store.state.houses;
    // },
  },
  watch: {
    comms() {
      this.commsperpage = [];
      for (let i = 1; i <= 5; i++) {
        if (this.comms[i - 1]) {
          this.commsperpage.push(this.comms[i - 1]);
        }
      }
    },
    currentPage() {
      const pagesize = 5,
        startpage = (this.currentPage - 1) * pagesize + 1,
        endpage = this.currentPage * pagesize + 1;
      this.commsperpage = [];
      if (this.currentPage > 1) {
        for (let i = startpage; i < endpage; i++) {
          if (this.houses[i - 1]) {
            this.commsperpage.push(this.comms[i - 1]);
          }
        }
      } else {
        for (let i = 1; i <= 5; i++) {
          if (this.comms[i - 1]) {
            this.commsperpage.push(this.comms[i - 1]);
          }
        }
      }
    },
  },
  methods: {},
};
</script>

<style></style>
