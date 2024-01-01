import httpInstance from '@/utils/http'

export function ChangeInfo(userId,requestData) {
  return httpInstance({
    url: `/ChangeInfo/${userId}`,
    method: 'post',
    data:requestData
  })
}