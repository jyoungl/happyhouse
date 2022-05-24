<template>
  <b-container>
    <b-row class="mt-4 mb-4 text-center">
      <!-- <b-col class="sm-3">
      <b-form-input
        v-model.trim="dongCode"
        placeholder="동코드 입력...(예 : 11110)"
        @keypress.enter="sendKeyword"
      ></b-form-input>
    </b-col>
    <b-col class="sm-3" align="left">
      <b-button variant="outline-primary" @click="sendKeyword">검색</b-button>
    </b-col> -->
      <b-col class="sm-3">
        <b-form-select
          v-model="sidoCode"
          :options="sidos"
          @change="gugunList"
        ></b-form-select>
      </b-col>
      <b-col class="sm-3">
        <b-form-select
          v-model="gugunCode"
          :options="guguns"
          @change="dongList"
        ></b-form-select>
      </b-col>
      <b-col class="sm-3">
        <b-form-select
          v-model="dongCode"
          :options="dongs"
          @change="searchApt"
        ></b-form-select>
      </b-col>
    </b-row>
    <b-row>
      <b-col
        ><b-form-checkbox v-model="yearchecked"
          >거래년도로 검색
        </b-form-checkbox></b-col
      >
      <b-col v-if="isLogin">
        <b-form-checkbox v-model="memberchecked" @change="commercialList">
          관심지역 상권 검색</b-form-checkbox
        ></b-col
      >
    </b-row>
    <b-row class="text-center" v-if="memberchecked">
      <b-col class="sm-4">관심지역: {{ userInfo.jibun }}</b-col>
    </b-row>
    <b-row class="mt-4 mb-4 text-center" v-if="yearchecked">
      <b-col class="sm-4"> <year-slider :dongCode="dongCode" /></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
import YearSlider from "@/components/house/YearSlider.vue";
/*
  namespaced: true를 사용했기 때문에 선언해줍니다.
  index.js 에서 modules 객체의 '키' 이름입니다.

  modules: {
    키: 값
    memberStore: memberStore,
    houseStore: houseStore
  }
*/
const houseStore = "houseStore";
const memberStore = "memberStore";

export default {
  name: "HouseSearchBar",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
      years: [],
      yearchecked: false,
      memberchecked: false,
    };
  },
  components: {
    YearSlider,
  },
  computed: {
    ...mapState(houseStore, ["sidos", "guguns", "houses", "dongs", "comms"]),
    ...mapState(memberStore, ["userInfo", "isLogin"]),
    // sidos() {
    //   return this.$store.state.sidos;
    // },
  },
  created() {
    // this.$store.dispatch("getSido");
    // this.sidoList();
    this.CLEAR_SIDO_LIST();
    this.getSido();
    for (let i = 2000; i < 2023; i++) {
      this.years.push({ value: i, text: `${i}년` });
    }
  },
  methods: {
    ...mapActions(houseStore, [
      "getSido",
      "getGugun",
      "getHouseList",
      "getDong",
      "getCommList",
    ]),
    ...mapMutations(houseStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
      "CLEAR_COMM_LIST",
    ]),
    // sidoList() {
    //   this.getSido();
    // },
    gugunList() {
      console.log(this.sidoCode);
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    dongList() {
      console.log(this.gugunCode);
      this.CLEAR_DONG_LIST();
      this.dongCode = null;
      if (this.gugunCode) this.getDong(this.gugunCode);
    },
    async commercialList() {
      if (!this.memberchecked) {
        this.CLEAR_COMM_LIST();
      } else if (this.userInfo.dongCode) {
        await this.getHouseList(this.userInfo.dongCode);
        await this.getCommList(this.userInfo.dongCode);
      }
    },
    searchApt() {
      if (this.dongCode) this.getHouseList(this.dongCode);
    },
  },
};
</script>

<style></style>
