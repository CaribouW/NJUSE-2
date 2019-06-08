import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/views/Login/index.vue'
import Register from '@/views/Login/register.vue'
import Homepage from '@/views/homepage/index.vue'
import MovieList from '@/views/movieList/index.vue'
import Quick from '@/views/quick/index.vue'
import Test from '@/views/test/test.vue'               //自己玩儿的测试页面，之后删除

import Search from '@/views/search/index.vue'
import MovieDetail from '@/views/movie/index.vue'
import BuyCard from '@/views/VIP/buyCard.vue'
import VIPInfo from '@/views/VIP/VIPInfo.vue'
import VIPrights from '@/views/VIP/VIPrights.vue'
import Admin from '@/views/admin/index.vue'
import User from '@/views/user/index.vue'
Vue.use(Router);
import {childrenUser} from './user'
import {childernAmin} from './admin'

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/index',
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
      component: User,
      children: childrenUser
    },
    {
      path: '/test',
      name: 'Test',
      component: Test
    },
    {
      path: '/admin',
      name: 'admin',
      component: Admin,
      children: childernAmin
    },

    {
      path: '/search',
      name: 'Search',
      component: Search
    },
    {
      path: '/movie/detail',
      name: 'MovieDetail',
      component: MovieDetail
    },
    {
      path: '/VIP/buyCard',
      name: 'BuyCard',
      component: BuyCard
    },
    {
      path: '/VIP/VIPInfo',
      name: 'VIPInfo',
      component: VIPInfo
    },
    {
      path: '/VIP/VIPrights',
      name: 'VIPrights',
      component: VIPrights
    },
  ]
})
