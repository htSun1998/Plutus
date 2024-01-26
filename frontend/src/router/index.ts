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
            component: () => import("../components/login/index.vue")
        },
        {
            path: "/main",
            component: () => import("../components/layout/index.vue"),
            redirect: "main/welcome",
            children: [
                {
                    path: "welcome",
                    component: () => import("../components/views/welcome.vue")
                },
                {
                    path: "personal",
                    component: () => import("../components/views/personal.vue")
                },
                {
                    path: "account",
                    component: () => import("../components/views/account.vue")
                },
                {
                    path: "statistic",
                    component: () => import("../components/views/statistic.vue")
                }
            ]
        }
    ]
})

export default router