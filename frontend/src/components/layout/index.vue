<template>
    <el-container>
      <el-header class="header">
        <!--顶部导航栏-->
        <top-menu></top-menu>
      </el-header>
      <el-container>
        <el-aside class="aside">
          <!--左侧导航栏-->
          <side-menu></side-menu>
        </el-aside>
        <el-main class="main">
          <!--主界面区-->
          <RouterView></RouterView>
        </el-main>
      </el-container>
    </el-container>

</template>

<script lang="ts">
import { defineComponent } from "vue";
import { RouterView } from "vue-router";
import SideMenu from "./side-menu.vue";
import TopMenu from "./top-menu.vue";

export default defineComponent({
  components: {RouterView, TopMenu, SideMenu}
})
</script>

<style scoped lang="scss">
.aside{
  background: #d1edc4;
  width: 200px;
}
.header{
  background: #f8e3c5;
  display: flex;
  align-items: center;
}
.main{
  background: #c6e2ff;
}

</style>