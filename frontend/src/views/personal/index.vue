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
        <el-form-item label="手机号">
          <el-input v-model="userInfo.telephone" />
        </el-form-item>
<!--        TODO 选择用户组-->
        <el-form-item label="组" prop="region">
          <el-select v-model="userGroup" placeholder="Activity zone">
            <el-option label="Zone one" value="shanghai" />
            <el-option label="Zone two" value="beijing" />
          </el-select>
        </el-form-item>
      </el-form>
      <el-button type="primary" @click="updateDialogVisible = true">提交</el-button>
      <el-button @click="userStore.setUserInfo">重置</el-button>
      <el-divider></el-divider>
      <el-button type="warning" @click="passwordDialogVisible = true">修改密码</el-button>
    </el-col>
  </el-row>
  <el-dialog v-model="updateDialogVisible" align-center>
    <span>是否修改用户信息？</span>
    <template #footer>
      <el-button @click="updateDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="updateUserInfo">确认</el-button>
    </template>
  </el-dialog>
  <el-dialog v-model="passwordDialogVisible" align-center>
    <el-form :model="passwordForm" label-position="top">
      <el-form-item label="原密码">
        <el-input v-model="passwordForm.oldPwd"></el-input>
      </el-form-item>
      <el-form-item label="新密码">
        <el-input v-model="passwordForm.newPwd"></el-input>
      </el-form-item>
      <el-form-item label="请再次输入新密码">
        <el-input v-model="passwordForm.rePwd"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="passwordDialogVisible = false">取消</el-button>
      <el-button type="primary" @click="updatePwd">确认</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { useUserStore } from "../../store/user-store.ts"
import { storeToRefs } from "pinia"
import { updatePasswordApi, updateUserInfoApi } from "../../api/user-api.ts"
import { ElNotification } from "element-plus"
import { reactive, ref } from "vue"

const userStore = useUserStore()
const { userInfo } = storeToRefs(userStore)

const userGroup = ref()
const updateDialogVisible = ref(false)
const passwordDialogVisible = ref(false)

const passwordForm = reactive({
  oldPwd: '',
  newPwd: '',
  rePwd: ''
})

function updateUserInfo() {
  updateUserInfoApi(userInfo.value)
  updateDialogVisible.value = false
  ElNotification({
    title: 'Success',
    message: "修改成功",
    type: 'success'
  })
}

function updatePwd() {
  updatePasswordApi(passwordForm)
  passwordDialogVisible.value = false
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