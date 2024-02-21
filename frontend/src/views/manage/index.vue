<template>
  <el-row>
    <el-col :span="12" style="padding-right: 10px">
      <el-tabs model-value="out">
        <el-tab-pane label="支出" name="out">
          <category-table1 style="height: 100%"></category-table1>
        </el-tab-pane>
        <el-tab-pane label="收入" name="in">
          <category-table0 ></category-table0>
        </el-tab-pane>
      </el-tabs>
    </el-col>
    <el-col :span="12" style="padding-left: 10px">
    </el-col>
  </el-row>
</template>

<script setup lang="ts">
import CategoryTable0 from "./category-table0.vue"
import CategoryTable1 from "./category-table1.vue"

</script>

<style scoped lang="scss">
.el-row {
  height: 100%
}
</style>