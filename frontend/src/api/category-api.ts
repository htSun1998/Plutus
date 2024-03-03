import request from "../utils/request.ts";
import { useUserStore } from "../store/user-store.ts";

export function listApi() {
    const tokenStore = useUserStore()
    return request.get(
        "/category/list",
        {
            headers: {'Authorization': tokenStore.token},
        })
}

export function updateCategoryApi(data: any) {
    const tokenStore = useUserStore()
    return request.put(
        "/category/update",
        data,
        {
            headers: {'Authorization': tokenStore.token},
        })
}

export function deleteCategoryApi(id: number) {
    const tokenStore = useUserStore()
    return request.delete(
        "/category/delete",
        {
            headers: {'Authorization': tokenStore.token},
            params: {
                "id": id
            }
        })
}

export function addCategoryApi(data: any) {
    const tokenStore = useUserStore()
    return request.post(
        "/category/add",
        data,
        {
            headers: {'Authorization': tokenStore.token}
        })
}
