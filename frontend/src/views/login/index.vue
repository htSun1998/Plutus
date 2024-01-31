<template>
  <div class="container">
    <login v-if="isLogin"></login>
    <register v-else></register>
  </div>
</template>

<script lang="ts" setup>
import Login from "./login.vue";
import Register from "./register.vue";
import { useLoginStore } from "../../store/login-store.ts";
import {storeToRefs} from "pinia";

const loginStore = useLoginStore()
const { isLogin } = storeToRefs(loginStore)

</script>

<style lang="scss" scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}
</style>