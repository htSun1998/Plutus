import { defineStore } from "pinia"
import { ref } from "vue"
import { userInfoApi, groupInfoApi } from "../api/user-api.ts"

export const useUserStore = defineStore('user', () => {
    const userInfo = ref({
        username: '',
        password: '',
        nickname: '',
        email: '',
        telephone: '',
        avatarUrl: '',
        createTime: '',
        updateTime: ''
    })
    const groupInfo = ref({
        groupName: '',
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

    const setGroupInfo = async () => {
        groupInfo.value = (await groupInfoApi()).data
    }

    return {
        userInfo,
        groupInfo,
        token,
        setToken,
        removeToken,
        setUserInfo,
        setGroupInfo
    }
}, {
    persist: true
})
