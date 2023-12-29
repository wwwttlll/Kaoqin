<template>
    <div class="user-view">
        <el-input v-model="searchText" placeholder="请输入搜索关键词"></el-input>
        <el-button @click="searchUsers" type="primary">搜索</el-button>

        <el-table :data="users" style="width: 100%" stripe>
            <el-table-column prop="username" label="用户名"></el-table-column>
            <el-table-column prop="email" label="邮箱"></el-table-column>
            <el-table-column prop="phone_number" label="电话"></el-table-column>
            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button @click="editUser(scope.row)" type="text">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="currentPage"
            :page-sizes="[10, 20, 30, 40]" :page-size="pageSize" layout="total, sizes, prev, pager, next, jumper"
            :total="totalUsers"></el-pagination>

        <el-dialog v-model="editDialogVisible" title="编辑用户信息">
            <!-- Your form components for editing user information -->
        </el-dialog>
    </div>
</template>
<script setup>
import { ref, onMounted } from 'vue';
import { selectuserbyusername, selectuserbyemail, selectuserbyphone, selectallusers } from '@/apis/selectuser';


const searchText = ref("");
const users = ref([]);
const totalUsers = ref(0);
const currentPage = ref(1);
const pageSize = ref(10);
const editDialogVisible = ref(false);
const editedUser = ref();
const searchUsers = async () => {
    try {
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        const phoneRegex = /^\d{10,}$/;
        const usernameRegex = /^[a-zA-Z0-9_]+$/;

        if (emailRegex.test(searchText.value)) {
            const email = new FormData();
            email.append("email", searchText.value);
            const res = await selectuserbyemail(email);
            users.value = res.data
        } else if (phoneRegex.test(searchText.value)) {
            const phone = new FormData();
            phone.append("phone", searchText.value);
            const res = await selectuserbyphone(phone);
            users.value = res.data
        } else if (usernameRegex.test(searchText.value)) {
            const username = new FormData();
            username.append("username", searchText.value);
            const res = await selectuserbyusername(username);
            users.value = res.data
            console.log(users.value);
        } else {
            const username = new FormData();
            username.append("username", searchText.value);
            const res = await selectuserbyusername(username);
            users.value = res.data
        }
        totalUsers.value = users.length;
    } catch (error) {
        users.value = [];
        totalUsers.value = 0;
        console.error(error);
    }
};

const handleSizeChange = (val) => {
    pageSize.value = val;
    currentPage.value = 1;
};

const handleCurrentChange = (val) => {
    currentPage.value = val;
};

const editUser = (user) => {
    editedUser.value = user;
    editDialogVisible.value = true;
};

onMounted(async () => {
    // 页面加载时默认查询所有用户
    const res = await selectallusers();
    users.value = res.data
    console.log(res);
    console.log(users.value);
});
</script>

  
<style scoped>
.user-view {
    padding: 20px;
}
</style>
  