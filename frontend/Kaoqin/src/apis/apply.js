import httpInstance from '@/utils/http'

export function Apply(data) {
    return httpInstance({
      url: '/Apply/AddApply',
      method: 'post',
      data
    })
  }