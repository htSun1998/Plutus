<template>
  <el-button :icon="ArrowLeft" circle @click="goBack"></el-button>
  <el-button :icon="ArrowRight" circle @click="goForward"></el-button>
  <el-divider direction="vertical" />
  <el-text size="large">Title</el-text>
  <el-avatar class="avatar"
    src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"
    @click="$router.push('/main/personal')"
  ></el-avatar>
</template>

<script lang="ts" setup>
import { ArrowLeft, ArrowRight } from "@element-plus/icons-vue";

const goBack = () => {
  window.history.back()
}

const goForward = () => {
  window.history.forward()
}
</script>

<style scoped>
.avatar {
  justify-content: flex-end;
  margin-left: auto;
  cursor: pointer;
}
</style>