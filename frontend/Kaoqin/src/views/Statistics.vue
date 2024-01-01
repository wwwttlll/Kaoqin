<template>
    <div>
        <el-table :data="userList" style="width: 100%">
            <el-table-column label="用户名" prop="username"></el-table-column>
            <el-table-column label="本月考勤次数" prop="attendance_count"></el-table-column>
            <el-table-column label="操作">
                <template v-slot="{ row }">

                    <el-button @click="navigateToTargetPage(row)">查看详情</el-button>

                </template>
            </el-table-column>
        </el-table>
    </div>
</template>
  
<script setup>
import { onMounted, ref } from 'vue';
import { useRouter } from "vue-router"
import { signstatistics } from "@/apis/sign"
const router = useRouter();

import { useFilterStore } from '@/stores/stores'
import pinia from '@/stores/index.js'
const User = useFilterStore(pinia)

const userList = ref([
    {
        user_id: "1", username: 'User1', attendance_count: 10
    },
    {
        user_id: "2", username: 'User2', attendance_count: 15
    },
    // Add more users with attendance details...
]);



onMounted(async () => {
    const res = await signstatistics();
    console.log(res);
    userList.value = res.data;
})


const navigateToTargetPage = (user) => {
    User.userid = user.user_id
    router.push({
        path: '/attendance-management/statistics/user',
        
    })

}
</script>
<style scope></style>