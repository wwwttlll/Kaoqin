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
