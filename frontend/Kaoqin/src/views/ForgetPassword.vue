<template>

  <el-card class="box-card">

    <h1 class="mb-3">Forgot Password</h1>

    <el-form class="form">
    
      <el-form-item label="Email">
        <el-input v-model="email" placeholder="Email"/>
      </el-form-item>

      <el-form-item label="New Password">
        <el-input v-model="newPassword" type="password" placeholder="New Password"/>
      </el-form-item>

      <el-row :gutter="20">
      <el-col :span="24">
        <el-row justify="center">
          <el-button @click="onSubmit" class="password-btn" type="primary" round>Update Password</el-button>
        </el-row>
      </el-col>
      <el-col :span="24">
        <router-link to="/login">Login Now</router-link>
      </el-col>
      </el-row>

    </el-form>

  </el-card>

</template>

<script>
import { ref } from 'vue'
import { resetPassword } from '@/apis/forget.js'
export default {
  async onSubmit() {
    const { email, newPassword } = this

    try {
      await resetPassword(email, newPassword)
      
      this.$message.success('密码重置成功')
      
    } catch(error) {
      this.$message.error(error.message)
    }
  },
  setup() {
    const email = ref('')
    const newPassword = ref('')

    return {
      email, 
      newPassword
    }
  }
}
</script>

<style>

</style>