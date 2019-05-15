import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/views/Login/index.vue'
import Register from '@/views/Login/register.vue'
import Homepage from '@/views/homepage/index.vue'
import MovieList from '@/views/movieList/index.vue'
import Quick from '@/views/quick/index.vue'
import basicInfo from '@/views/basicInfo/basicInfo.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect:'/index',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/index',
      name: 'Homepage',
      component: Homepage
    },
    {
      path: '/movielist',
      name: 'MovieList',
      component: MovieList
    },
    {
      path: '/quick',
      name: 'Quick',
      component: Quick
    },
    {
      path: '/basicinfo',
      name: 'basicInfo',
      component: basicInfo
    },
  ]
})
