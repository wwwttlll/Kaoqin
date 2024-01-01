import { defineStore } from 'pinia'
export const useUserStore = defineStore('user', {
  state: () => {
    return {
      isLoggedIn: false,
      userid: -1,
      username: '',
      userrole: 0,
    }
  }
})
export const useFilterStore = defineStore('filter', {
  state: () => ({
    userid:""
  })
})
