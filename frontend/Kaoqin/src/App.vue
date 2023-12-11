<script setup>
// import { ref, onBeforeUpdate } from 'vue'
// import Menu from '@/components/menu.vue'
</script>
<!-- <template>
  <div class="common-layout">
    <el-container>
      <el-aside width="200px"><Menu /></el-aside>
      <el-container>
        <el-header>Header</el-header>
        <el-main>Main</el-main>
      </el-container>
    </el-container>
  </div>
</template> -->
<template>
  <div class="main"></div>
  <router-view></router-view>
</template>



<style>
.main {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  width: 100%;
}
</style>
