<template>
    <div>
        <h2>用户列表</h2>
        <ul>
            <li v-for="user in userList" :key="user.id">
                {{ user.name }}
                <el-button type="text" @click="showDetails(user.id)">详情</el-button>
                <el-button type="text" @click="showStatistics(user.id)">统计</el-button>
            </li>
        </ul>

        <!-- 详情小卡片 -->
        <el-dialog v-if="detailDialogVisible" title="考勤详情" width="30%" @close="closeDialog('detailDialogVisible')">
            <p>{{ selectedUserName }} 的考勤详情</p>
            <el-calendar v-if="selectedUserId" :value="currentMonth" :dates="attendanceDates"
                @select="handleDateSelect"></el-calendar>
            <el-button @click="closeDialog('detailDialogVisible')">关闭</el-button>
        </el-dialog>

        <!-- 统计柱形图 -->
        <el-dialog v-if="statisticsDialogVisible" title="考勤统计" width="50%" @close="closeDialog('statisticsDialogVisible')">
            <el-chart :data="statisticsData" type="bar" height="300px"></el-chart>
            <el-button @click="closeDialog('statisticsDialogVisible')">关闭</el-button>
        </el-dialog>
    </div>
</template>
  
<script setup>
import { ref } from 'vue';

const userList = ref([
    { id: 1, name: 'User1' },
    { id: 2, name: 'User2' },
]);

const selectedUserId = ref(null);
const selectedUserName = ref('');
const detailDialogVisible = ref(true);
const statisticsDialogVisible = ref(false);

const showDetails = (userId) => {
    console.log(userId);
    selectedUserId.value = userId;
    selectedUserName.value = userList.value.find(user => user.id === userId).name;
    detailDialogVisible.value = true;
};

const showStatistics = (userId) => {
    selectedUserId.value = userId;
    selectedUserName.value = userList.value.find(user => user.id === userId).name;
    statisticsDialogVisible.value = true;
};

const closeDialog = (dialogName) => {
    // 关闭对话框
    if (dialogName === 'detailDialogVisible') {
        detailDialogVisible.value = false;
    } else if (dialogName === 'statisticsDialogVisible') {
        statisticsDialogVisible.value = false;
    }
};

const statisticsData = ref({
    labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
    datasets: [
        {
            label: '成功打卡次数',
            data: [5, 8, 15, 12, 7, 10, 6, 8, 12, 9, 11, 14],
        },
        // ... (more datasets for different statistics)
    ],
});
</script>
  
<style scoped>
/* 添加样式 */
</style>
  