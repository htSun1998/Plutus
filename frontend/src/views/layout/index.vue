<template>
    <el-container>
      <el-aside width="collapse">
        <!--左侧导航栏-->
        <side-menu></side-menu>
      </el-aside>
      <el-container>
        <el-header class="header">
          <!--顶部导航栏-->
          <top-menu></top-menu>
        </el-header>
        <el-divider style="margin: 0"/>
        <el-main class="main">
          <!--主界面区-->
          <RouterView></RouterView>
        </el-main>
        <el-footer height="20px"></el-footer>
      </el-container>
    </el-container>
</template>

<script lang="ts">
import { defineComponent } from "vue"
import { RouterView } from "vue-router"
import SideMenu from "./side-menu.vue"
import TopMenu from "./top-menu.vue"

export default defineComponent({
  components: { RouterView, TopMenu, SideMenu }
})

</script>

<style scoped lang="scss">

.header{
  display: flex;
  align-items: center;
  padding-left: 10px;
  padding-right: 5px;
  height: 50px;
}
.main{
  background: #F2F3F5;
}
</style>