import { defineStore } from "pinia"
import { ref } from "vue"
import { listApi } from "../api/category-api.ts"

export const useCategoryStore = defineStore('category', () => {
    const categoryList = ref()

    const setCategoryList = async () => {
        categoryList.value = (await listApi()).data
    }

    return { categoryList, setCategoryList }
}, {
    persist: true
})