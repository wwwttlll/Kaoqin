<template>
  <el-form ref="apply" :model="apply" label-width="100px">
  <el-form-item label="员工ID">
<el-input v-model="apply.user_id" placeholder="请输入员工ID"></el-input>
</el-form-item>
  <el-form-item label="请假开始时间">
    <el-col :span="10">
      <el-date-picker type="date" placeholder="选择日期" v-model="apply.begin_time" style="width: 100%;"></el-date-picker>
    </el-col>
  </el-form-item>
  <el-form-item label="请假结束时间">
    <el-col :span="10">
      <el-date-picker type="date" placeholder="选择日期" v-model="apply.end_time" style="width: 100%;"></el-date-picker>
    </el-col>
  </el-form-item>
  <el-form-item label="请假原因">
    <el-input v-model="apply.reason"></el-input>
  </el-form-item>
  <el-form-item label="请假类型">
    <el-select v-model="apply.type" placeholder="请选择类型">
      <el-option label="事假" value="事假"></el-option>
      <el-option label="病假" value="病假"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">立即创建</el-button>
    <el-button @click="resetForm">重置</el-button>
  </el-form-item>
</el-form>
</template>

<script>
import httpInstance from '@/utils/http.js';
export default {
data() {
  return {
    apply: {}
  };
},
created() {
  if (this.$route.query.type != null) {
    this.apply.type = this.$route.query.type;
  }
},
methods: {
  onSubmit() {
    var data = {
      begin_time: this.apply.begin_time,
      end_time: this.apply.end_time,
      reason: this.apply.reason,
      type: this.apply.type,
      user_id: this.apply.user_id,
    };
    httpInstance.post("/Apply/AddApply", data).then(
      (res) => {
        if (res.status == 200) {
          this.$message({
            message: "添加成功",
            type: "success"
          });
        } else {
          this.$message({
            message: "添加失败",
            type: "error"
          });
        }
      }
    ).catch(error => {
      console.log(error);
      this.$message({
        message: "添加失败",
        type: "error"
      });
    });
  },
  resetForm() {
    this.apply = {};
  }
}
};
</script>