<template>
    <div>
        <h2>补签</h2>
        <el-form label-position="top">
            <el-form-item label="用户">
                <el-input v-model="username" placeholder="请输入用户"></el-input>
            </el-form-item>
            <el-form-item label="时间">
                <el-date-picker v-model="date" type="datetime" placeholder="选择时间"></el-date-picker>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitCheckin">提交补签</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
  
<script setup>
import { ref } from 'vue';
import { supplement } from "@/apis/sign";

const username = ref("");
const date = ref();

const submitCheckin = async () => {
    const form = new FormData();
    form.append("username", username.value)
    form.append("date", date.value)
    console.log(username.value, date.value)
    console.log('提交补签信息', form);
    const res = await supplement(form);
    console.log(res);
    if (res.data == "补签成功") {
        alert('补签成功')
    }
};
</script>
  
<style scoped></style>
  