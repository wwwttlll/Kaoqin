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
  
<script>
export default {
    data() {
        return {
            searchText: "",
            users: [],
            totalUsers: 0,
            currentPage: 1,
            pageSize: 10,
            editDialogVisible: false,
            editedUser: null,
        };
    },
    methods: {
        async searchUsers() {
            try {
                // ... (Same as before)

                this.totalUsers = this.users.length;
            } catch (error) {
                this.users = [];
                this.totalUsers = 0;
                console.error(error);
            }
        },
        handleSizeChange(val) {
            this.pageSize = val;
            this.currentPage = 1;
        },
        handleCurrentChange(val) {
            this.currentPage = val;
        },
        editUser(user) {
            this.editedUser = user;
            this.editDialogVisible = true;
        },
    },
};
</script>
  
<style scoped>
.user-view {
    padding: 20px;
}

/* Add additional styles as needed */
</style>
  