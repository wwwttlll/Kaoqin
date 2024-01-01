<template>
    <el-form ref="updateForm" :model="form" label-width="100px">
      <el-form-item label="手机号码">
        <el-input v-model="form.phoneNumber" placeholder="请输入手机号码" @input="handleUpdate($event)"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="form.email" placeholder="请输入邮箱"  @input="handleUpdate($event)"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm">保存</el-button>
        <el-button @click="resetForm">重置</el-button>
      </el-form-item>
    </el-form>
  </template>
  
  <script>
  import { defineComponent, ref } from 'vue';
  import pinia from '../stores/index.js'
  import { useUserStore } from '@/stores/stores';
  import httpInstance from '@/utils/http.js';
  import { ElMessage } from 'element-plus';
  const user = useUserStore(pinia)
  
  export default defineComponent({
    name: 'EmployeeInfoUpdate',
    setup() {
        
      const userid = user.userid;
      console.log(userid);
      const form = ref({
        user_id: userid,
        phoneNumber: '',
        email: '',
      });
  
      function submitForm() {
        httpInstance.post('/ChangeInfo/' + userid, form.value)
          .then(response => {
            console.log('form:', form);
            if (response.status === 200) {
              ElMessage.success('员工信息已更新');
            } else {
              ElMessage.error('员工信息更新失败');
            }
          })
          .catch(error => {
            console.error(error);
            ElMessage.error('员工信息更新失败');
          });
      }
  
      function handleUpdate(e) {
        this.$forceUpdate();
      }
  
      function resetForm() {
        form.value.phoneNumber = '';
        form.value.email = '';
      }
  
      return {
        form,
        submitForm,
        resetForm,
        handleUpdate,
      };
    },
  });
  </script>