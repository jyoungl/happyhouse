import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import memberStore from "@/store/modules/memberStore.js";

export default new Vuex.Store({
  state: {},
  getters: {},
  mutations: {},
  actions: {},
  modules: {
    memberStore,
  },
});
