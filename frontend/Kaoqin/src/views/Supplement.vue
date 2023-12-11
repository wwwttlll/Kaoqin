<template>
    <div>
        <h2>补签</h2>
        <el-form :model="form" label-position="top">
            <el-form-item label="用户">
                <el-input v-model="form.user" placeholder="请输入用户"></el-input>
            </el-form-item>
            <el-form-item label="时间">
                <el-date-picker v-model="form.time" type="datetime" placeholder="选择时间"></el-date-picker>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitCheckin">提交补签</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
  
<script setup>
import { ref } from 'vue';
import { ElForm, ElFormItem, ElInput, ElDatePicker, ElButton } from 'element-plus';

const form = ref({
    user: '',
    time: null,
});

const submitCheckin = () => {
    // 发送补签信息到后端API
    console.log('提交补签信息', form.value);
    // 你需要使用实际的API请求来提交数据
};
</script>
  
<style scoped>
/* 添加样式 */
</style>
  