<template>
  <b-row
    class="m-2"
    @click="selectComm"
    @mouseover="colorChange(true)"
    @mouseout="colorChange(false)"
    :class="{ 'mouse-over-bgcolor': isColor }"
  >
    <b-col cols="2" class="text-center align-self-center">
      <b-img
        thumbnail
        src="https://picsum.photos/250/250/?image=58"
        alt="Image 1"
      ></b-img>
    </b-col>
    <b-col cols="10" class="align-self-center">
      {{ comm.commercialName }}
    </b-col>
  </b-row>
</template>

<script>
import { mapActions } from "vuex";
const houseStore = "houseStore";
export default {
  name: "CommercialListItem",

  data() {
    return {
      isColor: false,
    };
  },
  props: {
    comm: Object,
  },
  methods: {
    ...mapActions(houseStore, ["detailComm"]),
    selectComm() {
      this.detailComm(this.comm);
    },
    colorChange(flag) {
      this.isColor = flag;
    },
  },
};
</script>

<style scoped>
.apt {
  width: 50px;
}
.mouse-over-bgcolor {
  background-color: lightblue;
}
</style>
