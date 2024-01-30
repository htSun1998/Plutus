<template>
  <el-card>
    <el-form label-position="top" :model="loginForm" style="width: 400px">
      <el-form-item label="用户名">
        <el-input v-model="loginForm.username" placeholder="请输入用户名" clearable/>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="loginForm.password" placeholder="请输入密码" type="password" show-password clearable/>
      </el-form-item>
    </el-form>
    <el-row justify="space-between">
      <el-button type="primary" round @click="checkLogin" class="login-button">登录</el-button>
      <el-button type="success" round @click="isLogin = !isLogin" class="login-button">注册</el-button>
    </el-row>
  </el-card>
</template>

<script setup lang="ts">
import { reactive } from 'vue'
import { useRouter } from "vue-router"
import { useLoginStore } from "../../store/login-store.ts"
import { storeToRefs } from "pinia"
import { loginApi, userInfoApi } from "../../api/user-api.ts"
import { useUserStore } from "../../store/user-store.ts"

const loginStore = useLoginStore()
const userStore = useUserStore()

const { isLogin } = storeToRefs(loginStore)
const router = useRouter()
const loginForm = reactive({
  username: '',
  password: ''
})

async function checkLogin() {
  let response: any = await loginApi(loginForm)
  if (response.code == 0) {
    userStore.setToken(response.data)
    userStore.userInfo = (await userInfoApi()).data
    await router.push("/main")
  } else {
    alert(response.message)
  }
}
</script>

<style scoped lang="scss">

</style>