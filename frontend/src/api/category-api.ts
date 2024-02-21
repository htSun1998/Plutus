import request from "../utils/request.ts";
import { useUserStore } from "../store/user-store.ts";

export function listApi(params: number) {
    const tokenStore = useUserStore()
    return request.get(
        "/category/list",
        {
            headers: {'Authorization': tokenStore.token},
            params: {
                type: params
            }
        })
}
