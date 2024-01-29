<template>
  <div class="container">
    <login v-if="loginStore.isLogin"></login>
    <register v-else></register>
  </div>
</template>

<script lang="ts" setup>
import Login from "./login.vue";
import Register from "./register.vue";
import { useLoginStore } from "../../store/login.ts";

const loginStore = useLoginStore()

</script>

<style lang="scss">
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  //flex-direction: column;
}
</style>