<template>
  <el-card>
    <el-form label-position="top" :model="registerForm" :rules="rules" style="width: 400px">
      <el-form-item label="用户名" prop="username">
        <el-input v-model="registerForm.username" placeholder="请输入用户名" clearable/>
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input v-model="registerForm.password" placeholder="请输入密码"/>
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
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
import { ElNotification } from "element-plus"
import { FormRules } from "element-plus"

const loginStore = useLoginStore()
const { isLogin } = storeToRefs(loginStore)

interface RegisterForm {
  username: string
  password: string
  email: string
}
const registerForm = reactive({
  username: '',
  password: '',
  email: ''
})

const rules = reactive<FormRules<RegisterForm>> ({
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
  ],
  email: [
    {
      required: true,
      message: '请输入邮箱',
      trigger: 'change',
    },
  ]
})

async function register() {
  await registerApi(registerForm)
  ElNotification({
    title: 'Success',
    message: "注册成功",
    type: 'success'
  })
  isLogin.value = !isLogin.value
}
</script>

<style scoped lang="scss">

</style>