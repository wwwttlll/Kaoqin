<template>
    <div>
        <h2>考勤记录</h2>

        <!-- 检索表单 -->
        <el-form :model="searchForm" ref="searchForm" inline>
            <el-form-item label="用户">
                <el-input v-model="user"></el-input>
            </el-form-item>
            <el-form-item label="日期">
                <el-date-picker v-model="date" type="date" placeholder="选择日期"></el-date-picker>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="search">搜索</el-button>
            </el-form-item>
        </el-form>

        <!-- 考勤记录表格 -->
        <el-table :data="attendanceRecords" style="width: 100%" stripe>
            <el-table-column prop="username" label="用户"></el-table-column>
            <el-table-column prop="time" label="日期"></el-table-column>
            <el-table-column prop="status" label="考勤状态"></el-table-column>
        </el-table>
    </div>
</template>
  
<script setup>
import { ref, onMounted } from 'vue';
import { selectallsign, selectsignbyuser } from "@/apis/sign"
const attendanceRecords = ref([
    { user: 'User1', date: '2023-01-01', status: '出勤' },
    { user: 'User2', date: '2023-01-01', status: '迟到' },
    { user: 'User1', date: '2023-01-02', status: '出勤' },

]);
onMounted(async () => {
    // 页面加载时默认查询所有用户
    const res = await selectallsign();
    attendanceRecords.value = res.data;
});
const user = ref("")
const date = ref("")

const search = async () => {
    // 根据搜索条件进行过滤或发送后端请求
    const data = new FormData();
    console.log(user.value, date.value);
    data.append("username", user.value);
    data.append("date", date.value);
    const res = await selectsignbyuser(data);
    attendanceRecords.value = res.data;
};

</script>
  
<style scoped>
/* 添加样式 */
</style>
  