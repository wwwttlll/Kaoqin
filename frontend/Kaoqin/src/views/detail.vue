<template>
    <h2>User Attendance Details for {{ userId }}</h2>
    <full-calendar :events="currentAttendance" :options="calendarOptions"></full-calendar>
</template>
<script>
import { ref, onMounted, watchEffect } from 'vue';

import FullCalendar from '@fullcalendar/vue3';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import { selectsignbyuserid } from "@/apis/sign";
import { useRoute } from 'vue-router';
const route = useRoute();
const userId = ref(null);

watchEffect(() => {
    console.log("111111");
    // console.log(route.value);
    // userId.value = route.query;
    // console.log(userId.value);
});
const userList = ref(
    {
        username: 'User1', attendanceCount: 10, attendanceDetails: [
            { date: '2023-01-01', status: '出勤' },
            { date: '2023-01-02', status: '请假' },
        ]
    },

);


const calendarOptions = {
    plugins: [dayGridPlugin, interactionPlugin],
    initialView: 'dayGridMonth ',
    headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
    }
};
const currentAttendance = ref([]);
const showAttendanceDetails = () => {
    currentAttendance.value = userList.attendanceDetails.value; // Set the attendance details for the current user
    dialogVisible.value = true; // Show the dialog
};
</script>