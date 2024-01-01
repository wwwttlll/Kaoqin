import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/homeview/homeview.vue'
import Login from "@/views/Login.vue"
import ForgetPassword from "@/views/ForgetPassword.vue"
import Register from "@/views/Register.vue"
import UserView from "@/views/UserView.vue"
import Supplement from "@/views/Supplement.vue"
import Leave from "@/views/Leave.vue"
import Record from "@/views/Record.vue"
import Statistics from "@/views/Statistics.vue"
import userAttendance from "@/views/detail.vue"
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
    {
      path: '/user-view',
      name: 'user-view',
      component: UserView,
      meta: {
        keepAlive: true
      }
    },
    {
      path: '/attendance-management/supplement',
      name: 'supplement',
      component: Supplement,
      meta: {
        keepAlive: true
      }
    },
    {
      path: '/attendance-management/leave',
      name: 'leave',
      component: Leave,
      meta: {
        keepAlive: true
      }
    },
    {
      path: '/attendance-management/record',
      name: 'record',
      component: Record,
      meta: {
        keepAlive: true
      }
    },
    {
      path: '/attendance-management/statistics',
      name: 'statistics',
      component: Statistics,
      meta: {
        keepAlive: true
      }
    },
    {
      path: '/attendance-management/statistics/user',
      name: 'userAttendance',
      component: userAttendance,
      meta: {
        keepAlive: true
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
