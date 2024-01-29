<template>
  <el-card>
    <el-form label-position="top" :model="loginForm" style="width: 20vw">
      <el-form-item label="用户名">
        <el-input v-model="loginForm.username" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="loginForm.password" />
      </el-form-item>
    </el-form>
    <el-row justify="space-between">
      <el-button type="primary" round @click="checkLogin" class="login-button">登录</el-button>
      <el-button type="success" round @click="loginStore.isLogin = !loginStore.isLogin" class="login-button">注册</el-button>
    </el-row>
  </el-card>
</template>

<script setup lang="ts">
import { reactive } from 'vue'
import { useRouter } from "vue-router";
import { useLoginStore } from "../../store/login.ts";

const loginStore = useLoginStore()
const router = useRouter()
const loginForm = reactive({
  username: '',
  password: ''
})
function checkLogin() {
  router.push("/main")
}
</script>

<style scoped lang="scss">

</style>