<script lang="ts" setup>
import {
    Document,
    Menu as IconMenu,
    Location,
    Setting,
} from '@element-plus/icons-vue'
const handleOpen = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
    console.log(key, keyPath)
}
</script>
<template>
    <el-row class="tac">
        <el-col :span="24">
            <el-menu active-text-color="#ffd04b" background-color="#545c64" class="el-menu-vertical-demo" default-active="2"
                text-color="#fff" @open="handleOpen" @close="handleClose">

                <el-menu-item index="1">
                    <router-link to="/">
                        <el-icon><icon-menu /></el-icon>
                        <span>首页</span>
                    </router-link>
                </el-menu-item>

                <el-menu-item index="2">
                    <router-link to="/UserHome">
                        <el-icon>
                            <User />
                        </el-icon>
                        <span>用户主页</span>
                    </router-link>
                </el-menu-item>

                <el-sub-menu index="3">
                    <template #title>
                        <el-icon>
                            <location />
                        </el-icon>
                        <span>请假申请</span>
                    </template>

                    <el-menu-item-group title="Group One">
                        <router-link to="/Apply/AddApply">
                            <el-menu-item index="3-1">添加申请</el-menu-item>
                        </router-link>
                        <router-link to="/Apply/ApplyList">
                            <el-menu-item index="3-2">所有请假申请</el-menu-item>
                        </router-link>
                    </el-menu-item-group>

                </el-sub-menu>

                <el-menu-item index="4">
                    <router-link to="/SignData">
                        <el-icon>
                            <User />
                        </el-icon>
                        <span>员工打卡</span>
                    </router-link>
                </el-menu-item>

                <el-menu-item index="5">
                    <router-link to="/ChangeInfo">
                        <el-icon>
                            <User />
                        </el-icon>
                        <span>个人信息修改</span>
                    </router-link>
                </el-menu-item>

            </el-menu>
        </el-col>
    </el-row>
</template>

