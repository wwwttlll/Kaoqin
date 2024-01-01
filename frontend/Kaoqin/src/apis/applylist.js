import httpInstance from '@/utils/http'

export function ApplyList(userId) {
  return httpInstance({
    url: `/Apply/ApplyList`,
    method: 'post',
    data:{userId}
  })
}