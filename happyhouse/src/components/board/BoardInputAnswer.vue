<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>답변 추가</h3></b-alert>
      </b-col>
    </b-row>
    <board-input-answer-item type="addanswer" />
  </b-container>
</template>

<script>
import BoardInputAnswerItem from "@/components/board/item/BoardInputAnswerItem.vue";

export default {
  name: "AddAnswer",
  components: {
    BoardInputAnswerItem,
  },
};
</script>

<style></style>
