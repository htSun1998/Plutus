<template>
  <el-card>
    <el-form label-position="top" :model="loginForm" :rules="rules" style="width: 400px">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="loginForm.username" placeholder="请输入用户名" clearable/>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="loginForm.password" placeholder="请输入密码" type="password" show-password clearable/>
      </el-form-item>
    </el-form>
    <el-row justify="space-between">
      <el-button type="primary" round @click="checkLogin" class="login-button">登录</el-button>
      <el-button type="success" round @click="isLogin = !isLogin" class="login-button" disabled>注册</el-button>
    </el-row>
  </el-card>
</template>

<script setup lang="ts">
import { reactive } from 'vue'
import { useRouter } from "vue-router"
import { useLoginStore } from "../../store/login-store.ts"
import { storeToRefs } from "pinia"
import { loginApi } from "../../api/user-api.ts"
import { useUserStore } from "../../store/user-store.ts"
import { FormRules } from "element-plus"

const loginStore = useLoginStore()
const userStore = useUserStore()

const { isLogin } = storeToRefs(loginStore)
const router = useRouter()

interface LoginForm {
  username: string,
  password: string
}
const loginForm = reactive({
  username: '',
  password: ''
})

const rules = reactive<FormRules<LoginForm>> ({
  username: [
    {
      required: true,
      message: '请输入用户名',
      trigger: 'change',
    },
  ],
  password: [
    {
      required: true,
      message: '请输入密码',
      trigger: 'change',
    },
  ]
})

async function checkLogin() {
  let response: any = await loginApi(loginForm)
  userStore.setToken(response.data)
  await userStore.setUserInfo()
  await userStore.setGroupInfo()
  await router.push("/main")
}
</script>

<style scoped lang="scss">

</style>