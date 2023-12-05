<script setup>
import { ref, onBeforeUpdate } from 'vue'
import Menu from '@/components/menu.vue'
</script>
<template>
  <div class="common-layout">
    <el-container>
      <el-header>Header</el-header>
      <el-container>
        <el-aside width="400px">
          <Menu />
        </el-aside>
        <el-main>
          <router-view> </router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>



<style>
.el-header {
  position: relative;
  width: 100%;
  height: 60px;
}

.el-aside {
  display: block;
  position: absolute;
  left: 0;
  top: 60px;
  bottom: 0;
  width: 100%;
}

.el-main {
  position: absolute;
  left: 200px;
  right: 0;
  top: 60px;
  bottom: 0;
  overflow-y: scroll;
}
</style>
