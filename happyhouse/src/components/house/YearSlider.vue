<template>
  <v-card flat color="transparent">
    <v-subheader>거래년도 범위</v-subheader>

    <v-card-text>
      <v-row>
        <v-col class="px-4">
          <v-range-slider
            v-model="range"
            :max="max"
            :min="min"
            hide-details
            class="align-center"
            @change="searchByYear"
          >
            <template v-slot:prepend>
              <v-text-field
                :value="range[0]"
                class="mt-0 pt-0"
                hide-details
                single-line
                type="number"
                style="width: 60px"
                @change="$set(range, 0, $event)"
              ></v-text-field>
            </template>
            <template v-slot:append>
              <v-text-field
                :value="range[1]"
                class="mt-0 pt-0"
                hide-details
                single-line
                type="number"
                style="width: 60px"
                @change="$set(range, 1, $event)"
              ></v-text-field>
            </template>
          </v-range-slider>
        </v-col>
      </v-row>
    </v-card-text>
  </v-card>
</template>

<script>
import { mapState, mapActions } from "vuex";

const houseStore = "houseStore";

export default {
  name: "YearSlider",
  props: {
    dongCode: String,
  },
  data() {
    return {
      min: 2014,
      max: 2023,
      range: [-20, 70],
    };
  },
  computed: {
    ...mapState(houseStore, ["houses"]),
    // houses() {
    //   return this.$store.state.houses;
    // },
  },
  methods: {
    ...mapActions(houseStore, ["getHouseListByYear"]),
    searchByYear() {
      let send = {
        dongCode: this.dongCode,
        maxyear: this.range[1],
        minyear: this.range[0],
      };
      if (this.dongCode) this.getHouseListByYear(send);
    },
  },
};
</script>

<style></style>
