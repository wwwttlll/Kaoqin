<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Menu from "@/components/Menu.vue"
import Header from "@/components/Header.vue"
</script>
<template>
  <div class="common-layout">
    <el-container v-if="$route.meta.keepAlive">
      <el-aside width="250px">
        <Menu />
      </el-aside>
      <el-container>
        <el-header>
          <Header />
        </el-header>
        <el-main>
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
    <router-view v-if="!$route.meta.keepAlive"></router-view>
  </div>
</template>
<style>
.common-layout {
  height: 100vh;
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  width: 100%;
}

/* 调整布局 */
.el-container {
  height: 100%;
}

.el-aside {
  height: 100%;
}

.el-header {
  background-color: #f0f0f0;
}

.el-main {
  height: 100%;
}
</style>