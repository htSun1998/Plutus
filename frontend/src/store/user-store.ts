import { defineStore } from "pinia";
import { ref } from "vue";
import { userInfoApi } from "../api/user-api.ts";

export const useUserStore = defineStore('user', () => {
    const userInfo = ref({
        username: '',
        password: '',
        email: '',
        telephone: '',
        nickname: '',
        avatarUrl: '',
        createTime: '',
        updateTime: ''
    })

    const token = ref('')

    const setToken = (newToken: string) => {
        token.value = newToken
    }

    const removeToken = () => {
        token.value = ''
    }

    const setUserInfo = async () => {
        userInfo.value = (await userInfoApi()).data
    }

    return {
        userInfo,
        token,
        setToken,
        removeToken,
        setUserInfo
    }
}, {
    persist: true
})
