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

import HomeViewUser from '@/views/homeview/homeviewuser.vue'
import AddApply from "@/views/AddApply.vue"
import ApplyList from "@/views/ApplyList.vue"
import SignData from "@/views/SignData.vue"
import ChangeInfo from "@/views/ChangeInfo.vue"
import UserHome from "@/views/UserHome.vue"
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
      meta: {
        keepAlive: true,
        menuType: 'manager'
      }
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
      meta: {
        keepAlive: false,
        menuType: false
      }
    },
    {
      path: '/forget',
      name: 'forget',
      component: ForgetPassword,
      meta: {
        keepAlive: false,
        menuType: false
      }
    },
    {
      path: '/register',
      name: 'register',
      component: Register,
      meta: {
        keepAlive: false,
        menuType: false
      }
    },
    {
      path: '/user-view',
      name: 'user-view',
      component: UserView,
      meta: {
        keepAlive: true,
        menuType: 'manager'
      }
    },
    {
      path: '/attendance-management/supplement',
      name: 'supplement',
      component: Supplement,
      meta: {
        keepAlive: true,
        menuType: 'manager'
      }
    },
    {
      path: '/attendance-management/leave',
      name: 'leave',
      component: Leave,
      meta: {
        keepAlive: true,
        menuType: 'manager'
      }
    },
    {
      path: '/attendance-management/record',
      name: 'record',
      component: Record,
      meta: {
        keepAlive: true,
        menuType: 'manager'
      }
    },
    {
      path: '/attendance-management/statistics',
      name: 'statistics',
      component: Statistics,
      meta: {
        keepAlive: true,
        menuType: 'manager'
      }
    },
    {
      path: '/attendance-management/statistics/user',
      name: 'userAttendance',
      component: userAttendance,
      meta: {
        keepAlive: true,
        menuType: 'manager'
      }
    },

    {
      path: '/home-view-user',
      name: '用户首页',
      component: HomeViewUser,
      meta: {
        keepAlive: true,
        menuType: 'user'
      }
    },
    {
      path: '/Apply/AddApply',
      name: '添加申请',
      component: AddApply,
      meta: {
        keepAlive: true,
        menuType: 'user'
      }
    },
    {
      path: '/Apply/ApplyList',
      name: '所有请假申请',
      component: ApplyList,
      meta: {
        keepAlive: true,
        menuType: 'user'
      }
    },
    {
      path: '/SignData',
      name: '上班打卡',
      component: SignData,
      meta: {
        keepAlive: true,
        menuType: 'user'
      }
    },
    {
      path: '/ChangeInfo',
      name: '个人信息修改',
      component: ChangeInfo,
      meta: {
        keepAlive: true,
        menuType: 'user'
      }
    },
    {
      path: '/UserHome',
      name: '用户主页',
      component: UserHome,
      meta: {
        keepAlive: true,
        menuType: 'user'
      }
    }
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
