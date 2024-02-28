<template>
  <el-table
      v-loading="loading"
      :data="tableData"
      table-layout="fixed"
      row-key="id"
      default-expand-all>
    <el-table-column prop="name" label="名称"/>
    <el-table-column prop="id" label="ID"/>
    <el-table-column prop="type" label="type"/>
  </el-table>
</template>

<script setup lang="ts">
import { onMounted, reactive, ref } from "vue"
import { useCategoryStore } from "../../store/category-store.ts"
import { storeToRefs } from "pinia"

const categoryStore = useCategoryStore()
const { categoryList } = storeToRefs(categoryStore)
const loading = ref(true)
const tableData = reactive<TableData[]>([]);

interface TableData {
  id: number,
  name: string,
  color: string,
  type: string
}

interface CategoryInfo {
  id: number,
  categoryName: string,
  type: number,
  color: string,
  createUser: number,
  createTime: string,
  updateTime: string
}

onMounted(async () => {
  await categoryStore.setCategoryList()
  await new Promise<void>(resolve => {
    categoryList.value.forEach((category: CategoryInfo) => {
      const { id, categoryName: name, type, color } = category
      tableData.push({
        id,
        name,
        type: type === 0 ? "收入" : "支出",
        color
      })
    })
    resolve()
  })
  loading.value = !loading.value
})

</script>

<style scoped lang="scss">
.el-table {
  height: 100%;
  width: 100%;
}
</style>