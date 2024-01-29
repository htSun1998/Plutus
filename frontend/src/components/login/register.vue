<template>
  <el-card>
    <el-form label-position="top" :model="registerForm" style="width: 20vw">
      <el-form-item label="用户名">
        <el-input v-model="registerForm.username" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="registerForm.password" />
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="registerForm.email" />
      </el-form-item>
    </el-form>
      <el-button type="success" round @click="register" class="login-button">注册</el-button>
      <el-button round @click="loginStore.isLogin = !loginStore.isLogin" class="login-button">返回</el-button>
  </el-card>
</template>

<script setup lang="ts">
import { reactive } from "vue";
import { useLoginStore } from "../../store/login.ts";

const loginStore = useLoginStore()
const registerForm = reactive({
  username: '',
  password: '',
  email: ''
})
function register() {
  alert("register")
}
</script>

<style scoped lang="scss">

</style>