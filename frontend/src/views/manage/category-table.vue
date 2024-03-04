<template>
  <el-table
      v-loading="loading"
      :data="categoryList"
      table-layout="fixed"
      default-expand-all
      :cell-style="{'text-align':'center'}"
      :header-cell-style="{'text-align':'center'}">
    <el-table-column prop="categoryName" label="名称"/>
    <el-table-column label="颜色">
      <template #default="scope">
        <el-tag :color="scope.row.color" effect="dark">{{ scope.row.color }}</el-tag>
      </template>
    </el-table-column>
    <el-table-column
        label="类型"
        :filters="[
            {text: '收入', value: 0},
            {text: '支出', value: 1}
        ]"
        :filter-method="filterTag">
      <template #default="scope">
        <el-tag effect="light" v-if="scope.row.type === 1">支出</el-tag>
        <el-tag effect="light" type="success" v-else>收入</el-tag>
      </template>
    </el-table-column>
    <el-table-column>
      <template #header>
        <el-button size="default" type="success" @click="openAddDialog">添加</el-button>
      </template>
      <template #default="scope">
        <el-button size="small" type="warning" @click="openUpdateDialog(scope.row)">编辑</el-button>
        <el-button size="small" type="danger" @click="openDeleteDialog(scope.row.id)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <update-dialog :formData="formData"/>
  <delete-dialog :id="deleteId"/>
  <add-dialog/>
</template>

<script setup lang="ts">
import { onMounted, reactive, ref } from "vue"
import { useCategoryStore } from "../../store/category-store.ts"
import { storeToRefs } from "pinia"
import UpdateDialog from "./update-dialog.vue";
import DeleteDialog from "./delete-dialog.vue";
import AddDialog from "./add-dialog.vue";

const categoryStore = useCategoryStore()
const { categoryList, showUpdateDialog, showDeleteDialog, showAddDialog } = storeToRefs(categoryStore)
const loading = ref(true)

const formData = reactive<TableData>({
  id: 0,
  categoryName: '',
  color: '',
  type: 0
})
const deleteId = ref()

function openUpdateDialog(data: TableData) {
  formData.id = data.id
  formData.type = data.type
  formData.color = data.color
  formData.categoryName = data.categoryName
  showUpdateDialog.value = true
}

function openDeleteDialog(id: number) {
  deleteId.value = id
  showDeleteDialog.value = true
}

function openAddDialog() {
  showAddDialog.value = true
}

interface TableData {
  id: number,
  categoryName: string,
  color: string,
  type: number
}

onMounted(async () => {
  await categoryStore.setCategoryList()
  loading.value = !loading.value
})

const filterTag = (value: number, row: TableData) => {
  return row.type === value
}

</script>

<style scoped lang="scss">
.el-table {
  height: 100%;
  width: 100%;
}
.el-tag {
  border-color: #FFFFFF;
}
</style>