<template>
  <el-dialog v-model="showUpdateDialog">
    <el-form :model="formData" label-position="top">
      <el-form-item label="名称">
        <el-input v-model="formData!.categoryName"></el-input>
      </el-form-item>
      <el-form-item label="颜色">
        <el-color-picker v-model="formData!.color" :predefine="DEFAULT_COLOR"></el-color-picker>
      </el-form-item>
      <el-form-item label="类型">
        <el-select v-model="formData!.type">
          <el-option label="收入" :value="0"></el-option>
          <el-option label="支出" :value="1"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="showUpdateDialog=false">取消</el-button>
      <el-button type="primary" @click="update">确认</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { defineProps } from 'vue'
import { useCategoryStore } from "../../store/category-store.ts"
import { storeToRefs } from "pinia"
import { updateCategoryApi } from "../../api/category-api.ts"
import DEFAULT_COLOR from "../../constant/color.ts"
import { ElNotification } from "element-plus"
const categoryStore = useCategoryStore()
const { showUpdateDialog } = storeToRefs(categoryStore)

const props = defineProps({
  formData: Object
})

const formData = props.formData

async function update() {
  await updateCategoryApi(formData).then(() => {
    ElNotification({
      title: 'Success',
      message: "修改成功",
      type: 'success'
    })
  })
  await new Promise<void>(resolve => {
    categoryStore.setCategoryList()
    showUpdateDialog.value = false
    resolve()
  })
}

</script>

<style scoped lang="scss">

</style>