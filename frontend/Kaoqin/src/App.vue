<script setup>
import { ref, onBeforeUpdate } from 'vue'
// import { ref, onBeforeUpdate } from 'vue-router'
import Menu from '@/components/menu.vue'

const isLoginPage = ref(false)
const isRegisterPage = ref(false)

// 在路由更新前检查当前页面是否是 login 或 register
// onBeforeUpdate((to, from, next) => {
//   console.log(to.name)
//   isLoginPage.value = to.name === 'login'
//   isRegisterPage.value = to.name === 'register'
//   next()
// })
</script>
<template>
  <div class="app-container">
    <header>
      <div v-if="$route.meta.keepAlive">
        <Menu/>
    </div>
    </header>

    <div class="main-content">
      <!-- RouterView 渲染页面内容 -->
      <RouterView />
    </div>
  </div>
</template>



<style>
.app-container {
  display: flex;
}

header {
  flex: 0 0 auto;
}



.main-content {
  flex: 1;
  padding: 20px;
  margin-left: 250px;
  /* 确保主体内容区域不被菜单栏覆盖 */
}
</style>
