<template>
    <el-table :data="leaveRequests" style="width: 100%" stripe>
        <el-table-column prop="username" label="用户"></el-table-column>
        <el-table-column prop="begin_time" label="开始时间"></el-table-column>
        <el-table-column prop="end_time" label="结束时间"></el-table-column>
        <el-table-column prop="type" label="类型"></el-table-column>
        <el-table-column label="操作">
            <template #default="scope">
                <el-button v-if="scope.row.status === '待批'" type="success" @click="approveLeave(scope.row)">
                    通过
                </el-button>
                <el-button v-if="scope.row.status === '待批'" type="danger" @click="rejectLeave(scope.row)">
                    驳回
                </el-button>
                <span v-else>{{ scope.row.status }}</span>
            </template>
        </el-table-column>
    </el-table>
    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage"
        :page-sizes="[5, 10, 20, 50]" :page-size="pageSize" :total="leaveRequests.length"
        layout="total, sizes, prev, pager, next, jumper"></el-pagination>
</template>
        

  
<script setup>
import { ref, onMounted } from 'vue';
import { updateexcuse, getexcuse } from "@/apis/excuse.js"
const leaveRequests = ref([
    { user_id: 1, username: 'User1', begin_time: '2023-01-01', end_time: '2023-01-05', status: '未审核' },
    { user_id: 2, username: 'User2', begin_time: '2023-02-01', end_time: '2023-02-05', status: '已通过' },
    { user_id: 3, username: 'User3', begin_time: '2023-03-01', end_time: '2023-03-05', status: '已驳回' },
    // ... (more leave requests)
]);

const pagedLeaveRequests = ref([]);
const pageSize = ref(5);
const currentPage = ref(1);

const handleSizeChange = (val) => {
    pageSize.value = val;
    currentPage.value = 1;
    updatePagedLeaveRequests();
};

const handleCurrentChange = (val) => {
    currentPage.value = val;
    updatePagedLeaveRequests();
};

const updatePagedLeaveRequests = () => {
    const startIndex = (currentPage.value - 1) * pageSize.value;
    const endIndex = startIndex + pageSize.value;
    pagedLeaveRequests.value = leaveRequests.value.slice(startIndex, endIndex);
};

onMounted(async () => {
    const res = await getexcuse();
    leaveRequests.value = res.data
    updatePagedLeaveRequests();
});

const approveLeave = async (leaveRequest) => {
    console.log('通过请假请求', leaveRequest);
    leaveRequest.status = "通过"
    const res = await updateexcuse(leaveRequest);
    console.log(res.data)
};

const rejectLeave = async (leaveRequest) => {
    console.log('驳回请假请求', leaveRequest);
    leaveRequest.status = "驳回"
    const res = await updateexcuse(leaveRequest);
    console.log(res.data)
};
</script>
  
<style scoped>

</style>
  