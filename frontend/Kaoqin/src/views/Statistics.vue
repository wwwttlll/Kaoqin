<template>
    <div>
        <el-table :data="userList" style="width: 100%">
            <el-table-column label="用户名" prop="username"></el-table-column>
            <el-table-column label="本月考勤次数" prop="attendanceCount"></el-table-column>
            <el-table-column label="操作">
                <template v-slot="{ row }">

                    <el-button @click="navigateToTargetPage(row)">查看详情</el-button>

                </template>
            </el-table-column>
        </el-table>
    </div>
</template>
  
<script setup>
import { ref } from 'vue';
import { useRouter } from "vue-router"

const router = useRouter();

const userList = ref([
    {
        userid: "1", username: 'User1', attendanceCount: 10, attendanceDetails: [
            { date: '2023-01-01', status: '出勤' },
            { date: '2023-01-02', status: '请假' },
            // ... 其他日期和状态
        ]
    },
    {
        userid: "2", username: 'User2', attendanceCount: 15, attendanceDetails: [
            { date: '2023-01-01', status: '出勤' },
            { date: '2023-01-02', status: '请假' },
            // ... 其他日期和状态
        ]
    },
    // Add more users with attendance details...
]);






const navigateToTargetPage = (user) => {

    router.push({
        path: '/attendance-management/statistics/user',
        query: { userId: '123' }
    })

}
</script>
<style scope></style>