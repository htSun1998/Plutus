<template>
  <el-card>
    <el-form label-position="top" :model="registerForm" style="width: 400px">
      <el-form-item label="用户名">
        <el-input v-model="registerForm.username" placeholder="请输入用户名" clearable/>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="registerForm.password" placeholder="请输入密码"/>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="registerForm.email" placeholder="请输入邮箱"/>
      </el-form-item>
    </el-form>
    <el-row justify="space-between">
      <el-button type="success" round @click="register" class="login-button">注册</el-button>
      <el-button round @click="isLogin = !isLogin" class="login-button">返回</el-button>
    </el-row>
  </el-card>
</template>

<script setup lang="ts">
import { reactive } from "vue"
import { useLoginStore } from "../../store/login-store.ts"
import { storeToRefs } from "pinia"
import { registerApi } from "../../api/user-api.ts"


const loginStore = useLoginStore()
const { isLogin } = storeToRefs(loginStore)
const registerForm = reactive({
  username: '',
  password: '',
  email: ''
})

async function register() {
  let response: any = await registerApi(registerForm)
  if (response.code == 0) {
    alert(response.message)
    isLogin.value = !isLogin.value
  }
  else {
    alert(response.message)
  }
}
</script>

<style scoped lang="scss">

</style>