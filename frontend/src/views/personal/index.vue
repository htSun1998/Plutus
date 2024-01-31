<template>
  <el-row>
    <el-col :span="6" :offset="2" style="display: flex; flex-direction: column">
      <el-image
          :src="userInfo.avatarUrl"
          :preview-src-list="[userInfo.avatarUrl]"
          :zoom-rate="1.2"
          :max-scale="7"
          :min-scale="0.2"
          fit="fill"
          class="image"/>
      <el-button style="width: 200px">更换头像</el-button>
    </el-col>
    <el-col :span="14">
      <el-form :model="userInfo" label-position="top" style="width: 40vw; margin-top: 100px">
        <el-form-item label="用户名">
          <el-input v-model="userInfo.username" />
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="userInfo.nickname" />
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="userInfo.email" />
        </el-form-item>
<!--        TODO 选择用户组-->
        <el-form-item label="组" prop="region">
          <el-select v-model="userGroup" placeholder="Activity zone">
            <el-option label="Zone one" value="shanghai" />
            <el-option label="Zone two" value="beijing" />
          </el-select>
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="updateUserInfo">提交</el-button>
      <el-button @click="userStore.setUserInfo">重置</el-button>
    </el-col>
  </el-row>

</template>

<script setup lang="ts">
import { useUserStore } from "../../store/user-store.ts"
import { storeToRefs } from "pinia"
import {updateUserInfoApi} from "../../api/user-api.ts";
import {ElNotification} from "element-plus";
import {ref} from "vue";

const userStore = useUserStore()
const { userInfo } = storeToRefs(userStore)

const userGroup = ref()

function updateUserInfo() {
  console.log(userInfo)
  updateUserInfoApi(userInfo.value)
  ElNotification({
    title: 'Success',
    message: "修改成功",
    type: 'success'
  })
}

</script>

<style scoped lang="scss">
.image {
  width: 200px;
  height: 200px;
  margin-top: 150px;
  cursor: pointer;
}
</style>