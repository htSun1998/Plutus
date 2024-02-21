<template>
  <el-table v-loading="loading" :data="tableData"
            row-key="id" default-expand-all>
    <el-table-column prop="name" label="名称" width="180" />
    <el-table-column prop="id" label="ID" width="100" />

<!--    <el-table-column prop="categoryName2" label="名称" width="100" />-->
    <el-table-column prop="type" label="type" width="100" />
  </el-table>
</template>

<script setup lang="ts">
import { onMounted, ref } from "vue"
import { useCategoryStore } from "../../store/category-store.ts"
import { storeToRefs } from "pinia"
import { generateTableData } from "./utils.ts"

const categoryStore = useCategoryStore()
const { categoryList0 } = storeToRefs(categoryStore)
const loading = ref(true)
let tableData: any = ref([])

onMounted(async () => {
  await categoryStore.setCategoryList()
  await new Promise<void>(resolve => {
    tableData = generateTableData(categoryList0.value)
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