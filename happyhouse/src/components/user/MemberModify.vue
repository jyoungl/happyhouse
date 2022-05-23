<template>
  <b-container class="bv-example-row mt-3">
    <div class="row justify-content-center">
      <div class="col-lg-5 col-md-7">
        <div class="card bg-secondary bg-white shadow border-0">
          <div class="card-body px-lg-5 py-lg-5">
            <div class="text-center text-muted mb-4">
              <small>sign up form</small>
            </div>
            <b-form class="text-left">
              <b-form-group label-for="userid">
                <b-input-group>
                  <b-input-group-prepend>
                    <span class="input-group-text"
                      ><b-icon icon="envelope"></b-icon
                    ></span>
                  </b-input-group-prepend>
                  <b-form-input
                    id="userid"
                    v-model="user.userid"
                    disabled
                    :placeholder="userInfo.userid"
                  ></b-form-input>
                </b-input-group>
              </b-form-group>

              <b-form-group label-for="username">
                <b-input-group>
                  <b-input-group-prepend>
                    <span class="input-group-text"
                      ><b-icon icon="people"></b-icon
                    ></span>
                  </b-input-group-prepend>
                  <b-form-input
                    type="text"
                    id="username"
                    v-model="user.username"
                    disabled
                    :placeholder="userInfo.username"
                  ></b-form-input>
                </b-input-group>
              </b-form-group>

              <b-form-group label-for="email">
                <b-input-group>
                  <b-input-group-prepend>
                    <span class="input-group-text"
                      ><b-icon icon="people"></b-icon
                    ></span>
                  </b-input-group-prepend>
                  <b-form-input
                    type="text"
                    id="email"
                    v-model="user.email"
                    required
                    :placeholder="userInfo.email"
                  ></b-form-input>
                </b-input-group>
              </b-form-group>

              <b-form-group label-for="userpwd">
                <b-input-group>
                  <b-input-group-prepend>
                    <span class="input-group-text"
                      ><b-icon icon="lock"></b-icon
                    ></span>
                  </b-input-group-prepend>
                  <b-form-input
                    type="password"
                    id="userpwd"
                    v-model="user.userpwd"
                    required
                    placeholder="Password"
                  ></b-form-input>
                </b-input-group>
              </b-form-group>

              <b-form-group label-for="pwdcheck">
                <b-input-group>
                  <b-input-group-prepend>
                    <span class="input-group-text"
                      ><b-icon icon="lock-fill"></b-icon
                    ></span>
                  </b-input-group-prepend>
                  <b-form-input
                    type="password"
                    id="pwdcheck"
                    v-model="user.pwdcheck"
                    required
                    placeholder="Password check"
                  ></b-form-input>
                </b-input-group>
              </b-form-group>

              <b-form-group label-for="phone">
                <b-input-group>
                  <b-input-group-prepend>
                    <span class="input-group-text"
                      ><b-icon icon="lock"></b-icon
                    ></span>
                  </b-input-group-prepend>
                  <b-form-input
                    type="text"
                    id="phone"
                    v-model="user.phone"
                    required
                    :placeholder="userInfo.phone"
                  ></b-form-input>
                </b-input-group>
              </b-form-group>
              관심지역:
              <b-row class="mt-4 mb-4 text-center">
                <b-col class="sm-3">
                  <b-form-select
                    v-model="sidoCode"
                    :options="sidos"
                    @change="gugunList"
                  ></b-form-select>
                </b-col>
                <b-col class="sm-3">
                  <b-form-select
                    v-model="gugunCode"
                    :options="guguns"
                    @change="dongList"
                  ></b-form-select>
                </b-col>
                <b-col class="sm-3">
                  <b-form-select
                    v-model="user.dongCode"
                    :options="dongs"
                  ></b-form-select>
                </b-col>
              </b-row>
              <div class="text-center">
                <b-button
                  type="button"
                  variant="secondary"
                  class="btn btn-secondary m-1 font-weight-bold"
                  @click="confirm"
                  >수정완료</b-button
                >
              </div>
            </b-form>
          </div>
        </div>
      </div>
    </div>
  </b-container>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";

const memberStore = "memberStore";
const houseStore = "houseStore";
export default {
  name: "MembderModify",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      user: {
        userid: null,
        username: null,
        email: null,
        userpwd: null,
        pwdcheck: null,
        phone: null,
        dongCode: null,
        jibun: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo", "isLogin"]),
    ...mapState(houseStore, ["sidos", "guguns", "dongs"]),
  },
  created() {
    this.user = this.userInfo;
    this.userid = this.user.userid;
    this.username = this.user.username;
    this.email = this.user.email;
    this.phone = this.user.phone;
    this.getSido();
    // console.log(this.user);
  },
  methods: {
    ...mapActions(memberStore, ["setUserInfo"]),
    ...mapActions(houseStore, [
      "getSido",
      "getGugun",
      "getHouseList",
      "getDong",
    ]),
    ...mapMutations(houseStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
    ]),
    gugunList() {
      console.log(this.sidoCode);
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    dongList() {
      console.log(this.gugunCode);
      this.CLEAR_DONG_LIST();
      this.dongCode = null;
      if (this.gugunCode) this.getDong(this.gugunCode);
    },
    async confirm() {
      if (
        //this.user.idck == "생성가능한 ID입니다." &&
        this.user.username != null &&
        this.user.email != null &&
        this.user.userpwd != null &&
        this.user.userpwd.length >= 4 &&
        this.user.userpwd == this.user.pwdcheck
      ) {
        let s = "";
        for (let i = 0; i < this.sidos.length; i++) {
          if (this.sidos[i].value == this.sidoCode) {
            s = this.sidos[i].text;
          }
        }
        let g = "";
        for (let i = 0; i < this.guguns.length; i++) {
          if (this.guguns[i].value == this.gugunCode) {
            g = this.guguns[i].text;
          }
        }
        let d = "";
        for (let i = 0; i < this.dongs.length; i++) {
          if (this.dongs[i].value == this.user.dongCode) {
            d = this.dongs[i].text;
          }
        }
        this.user.jibun = `${s} ${g} ${d}`;
        console.log(this.user.jibun);
        this.setUserInfo(this.user);
        alert("수정을 완료하였습니다.");

        this.$router.push({ name: "mypage" });
      } else if (this.user.username == null) {
        alert("이름을 입력해주세요.");
      } else if (this.user.email == null) {
        alert("이메일을 입력해주세요.");
      } else if (this.user.userpwd == null) {
        alert("비밀번호를 입력해주세요.");
      } else if (this.user.userpwd.length < 4) {
        alert("비밀번호를 4자리 이상 입력해주세요.");
      } else {
        alert("modify fail");
      }
    },
  },
};
</script>

<style></style>
