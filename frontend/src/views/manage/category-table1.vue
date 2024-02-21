<template>
  <el-table v-loading="loading" :data="tableData"
            row-key="id"
            table-layout="fixed"
            :header-cell-style="{'text-align':'center'}" :cell-style="{'text-align':'center'}">
    <el-table-column prop="name" label="名称"/>
    <el-table-column label="图标">
      <template #default="scope">
        <el-image :src="scope.row.iconUrl"></el-image>
      </template>
    </el-table-column>
    <el-table-column label="操作">
      <template #default="scope">
        <el-button type="primary" @click="handleUpdate(scope.row.id)">修改</el-button>
        <el-button type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script setup lang="ts">
import { onMounted, ref } from "vue"
import { useCategoryStore } from "../../store/category-store.ts"
import { storeToRefs } from "pinia"
import { generateTableData } from "./utils.ts"
import { useLayoutStore } from "../../store/layout-store.ts";

const categoryStore = useCategoryStore()
const { categoryList1 } = storeToRefs(categoryStore)
const loading = ref(true)
let tableData: any = ref([])
const layoutStore = useLayoutStore()
const { isShowCategoryForm } = storeToRefs(layoutStore)

onMounted(async () => {
  isShowCategoryForm.value = false
  await categoryStore.setCategoryList()
  await new Promise<void>(resolve => {
    tableData = generateTableData(categoryList1.value)
    resolve()
  })
  loading.value = !loading.value
})

function handleUpdate(id: number) {
  isShowCategoryForm.value = true

}

function handleDelete(id: number) {

}

</script>

<style scoped lang="scss">
.el-table {
  height: 100%;
  width: 100%;
}
.el-image {
  width: 50px;
  height: 50px;
}
</style>