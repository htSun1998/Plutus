<template>
  <el-row class="tac">
    <el-col>
      <h5 style="text-align: center">功能列表</h5>
      <el-menu
          class="el-menu--vertical"
          @open="handleOpen"
          @close="handleClose"
      >
        <el-menu-item index="1" @click="$router.push('/main/account')" style="justify-content: center">
          <el-icon><EditPen/></el-icon>
          <span>记账</span>
        </el-menu-item>
        <el-menu-item index="2" @click="$router.push('/main/statistic')" style="justify-content: center">
          <el-icon><PieChart/></el-icon>
          <span>统计</span>
        </el-menu-item>
      </el-menu>
    </el-col>
  </el-row>
</template>

<script lang="ts" setup>


const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}

</script>