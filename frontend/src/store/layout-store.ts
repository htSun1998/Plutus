import { defineStore } from "pinia"
import { ref } from "vue";

export const useLayoutStore = defineStore('layout', () => {
    const isShowAside = ref(false)

    return { isShowAside }
})