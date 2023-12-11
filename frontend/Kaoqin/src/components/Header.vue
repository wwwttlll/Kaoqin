<template>
    <!-- 左侧内容，你可以根据需要添加 -->
    <el-row :gutter="20">
        <el-col :span="16">
            <div class="left-content">
                面包屑
            </div>
        </el-col>
        <el-col :span="8">
            <div class="right-content" v-if="user.isLoggedIn">
                <!-- 头像和下拉菜单 -->
                <el-dropdown @command="handleCommand">
                    <el-avatar class="avatar">User</el-avatar>
                    <template #dropdown>
                        <el-dropdown-menu>
                            <el-dropdown-item command=" profile">
                                个人信息
                            </el-dropdown-item>
                            <el-dropdown-item command="logout">
                                <router-link to="/" @click="toggleLogin">Logout</router-link>
                            </el-dropdown-item>
                        </el-dropdown-menu>
                    </template>

                </el-dropdown>
            </div>
            <div class="right-content" v-else>
                <!-- 头像和下拉菜单 -->
                <router-link to="/">home</router-link>
                <router-link to="/login">Login</router-link>
                <router-link to="/register">Register</router-link>
            </div>
        </el-col>
    </el-row>
</template>
<script setup>
import { ref, watch } from 'vue'
import { useRouter } from 'vue-router'
import { useUserStore } from '../stores/stores'
import pinia from '../stores/index.js'

const router = useRouter()

const user = useUserStore(pinia)

function reloadPage() {
    router.replace(router.currentRoute.value.fullPath)
}
function toggleLogin() {
    user.isLoggedIn = !user.isLoggedIn
    isLoggedIn = user.isLoggedIn
    reloadPage()
}
watch(user.isLoggedIn, (newValue, oldValue) => {
    if (newValue !== oldValue) {
        reloadPage()
    }
})

// const headerBackgroundColor = ref('#409EFF'); // 初始背景颜色
const handleCommand = (command) => {
    if (command === 'profile') {
        // 处理个人信息点击事件，跳转到个人信息页面或者弹出个人信息模态框
        goToProfile();
    } else if (command === 'logout') {
        // 处理退出登录点击事件，执行退出登录操作
        logout();
    }
};

const goToProfile = () => {
    // 实现个人信息的跳转或显示
};

const logout = () => {
    // 实现退出登录的操作
};
</script>

<style scoped>
/* .custom-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0;
    width: 100%;
}

.left-content {
    display: flex;
    align-items: center;
    width: 80%;
}

.right-content {
    display: flex;
    align-items: center;
    width: 20%;
} */

.avatar {
    cursor: pointer;
    /* 鼠标悬停时显示手型 */
}
</style>