import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/views/Login/index.vue'
import Register from '@/views/Login/register.vue'
import Homepage from '@/views/homepage/index.vue'
import MovieList from '@/views/movieList/index.vue'
import Quick from '@/views/quick/index.vue'
import User from '@/views/user/basicInfo/basicInfo.vue'
import Test from '@/views/test/test.vue'               //自己玩儿的测试页面，之后删除
import movieManage from '@/components/admin/movieManage'
import scheduleManage from '@/components/admin/scheduleManage'
import movieShow from '@/components/admin/movieShow'
import statistic from '@/components/admin/statistic'
import Coupon from '@/views/user/coupon.vue'
import Favor from '@/views/user/favor.vue'

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
      path: '/user',
      name: 'User',
      component: User
    },
    {
      path: '/test',
      name: 'Test',
      component: Test
    },
    {
      path: '/admin',
      name: 'Admin',
      component: HelloWorld
    },
    {
      path: '/admin/movieManage',
      name: 'movieManage',
      component: movieManage
    },
    {
      path: '/admin/scheduleManage',
      name: 'scheduleManage',
      component: scheduleManage
    },
    {
      path: '/admin/movieShow',
      name: 'movieShow',
      component: movieShow
    },
    {
      path: '/admin/statistic',
      name: 'statistic',
      component: statistic
    },
    {
      path:'/user/coupon',
      name:'Coupon',
      component:Coupon
    },
    {
      path:'/user/favor',
      name:'Favor',
      component:Favor
    },
  ]
})
