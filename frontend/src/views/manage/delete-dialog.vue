<template>
  <el-dialog v-model="showDeleteDialog">
    <template #header>
      <span>是否删除该类别</span>
    </template>
    <template #footer>
      <el-button @click="showDeleteDialog=false">取消</el-button>
      <el-button type="primary" @click="deleteCategory(props.id)">确认</el-button>
    </template>
  </el-dialog>
</template>

<script setup lang="ts">
import { defineProps } from "vue"
import { useCategoryStore } from "../../store/category-store.ts"
import { storeToRefs } from "pinia"
import { deleteCategoryApi } from "../../api/category-api.ts"
import { ElNotification } from "element-plus"
const categoryStore = useCategoryStore()
const { showDeleteDialog } = storeToRefs(categoryStore)

const props = defineProps({
  id: Number
})

async function deleteCategory(id: number) {
  await deleteCategoryApi(id).then(() => {
    ElNotification({
      title: 'Success',
      message: "删除成功",
      type: 'success'
    })
  })
  await new Promise<void>(resolve => {
    categoryStore.setCategoryList()
    showDeleteDialog.value = false
    resolve()
  })
}

</script>

<style scoped lang="scss">

</style>