<template>

  <el-menu :collapse="layoutStore.isShowAside" class="menu">
    <el-menu-item index="1" @click="$router.push('/main/account')">
      <el-icon><EditPen/></el-icon>
      <span>记账</span>
    </el-menu-item>
    <el-menu-item index="2" @click="$router.push('/main/statistic')">
      <el-icon><PieChart/></el-icon>
      <span>统计</span>
    </el-menu-item>
    <el-menu-item index="3" @click="$router.push('/main/manage')">
      <el-icon><Setting/></el-icon>
      <span>管理</span>
    </el-menu-item>
  </el-menu>
</template>

<script lang="ts" setup>
import { useLayoutStore } from "../../store/layout-store.ts"
import { EditPen, PieChart, Setting } from "@element-plus/icons-vue"

const layoutStore = useLayoutStore()
</script>

<style scoped lang="scss">
.menu {
  height: 100%;
}
span {
  width: 50px;
  padding-left: 20px;
}
</style>