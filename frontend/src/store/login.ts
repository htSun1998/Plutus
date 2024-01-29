import { defineStore } from "pinia"

export const useLoginStore = defineStore('login', {
    state() {
        return {
            isLogin: true
        }
    },
})