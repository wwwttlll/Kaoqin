import { defineStore } from 'pinia'
export const useUserStore = defineStore('user', {
  state: () => {
    return {
      isLoggedIn: false,
      userid: '',
      username: ''
    }
  }
})
