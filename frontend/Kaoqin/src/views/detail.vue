<template>
    <!-- <h1>{{ userId.value }}</h1> -->
    <FullCalendar :options="calendarOptions" :events="eventSource" />
</template>
<script setup>
import { ref, onMounted, watchEffect, onActivated } from 'vue';

import FullCalendar from '@fullcalendar/vue3';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';
import { statisticsbyuser } from "@/apis/sign";

import { useFilterStore } from '@/stores/stores'
import pinia from '@/stores/index.js'
const user = useFilterStore(pinia)

const eventSource = ref([]);
const currentAttendance = ref([])
watchEffect(async () => {
    const userid = new FormData();
    userid.append("userid", user.userid);
    const res = await statisticsbyuser(userid);
    currentAttendance.value = res.data
    console.log(currentAttendance.value);


    const events = currentAttendance.value.map((sign) => ({
        title: sign.status,
        start: new Date(sign.time),
    }));

    // Update event source
    eventSource.value = events;
    console.log(eventSource.value);
}
);

const handleEventContent = (arg) => {
    const colors = {
        '出勤': 'green',
        '迟到': 'red',
    };

    return {
        html: `<div style="color: ${colors[arg.event.title]};">${arg.event.title}</div>`,
    };
};

const calendarOptions = {
    plugins: [dayGridPlugin],
    initialView: 'dayGridMonth',
    headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
    },
    eventContent: handleEventContent,
};


</script>