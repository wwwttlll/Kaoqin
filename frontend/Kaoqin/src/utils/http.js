import axios from 'axios'
// import Vue from 'vue';


const httpInstance = axios.create({
  baseURL: 'http://127.0.0.1:8080',
  timeout: 5000,

})
// axios.defaults.withCredentials = true
// Vue.config.globalProperties.$ajax = axios
httpInstance.interceptors.request.use(function (config) {
  return config;
}, function (error) {
  return Promise.reject(error);
});

// 添加响应拦截器
httpInstance.interceptors.response.use(function (response) {
  return response;
}, function (error) {
  return Promise.reject(error);
});

export default httpInstance