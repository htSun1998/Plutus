<template>
  <el-button :icon="ArrowLeft" link v-if="!isShowAside" @click="changeShowState"></el-button>
  <el-button :icon="ArrowRight" link v-else @click="changeShowState"></el-button>
  <el-divider direction="vertical"/>
  <el-text size="large">Title</el-text>
  <el-avatar class="avatar" :size="40"
    :src="userStore.userInfo.avatarUrl"
    @click="$router.push('/main/personal')"
  />
</template>

<script lang="ts" setup>
import { ArrowLeft, ArrowRight } from "@element-plus/icons-vue"
import { useUserStore } from "../../store/user-store.ts"
import { useLayoutStore } from "../../store/layout-store.ts"
import {storeToRefs} from "pinia";

const userStore = useUserStore()
const layoutStore = useLayoutStore()

const { isShowAside } = storeToRefs(layoutStore)

function changeShowState() {
  isShowAside.value = !isShowAside.value
}
</script>

<style scoped>
.avatar {
  justify-content: flex-end;
  margin-left: auto;
  cursor: pointer;
}
</style>
