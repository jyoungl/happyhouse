<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>질문 보기</h3></b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-left">
        <b-button variant="outline-primary" @click="listArticle">목록</b-button>
      </b-col>
      <b-col class="text-right" v-if="userInfo.userid == article.userid">
        <b-button
          variant="outline-info"
          size="sm"
          @click="moveModifyArticle"
          class="mr-2"
          >질문 수정</b-button
        >
        <b-button variant="outline-danger" size="sm" @click="deleteArticle"
          >질문 삭제</b-button
        >
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col>
        <b-card
          :header-html="`<h3>${article.articleno}.
          ${article.subject} [${article.hit}]</h3><div><h6>${article.userid}</div><div>${article.regtime}</h6></div>`"
          class="mb-2"
          border-variant="dark"
          no-body
        >
          <b-card-body class="text-left">
            Q.
            <div>{{ article.content }}</div>
          </b-card-body>
          <hr />
          <b-card-body class="text-left">
            A.
            <div v-html="answer"></div>
          </b-card-body>
        </b-card>
      </b-col>
    </b-row>
    <b-row>
      <b-col class="text-right" v-if="userInfo">
        <b-button
          variant="outline-info"
          size="sm"
          @click="moveModifyAnswer"
          class="mr-2"
          v-if="this.article.acontent"
          >답변 수정</b-button
        >
        <b-button
          variant="outline-info"
          size="sm"
          @click="moveAddAnswer"
          class="mr-2"
          v-else
          >답변 추가</b-button
        >
        <b-button
          variant="outline-danger"
          size="sm"
          @click="deleteAnswer"
          v-if="this.article.acontent"
          >답변 삭제</b-button
        >
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
// import moment from "moment";
import { apiInstance } from "@/api/index";
import { mapState } from "vuex";

const api = apiInstance();
const memberStore = "memberStore";

export default {
  name: "BoardDetail",
  data() {
    return {
      article: {},
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),

    message() {
      console.log(this.article);
      if (this.article.content) this.contentf();
      //this.article.content = this.article.content.split("\n").join("<br>");
      return "";
    },
    answer() {
      if (this.article.acontent)
        return this.article.acontent.split("\n").join("<br>");
      return "";
    },
  },
  created() {
    api.get(`/board/${this.$route.params.articleno}`).then(({ data }) => {
      this.article = data;
    });
  },
  methods: {
    contentf() {
      this.article.content = this.article.content.split("\n").join("<br>");
    },
    listArticle() {
      this.$router.push({ name: "boardList" });
    },
    moveModifyArticle() {
      this.$router.replace({
        name: "boardModify",
        params: { articleno: this.article.articleno },
      });
      //   this.$router.push({ path: `/board/modify/${this.article.articleno}` });
    },
    deleteArticle() {
      if (confirm("정말로 삭제?")) {
        this.$router.replace({
          name: "boardDelete",
          params: { articleno: this.article.articleno },
        });
      }
    },
    moveModifyAnswer() {
      this.$router.replace({
        name: "ModifyAnswer",
        params: { articleno: this.article.articleno },
      });
      //   this.$router.push({ path: `/board/modify/${this.article.articleno}` });
    },
    moveAddAnswer() {
      this.$router.replace({
        name: "AddAnswer",
        params: { articleno: this.article.articleno },
      });
      //   this.$router.push({ path: `/board/modify/${this.article.articleno}` });
    },
    deleteAnswer() {
      if (confirm("정말로 삭제?")) {
        api
          .put(`/board/${this.article.articleno}`, {
            articleno: this.article.articleno,
            userid: this.article.userid,
            subject: this.article.subject,
            content: this.article.content,
            acontent: "",
          })
          .then(({ data }) => {
            let msg = "답변 삭제 중 문제가 발생했습니다.";
            if (data === "success") {
              msg = "답변 삭제 완료되었습니다.";
            }
            alert(msg);
            this.article.acontent = "";
          });
      }
    },
  },
  // filters: {
  //   formcontent: function (value) {
  //     //맨 앞의 하나만 필터링됨.. 같은 욕설 여러개 있으면 여러개 다 필터링이 안됨 근데 while문으로 contains, search 도 안됨 어카지????
  //     return value.replace("띠발", "**").replace("지랄", "**");
  //   },
  // },
};
</script>

<style></style>
