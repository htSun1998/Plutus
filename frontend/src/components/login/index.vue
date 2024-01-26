<template class="login">
  <div style="background: aquamarine; width: 30vw; padding: 5vh; margin: 20vh auto;">
    <h2 class="title" style="margin-top: 0">账本</h2>
    <el-form
        label-position="top"
        label-width="100px"
        :model="loginForm"
        style="max-width: 400px"
        class="login-form">
      <el-form-item label="用户名">
        <el-input v-model="loginForm.username" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="loginForm.password" />
      </el-form-item>
    </el-form>
    <div style="text-align: center; margin-top: 40px">
      <el-button type="primary" round @click="checkLogin">登录</el-button>
      <el-button plain round @click="register">注册</el-button>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { reactive } from 'vue'
import { useRouter } from "vue-router";
const router = useRouter()

const loginForm = reactive({
  username: '',
  password: ''
})
const registerForm = reactive({
  username: '',
  password: '',
  email: ''
})

function checkLogin() {
  router.push("/main")
}
function register() {

}
</script>

<style lang="scss">
.title {
  text-align: center;
  margin-top: 30vh;
}
.login-button {
  text-align: center;
}
.login-form {
  margin: 0 auto;
}
</style>