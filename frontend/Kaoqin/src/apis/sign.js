import httpInstance from '@/utils/http'


export function selectallsign() {
    return httpInstance({
        url: '/selectallsign',
        method: 'get',
    })
}
export function selectsignbyuser(data) {
    return httpInstance({
        url: '/selectsignbyuser',
        method: 'post',
        data: data
    })
} export function selectsignbyuserid(userid) {
    return httpInstance({
        url: '/selectsignbyuserid',
        method: 'post',
        data: userid
    })
}
export function supplement(data) {
    return httpInstance({
        url: '/signsupplement',
        method: 'post',
        data
    })
}
export function signstatistics() {
    return httpInstance({
        url: '/signstatistics',
        method: 'post',
        
    })
}
export function statisticsbyuser(data) {
    return httpInstance({
        url: '/statisticsbyuser',
        method: 'post',
        data
    })
}