import { createRouter, createWebHistory } from "vue-router";


const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: "/",
            redirect: "/login"
        },
        {
            path: "/login",
            component: () => import("../views/login/index.vue")
        },
        {
            path: "/main",
            component: () => import("../views/layout/index.vue"),
            redirect: "main/welcome",
            children: [
                {
                    path: "welcome",
                    component: () => import("../views/welcome/index.vue")
                },
                {
                    path: "personal",
                    component: () => import("../views/personal/index.vue")
                },
                {
                    path: "account",
                    component: () => import("../views/account/index.vue")
                },
                {
                    path: "statistic",
                    component: () => import("../views/statistic/index.vue")
                }
            ]
        }
    ]
})

export default router