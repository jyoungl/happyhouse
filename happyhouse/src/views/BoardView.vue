<template>
  <b-container v-if="isLogin" class="bv-example-row mt-3 text-center">
    <router-view></router-view>
  </b-container>
  <b-container v-else class="bv-example-row mt-3 text-center">
    <h2>로그인해주세요!</h2>
  </b-container>
</template>
<script>
import { mapState } from "vuex";
const memberStore = "memberStore";
export default {
  name: "BoardView",
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError"]),
  },
};
</script>
<style scoped>
.underline-hotpink {
  display: inline-block;
  background: linear-gradient(
    180deg,
    rgba(255, 255, 255, 0) 70%,
    rgba(231, 27, 139, 0.3) 30%
  );
}
</style>
