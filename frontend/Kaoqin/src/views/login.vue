<template>
    <el-card class="box-card">
        <h1 class="mb-3">登录</h1>

        <el-form class="form">
            <el-form-item label="用户名">
                <el-input v-model="username" placeholder="Username" />
            </el-form-item>

            <el-form-item label="密码">
                <el-input v-model="password" type="password" placeholder="Password" />
            </el-form-item>

            <el-row justify="space-between">
                <el-col :span="12">
                    <router-link to="/register">注册</router-link>
                </el-col>

                <el-col :span="12">
                    <router-link to="/forget">忘记密码</router-link>
                </el-col>
            </el-row>


            <el-button @click="onLogin" class="login-btn" type="primary" round>Login</el-button>
        </el-form>

    </el-card>
</template>
  
<script>
import { ref } from 'vue'
import { ElMessage } from 'element-plus'
import { login } from '@/apis/login'
import { useUserStore } from '../stores/stores.js'
import pinia from '../stores/index.js'
import * as jwt from "jwt-decode";
const user = useUserStore(pinia)
import { storeToRefs } from 'pinia'
function handleLoginSuccess(user_id, username, role) {
    user.isLoggedIn = true
    user.userid = user_id
    user.username = username
    user.userrole = role
}
export default {

    methods: {

        onLoginFailed() {
            alert('登录失败,请重试')
        },

        async onLogin() {
            console.log('Button clicked');
            const data = {
                username: this.username,
                password: this.password
            };

            function err_reflect(mes) {
                ElMessage({
                    message: mes,
                    type: 'fail'
                })
            }

            try {
                console.log(data)
                const response = await login(data)
                // 获取响应结果
                const res = response.data
                console.log(res)
                if (res.status) {
                    // const userData = response.data;
                    // console.log(JSON.parse(decoded))
                    const isConfirm = confirm('登录成功,确认后跳转首页?')

                    if (isConfirm) {
                        handleLoginSuccess(response.data.user_id, response.data.username, response.data.role)
                        console.log(user.isLoggedIn)
                        if (response.data.role === 0) {
                            this.$router.push('/')
                        } else if (response.data.role === 1) {
                            this.$router.push('/home-view-user')
                        }
                    } // 登录成功后跳转首页
                } else {
                    if (res.message == "密码格式错误") {
                        err_reflect("密码格式错误")
                    } else if (res.message == "wrong password") {
                        err_reflect("用户名或密码错误")
                    }
                }

            } catch (err) {
                // 登录失败,显示错误
                console.error(err)
                this.onLoginFailed()
            }
        }
    },

    setup() {
        const username = ref('')
        const password = ref('')
        return {
            username,
            password
        }
    }
}
</script>
  
<style>
.box-card {
    width: 480px;
    margin: 0 auto;
}

.login-btn {
    width: 100%;
    margin-top: 12px;
}
</style>