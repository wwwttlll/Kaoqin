<template>
    <div>

        <el-card class="notification-card">
            <p slot="header" class="card-header">最新通知</p>
            <ul class="notification-list">
                <li v-for="(notification, index) in notifications" :key="index">
                    {{ notification }}
                </li>
            </ul>
        </el-card>


    </div>
</template>
  
<script setup>

import { ref } from 'vue';
import FullCalendar from '@fullcalendar/vue3';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction'
const notifications = ref([
    "上班时间：每天上午9:00开始。",
    "下班时间：每天下午6:00结束。",
    "午休时间：中午12:00 - 1:00。",
    '假期提醒：请提前申请假期，确保顺利安排工作计划。',
]);
const userList = ref([
    {
        username: 'User1', attendanceCount: 10, attendanceDetails: [
            { date: '2023-01-01', status: '出勤' },
            { date: '2023-01-02', status: '请假' },
            // ... 其他日期和状态
        ]
    },
    {
        username: 'User2', attendanceCount: 15, attendanceDetails: [
            { date: '2023-01-01', status: '出勤' },
            { date: '2023-01-02', status: '请假' },
            // ... 其他日期和状态
        ]
    },
    // Add more users with attendance details...
]);
const calendarOptions = {
    plugins: [dayGridPlugin, interactionPlugin],
    initialView: 'dayGridMonth'
}
</script>
  
<style scoped>
/* 这里是您的样式，scoped属性确保样式只适用于当前组件 */
h1 {
    color: #333;
}

p {
    font-size: 16px;
    margin-top: 10px;
}

/* 示例图片样式 */
el-image {
    max-width: 100%;
    height: auto;
    margin-top: 20px;
}

/* 最新通知样式 */
.notification-card {
    margin-top: 20px;
}

.card-header {
    background-color: #409EFF;
    color: #fff;
}

.notification-list {
    list-style-type: none;
    padding: 0;
}

.notification-list li {
    margin-bottom: 8px;
}
</style>
  