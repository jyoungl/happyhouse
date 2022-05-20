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
export default {
  name: "MemberRegister",
  data() {
    return {
      user: {
        userid: null,
        username: null,
        userpwd: null,
        pwdcheck: null,
      },
    };
  },
  methods: {
    //...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    movePage() {
      this.$router.push({ name: "signIn" });
    },
  },
};
</script>

<style></style>
