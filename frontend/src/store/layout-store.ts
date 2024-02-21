import { defineStore } from "pinia"
import { ref } from "vue";

export const useLayoutStore = defineStore('layout', () => {
    const isShowAside = ref(false)
    const isShowCategoryForm = ref(false)
    return { isShowAside, isShowCategoryForm }
}, {
    persist: true
})