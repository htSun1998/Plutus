import axios, { AxiosInstance } from "axios"

const instance: AxiosInstance = axios.create({
    baseURL: "/api",
    timeout: 5000,
})

instance.interceptors.response.use(
    response => {
        return response.data
    },
    error => {
        alert("服务异常")
        return Promise.reject(error)
    }
)

export default instance
