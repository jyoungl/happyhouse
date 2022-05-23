<template>
  <b-row class="mb-1">
    <b-col style="text-align: left">
      <b-form @submit="onSubmit" @reset="onReset">
        <b-form-group
          id="userid-group"
          label="작성자:"
          label-for="userid"
          description="작성자를 입력하세요."
        >
          <b-form-input
            id="userid"
            :disabled="isUserid"
            v-model="article.userid"
            type="text"
            required
            placeholder="작성자 입력..."
          ></b-form-input>
        </b-form-group>

        <b-form-group
          id="subject-group"
          label="제목:"
          label-for="subject"
          description="제목을 입력하세요."
        >
          <b-form-input
            id="subject"
            v-model="article.subject"
            type="text"
            required
            placeholder="제목 입력..."
            readonly="readonly"
          ></b-form-input>
        </b-form-group>

        <b-form-group id="content-group" label="질문:" label-for="content">
          <b-form-textarea
            id="content"
            v-model="article.content"
            placeholder="질문 입력..."
            rows="10"
            max-rows="15"
            readonly="readonly"
          ></b-form-textarea>
        </b-form-group>

        <b-form-group id="content-group" label="답변:" label-for="acontent">
          <b-form-textarea
            id="acontent"
            v-model="article.acontent"
            placeholder="답변 입력..."
            rows="10"
            max-rows="15"
          ></b-form-textarea>
        </b-form-group>

        <b-button
          type="submit"
          variant="primary"
          class="m-1"
          v-if="this.type === 'addanswer'"
          >답변추가</b-button
        >
        <b-button type="submit" variant="primary" class="m-1" v-else
          >답변수정</b-button
        >
        <b-button type="reset" variant="danger" class="m-1">초기화</b-button>
      </b-form>
    </b-col>
  </b-row>
</template>

<script>
import { apiInstance } from "@/api/index";
const api = apiInstance();

export default {
  name: "BoardInputAnswerItem",
  data() {
    return {
      article: {
        articleno: 0,
        userid: "",
        subject: "",
        content: "",
        acontent: "",
      },
      isUserid: false,
    };
  },
  props: {
    type: { type: String },
  },
  created() {
    api.get(`/board/${this.$route.params.articleno}`).then(({ data }) => {
      // this.article.articleno = data.article.articleno;
      // this.article.userid = data.article.userid;
      // this.article.subject = data.article.subject;
      // this.article.content = data.article.content;
      this.article = data;
    });
    this.isUserid = true;
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      !this.article.acontent && ((msg = "답변을 입력해주세요"), (err = false));

      if (!err) alert(msg);
      else this.answerRegist();
    },
    onReset(event) {
      event.preventDefault();
      this.article.articleno = 0;
      this.article.subject = "";
      this.article.content = "";
      this.$router.push({ name: "boardList" });
    },
    answerRegist() {
      api
        .put(`/board/${this.article.articleno}`, {
          articleno: this.article.articleno,
          userid: this.article.userid,
          subject: this.article.subject,
          content: this.article.content,
          acontent: this.article.acontent,
        })
        .then(({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "답변 등록이 완료되었습니다.";
          }
          alert(msg);
          // 현재 route를 /list로 변경.
          this.$router.push({
            name: "boardDetail",
            params: this.article.articleno,
          });
        });
    },
    moveList() {
      this.$router.push({ name: "boardList" });
    },
  },
};
</script>

<style></style>
