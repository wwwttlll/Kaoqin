<template>
  <div>
    <h3>正在审核:</h3>
    <el-table :data="page1" style="width: 100%" :row-class-name="tableRowClassName">
      <el-table-column prop="leave_id" label="申请序号"></el-table-column>
      <el-table-column prop="user_id" label="用户名"></el-table-column>
      <el-table-column prop="begin_time" label="开始时间" :formatter="formatDate"></el-table-column>
      <el-table-column prop="end_time" label="结束时间" :formatter="formatDate"></el-table-column>
      <el-table-column prop="status" label="请假状态"></el-table-column>
      <el-table-column prop="type" label="请假类型" :formatter="formatType"></el-table-column>
      <el-table-column prop="reason" label="请假原因"></el-table-column>
    </el-table>

    <h3>已处理:</h3>
    <el-table :data="page" style="width: 100%" :row-class-name="tableRowClassName">
      <el-table-column prop="leave_id" label="申请序号"></el-table-column>
      <el-table-column prop="user_id" label="用户名"></el-table-column>
      <el-table-column prop="begin_time" label="开始时间" :formatter="formatDate"></el-table-column>
      <el-table-column prop="end_time" label="结束时间" :formatter="formatDate"></el-table-column>
      <el-table-column prop="status" label="请假状态"></el-table-column>
      <el-table-column prop="type" label="请假类型" :formatter="formatType"></el-table-column>
      <el-table-column prop="reason" label="请假原因"></el-table-column>
    </el-table>
  </div>
</template>

<script>
import { useUserStore } from '@/stores/stores';
import pinia from '../stores/index.js';
import httpInstance from '@/utils/http.js';
import { ref } from 'vue';
import { onMounted } from 'vue';

function rTime(date) {
  var adjusted_date = new Date(date);
  var timezone_offset = adjusted_date.getTimezoneOffset() * 60 * 1000;
  adjusted_date.setTime(adjusted_date.getTime() + timezone_offset - (8 * 60 * 60 * 1000)); // 将时区调整为东八区
  return adjusted_date.toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '');
}
export default {

  setup() {
    const page1 = ref([]);
    const page = ref([]);
    const userStore = useUserStore(pinia);

    const loaddata = () => {
      httpInstance.get('/Apply/ApplyList/' + userStore.userid).then((res) => {
        const data = res.data;
        console.log(data); // 打印返回的数据，检查字段是否正确

        // 根据请假状态将数据分配给不同的数组
        page1.value = data.filter(item => item.status === '待批');
        page.value = data.filter(item => item.status === '通过' || item.status === '拒绝');

      });
    };

    const formatDate = (row, column) => {
      return rTime(row[column.property]);
    };
    onMounted(() => {
      loaddata();
    });

    const formatType = (row) => {
      if (row.type == '事假') {
        return '事假';
      } else if (row.type == '病假') {
        return '病假';
      }
    };

    const tableRowClassName = ({ row, rowIndex }) => {
      if (row.status === '拒绝') {
        return 'warning-row';
      } else if (row.status === '通过') {
        return 'success-row';
      } else if (row.status === '待批') {
        return 'loading-row';
      }
    };


    return {
      page1,
      page,
      userStore,
      loaddata,
      formatType,
      tableRowClassName,
      formatDate
    };
  },
};
</script>

<style>
.el-table .warning-row {
  background-color: rgb(243, 172, 170);
}

.el-table .loading-row {
  background-color: oldlace;
}

.el-table .success-row {
  background-color: #f0f9eb;
}

.el-table td {
  white-space: nowrap;
}
</style>