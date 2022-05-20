<template>
  <b-container class="bv-example-row mt-3">
    <div class="row justify-content-center">
      <div class="col-lg-5 col-md-7">
        <div class="card bg-secondary bg-white shadow border-0">
          <div class="card-body px-lg-5 py-lg-5">
            <div class="text-center text-muted mb-4">
              <small>sign in form</small>
            </div>
            <b-form class="text-left">
              <b-alert show variant="danger" v-if="isLoginError"
                >아이디 또는 비밀번호를 확인하세요.</b-alert
              >
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
                    @keyup.enter="confirm"
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
                    @keyup.enter="confirm"
                  ></b-form-input>
                </b-input-group>
              </b-form-group>

              <div class="text-center">
                <b-button
                  type="button"
                  variant="secondary"
                  class="btn btn-secondary m-1 font-weight-bold"
                  @click="confirm"
                  >Sign in</b-button
                >
                <b-button
                  type="button"
                  variant="secondary"
                  class="btn btn-secondary m-1 font-weight-bold"
                  @click="movePage"
                  >Sign up</b-button
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
  name: "MemberLogin",
  data() {
    return {
      user: {
        userid: null,
        userpwd: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError"]),
  },
  methods: {
    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      if (this.isLogin) {
        await this.getUserInfo(token);
        this.$router.push({ name: "home" });
      }
    },
    movePage() {
      this.$router.push({ name: "signUp" });
    },
  },
};
</script>

<style>
b-form-input ::placeholder {
  color: lightgray;
}
</style>
