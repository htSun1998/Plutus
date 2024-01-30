import { defineStore } from "pinia";
import { ref } from "vue";

export const useUserStore = defineStore('user', () => {
    const userInfo = ref({
        username: '',
        password: '',
        email: '',
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

    return {
        userInfo,
        token,
        setToken,
        removeToken
    }
})
