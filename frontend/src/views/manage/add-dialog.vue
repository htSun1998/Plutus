<template>
  <el-dialog v-model="showAddDialog">
    <el-form :model="formData" label-position="top">
      <el-form-item label="名称">
        <el-input v-model="formData.categoryName"></el-input>
      </el-form-item>
      <el-form-item label="颜色">
        <el-color-picker v-model="formData.color"></el-color-picker>
      </el-form-item>
      <el-form-item label="类型">
        <el-select v-model="formData.type">
          <el-option label="收入" :value="0"></el-option>
          <el-option label="支出" :value="1"></el-option>
        </el-select>
      </el-form-item>
    </el-form>
    <template #footer>
      <el-button @click="showAddDialog=false">取消</el-button>
      <el-button type="primary" @click="add">确认</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { reactive } from "vue"
import { useCategoryStore } from "../../store/category-store.ts"
import { storeToRefs } from "pinia"
import { addCategoryApi } from "../../api/category-api.ts"
import { ElNotification } from "element-plus"
const categoryStore = useCategoryStore()
const { showAddDialog } = storeToRefs(categoryStore)

const formData = reactive({
  categoryName: '',
  color: '',
  type: ''
})

async function add() {
  await addCategoryApi(formData).then(() => {
    ElNotification({
      title: 'Success',
      message: "添加成功",
      type: 'success'
    })
  })
  await new Promise<void>(resolve => {
    categoryStore.setCategoryList()
    showAddDialog.value = false
    resolve()
  })
}

</script>

<style scoped lang="scss">

</style>