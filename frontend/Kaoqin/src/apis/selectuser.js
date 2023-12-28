// apis/selectuser.js

import httpInstance from '@/utils/http'


// 重置密码
export function selectuserbyemail(email) {
    return httpInstance({
        url: '/selectuserbyemail',
        method: 'post',
        data: email
    })
}
export function selectuserbyusername(user) {
    return httpInstance({
        url: '/selectuserbyusername',
        method: 'post',
        data: user
    })
}
export function selectuserbyphone(phone) {
    return httpInstance({
        url: '/selectuserbyphone',
        method: 'post',
        data: phone
    })
}
export function selectallusers() {
    return httpInstance({
        url: '/selectallusers',
        method: 'post',
    })
}