<template>
  <b-container class="bv-example-row mt-3 text-center">
    <br /><br /><br />
    <h2 class="underline-steelblue">Happy House</h2>
    <h5><b-icon icon="person-lines-fill"></b-icon> Member Service</h5>
    <br />
    <router-view></router-view>
  </b-container>
</template>

<script>
export default {
  name: "MemberView",
};
</script>

<style scoped>
.underline-steelblue {
  display: inline-block;
  background: linear-gradient(
    180deg,
    rgba(255, 255, 255, 0) 70%,
    rgba(72, 190, 233, 0.3) 30%
  );
}
</style>
