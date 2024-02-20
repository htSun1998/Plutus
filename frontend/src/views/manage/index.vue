<template>
  <el-row>
    <el-col :span="12" style="padding-right: 10px">
      <category-table></category-table>
    </el-col>
    <el-col :span="12" style="padding-left: 10px">
    </el-col>
  </el-row>
</template>

<script setup lang="ts">
import CategoryTable from "./category-table.vue"
</script>

<style scoped lang="scss">
.el-row {
  height: 100%
}
</style>