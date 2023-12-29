// apis/selectuser.js

import httpInstance from '@/utils/http'


export function updateexcuse(excuse) {
    return httpInstance({
        url: '/updateexcuse',
        method: 'post',
        data: excuse
    })
}
export function getexcuse() {
    return httpInstance({
        url: '/getexecuse',
        method: 'get',
    })
}