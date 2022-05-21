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
                    required
                    placeholder="Id"
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
                    required
                    placeholder="Name"
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
                    placeholder="Email"
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
                    placeholder="Phone"
                  ></b-form-input>
                </b-input-group>
              </b-form-group>

              <div class="text-center">
                <b-button
                  type="button"
                  variant="secondary"
                  class="btn btn-secondary m-1 font-weight-bold"
                  @click="confirm"
                  >Create</b-button
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
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "MemberRegister",
  data() {
    return {
      user: {
        userid: null,
        username: null,
        email: null,
        userpwd: null,
        pwdcheck: null,
        phone: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError", "idckstate"]),
  },
  methods: {
    ...mapActions(memberStore, ["setRegister", "checkuserId"]),

    async confirm() {
      if (
        //this.user.idck == "생성가능한 ID입니다." &&
        this.user.username != null &&
        this.user.email != null &&
        this.user.userpwd != null &&
        this.user.userpwd.length >= 4 &&
        this.user.userpwd == this.user.pwdcheck
      ) {
        this.setRegister(this.user);
        alert("가입을 완료하였습니다.");

        this.$router.push({ name: "home" });
      } else if (this.user.idck == "중복된 ID입니다.") {
        alert("새로운 ID를 입력해주세요.");
      } else if (this.user.username == null) {
        alert("이름을 입력해주세요.");
      } else if (this.user.email == null) {
        alert("이메일을 입력해주세요.");
      } else if (this.user.userpwd == null) {
        alert("비밀번호를 입력해주세요.");
      } else if (this.user.userpwd.length < 4) {
        alert("비밀번호를 4자리 이상 입력해주세요.");
      } else {
        alert("register fail");
      }
    },
    async idcheck() {
      if (this.user.userid != null) {
        this.checkuserId(this.user.userid);
        console.log(this.idckstate);
        setTimeout(() => {
          this.user.idck = this.idckstate;
          if (this.user.idck == "생성가능한 ID입니다.") {
            alert("생성 가능한 ID 입니다!");
          } else {
            alert("중복된 ID 입니다!");
          }
        }, 1000);
      } else {
        alert("ID를 입력해주세요.");
      }
    },
  },
};
</script>

<style></style>
