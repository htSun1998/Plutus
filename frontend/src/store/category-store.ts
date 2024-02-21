import { defineStore } from "pinia"
import { ref } from "vue"
import { listApi } from "../api/category-api.ts"



export const useCategoryStore = defineStore('category', () => {
    const categoryList0 = ref()
    const categoryList1 = ref()

    const setCategoryList = async () => {
        categoryList0.value = (await listApi(0)).data
        categoryList1.value = (await listApi(1)).data
    }

    return { categoryList0, categoryList1, setCategoryList }
}, {
    persist: true
})