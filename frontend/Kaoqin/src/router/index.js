import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/homeview/homeview.vue'
import Login from "@/views/Login.vue"
import ForgetPassword from "@/views/ForgetPassword.vue"
import Register from "@/views/register.vue"
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
      meta: {
        keepAlive: true
      }
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
      meta: {
        keepAlive: false
      }
    },
    {
      path: '/forget',
      name: 'forget',
      component: ForgetPassword,
      meta: {
        keepAlive: false
      }
    },
    {
      path: '/register',
      name: 'register',
      component: Register,
      meta: {
        keepAlive: false
      }
    },
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (About.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import('../views/AboutView.vue')
    // }
  ]
})

export default router
