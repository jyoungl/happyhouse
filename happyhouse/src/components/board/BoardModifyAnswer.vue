<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>답변 수정</h3></b-alert>
      </b-col>
    </b-row>
    <board-input-answer-item type="modifyanswer" />
  </b-container>
</template>

<script>
import BoardInputAnswerItem from "@/components/board/item/BoardInputAnswerItem.vue";

export default {
  name: "ModifyAnswer",
  components: {
    BoardInputAnswerItem,
  },
};
</script>

<style></style>
