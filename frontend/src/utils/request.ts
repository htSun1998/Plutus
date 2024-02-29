import axios, { AxiosInstance } from "axios"
import { ElNotification } from "element-plus"

const instance: AxiosInstance = axios.create({
    baseURL: "/api",
    timeout: 5000,
})

instance.interceptors.response.use(
    response => {
        if (response.data.code === 0) {
            return response.data
        }
        ElNotification({
            title: 'Error',
            message: response.data.message,
            type: 'error'
        })
        return Promise.reject(response.data)
    },
    error => {
        alert("服务异常")
        return Promise.reject(error)
    }
)

export default instance
