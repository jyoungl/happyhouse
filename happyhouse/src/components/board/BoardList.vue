<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>Q&A 목록</h3></b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-right" v-if="userInfo">
        <b-button variant="outline-primary" @click="moveWrite()"
          >질문하기</b-button
        >
      </b-col>
    </b-row>
    <b-row>
      <b-col v-if="articles.length">
        <b-table-simple hover responsive>
          <b-thead head-variant="dark">
            <b-tr>
              <b-th>글번호</b-th>
              <b-th>제목</b-th>
              <b-th>작성자</b-th>
              <b-th>작성일</b-th>
            </b-tr>
          </b-thead>
          <tbody>
            <!-- 하위 component인 ListRow에 데이터 전달(props) -->
            <board-list-item
              v-for="article in articles"
              :key="article.articleno"
              v-bind="article"
            />
          </tbody>
        </b-table-simple>
      </b-col>
      <!-- <b-col v-else class="text-center">도서 목록이 없습니다.</b-col> -->
    </b-row>
  </b-container>
</template>

<script>
//import { mapActions } from "vuex";
import { apiInstance } from "@/api/index";
import BoardListItem from "@/components/board/item/BoardListItem";
import { mapState } from "vuex";

const memberStore = "memberStore";
//const boardStore = "boardStore";
const api = apiInstance();

export default {
  name: "BoardList",
  components: {
    BoardListItem,
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data() {
    return {
      articles: [],
    };
  },
  created() {
    api.get(`/board`).then(({ data }) => {
      this.articles = data;
    });
    //this.reloadArticle();
  },
  methods: {
    // ...mapActions(boardStore, ["reloadBoard"]),

    // reloadArticle(){
    //   this.reloadBoard();
    // },
    moveWrite() {
      this.$router.push({ name: "boardRegister" });
    },
  },
};
</script>

<style scope>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdSubject {
  width: 300px;
  text-align: left;
}
</style>
