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
                    <router-link to="/user-view">
                        <el-icon>
                            <User />
                        </el-icon>
                        <span>用户查看</span>
                    </router-link>
                </el-menu-item>

                <el-sub-menu index="3">
                    <template #title>
                        <el-icon>
                            <location />
                        </el-icon>
                        <span>考勤管理</span>
                    </template>

                    <el-menu-item-group title="Group One">
                        <router-link to="/attendance-management/supplement">
                            <el-menu-item index="3-1"> 补签</el-menu-item>
                        </router-link>
                        <router-link to="/attendance-management/leave">
                            <el-menu-item index="3-2">请假管理</el-menu-item>
                        </router-link>
                    </el-menu-item-group>

                    <el-menu-item-group title="Group Two">
                        <router-link to="/attendance-management/record">
                            <el-menu-item index="3-3">考勤记录</el-menu-item>
                        </router-link>
                        <router-link to="/attendance-management/statistics">
                            <el-menu-item index="3-4">考勤统计</el-menu-item>
                        </router-link>
                    </el-menu-item-group>

                </el-sub-menu>

                <el-menu-item index="4">
                    <router-link to="/settings">
                        <el-icon>
                            <setting />
                        </el-icon>
                        <span>设置</span>
                    </router-link>
                </el-menu-item>

            </el-menu>
        </el-col>
    </el-row>
</template>
  
  
<!-- <template>
    <el-row class="tac">
        <el-col :span="12">
            <el-menu active-text-color="#ffd04b" background-color="#545c64" class="el-menu-vertical-demo" default-active="2"
                text-color="#fff" @open="handleOpen" @close="handleClose">

                <el-menu-item index="1">
                    <router-link to="/">

                        <el-icon><icon-menu /></el-icon>


                        <span>首页</span>
                    </router-link>
                </el-menu-item>>

                <el-menu-item index="2">
                    <router-link to="user-view">
                        <el-icon>
                            <User />
                        </el-icon>

                        <span>用户查看</span>
                    </router-link>

                </el-menu-item>
                <el-sub-menu index="3">
                    <template #title>
                        <el-icon>
                            <location />
                        </el-icon>
                        <span>考勤管理
                        </span>
                    </template>
                    <el-menu-item-group title="Group One">
                        <router-link>
                            <el-menu-item index="3-1"> 补签</el-menu-item>
                        </router-link>
                        <router-link>
                            <el-menu-item index="3-2">请假管理</el-menu-item>
                        </router-link>

                    </el-menu-item-group>
                    <el-menu-item-group title="Group Two">
                        <router-link>
                            <el-menu-item index="3-3">考勤记录</el-menu-item>
                        </router-link>
                        <router-link>
                            <el-menu-item index="3-4">考勤统计</el-menu-item>
                        </router-link>


                    </el-menu-item-group>

                </el-sub-menu>
                <el-menu-item index="4">
                    <el-icon>
                        <setting />
                    </el-icon>
                    <span>设置</span>
                </el-menu-item>
            </el-menu>
        </el-col>

    </el-row>
</template> -->
