import { defineStore } from "pinia"
import { ref } from "vue"
import { listApi } from "../api/category-api.ts"

export const useCategoryStore = defineStore('category', () => {
    const categoryList = ref()

    const setCategoryList = async () => {
        categoryList.value = (await listApi()).data
    }

    const showUpdateDialog = ref(false)
    const showDeleteDialog = ref(false)
    const showAddDialog = ref(false)

    return {
        categoryList,
        setCategoryList,
        showUpdateDialog,
        showDeleteDialog,
        showAddDialog
    }
}, {
    persist: true
})