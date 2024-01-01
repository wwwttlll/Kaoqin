<template>
    <div>
        <el-row>
            <el-col :span="12" style="margin-bottom: 10px">
                <el-button type="primary" @click="changeState(0)" :disabled="!isHere">上班打卡</el-button>
                <el-button type="success" @click="changeState(1)" :disabled="isHere">下班打卡</el-button>
            </el-col>
        </el-row>
        <el-table :data="page" border style="width: 100%" :default-sort="{ prop: 'time', order: 'descending' }">
            <el-table-column prop="signId" label="签到序号"></el-table-column>
            <el-table-column prop="userId" label="工号"></el-table-column>
            <el-table-column prop="time" label="打卡时间" sortable :formatter="formatDate"></el-table-column>
            <el-table-column prop="type" label="打卡类型" :formatter="formatType"></el-table-column>
            <el-table-column prop="status" label="签到状态"></el-table-column>
        </el-table>
    </div>
</template>
  
<script>
import { useUserStore } from '@/stores/stores'
import pinia from '../stores/index.js'
import httpInstance from '@/utils/http.js';
import { ref, onMounted } from 'vue';
import { ElMessage } from 'element-plus';
const user = useUserStore(pinia)

export default {
    setup() {
        const page = ref([]);
        const isHere = ref(false);
        const userid = ref('');

        const loadData = () => {
            const userid = user.userid;
            httpInstance.get('/getSignRecords/' + userid).then(res => {
                console.log(res.data);
                page.value = res.data;
            });
        };

        const loadState = () => {
            const userid = user.userid;
            httpInstance.get('/getSignType/' + userid).then(res => {
                if (res.data == 0) {
                    this.type = '签到';
                    isHere.value = false;
                } else if (res.data == 1) {
                    this.type = '签退';
                    isHere.value = true;
                }
            });
        };

        const formatType = (row) => {
            if (row.type == '签到') {
                return '上班打卡';
            } else if (row.type == '签退') {
                return '下班打卡';
            }
        };

        const formatDate = (row) => {
            var date = new Date(row.time);
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            var hour = date.getHours();
            hour = hour < 10 ? '0' + hour : hour;
            var minute = date.getMinutes();
            minute = minute < 10 ? '0' + minute : minute;
            var second = date.getSeconds();
            second = second < 10 ? '0' + second : second;
            return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;
        };

        const changeState = (num) => {
            const userId = user.userid;
            const type = num === 0 ? 'signIn' : 'signOut';

            if (type === 'signIn') {
                // 上班打卡
                httpInstance.post('/' + type + '?userId=' + userId).then(res => {
                    if (res.data) {
                        ElMessage.success('上班打卡成功');
                        loadData();
                        loadState();
                        isHere.value = false; // 设置为上班状态
                    } else {
                        ElMessage.error('上班打卡失败');
                    }
                });
            } else {
                // 下班打卡
                httpInstance.post('/' + type + '?userId=' + userId).then(res => {
                    if (res.data) {
                        ElMessage.success('下班打卡成功');
                        loadData();
                        loadState();
                        isHere.value = true; // 设置为下班状态
                    } else {
                        ElMessage.error('下班打卡失败');
                    }
                });
            }
        };

        onMounted(() => {
            loadData();
            loadState();
        });

        return {
            page,
            isHere,
            formatType,
            formatDate,
            changeState,
        };
    }
};
</script>
  
<style></style>