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
import Admin from '@/views/admin/index.vue'
import User from '@/views/user/index.vue';
import Manager from '@/views/manager/index.vue'
import subCircle from '../components/circle';
import Network from '../components/Network'
import VIP from '@/views/VIP/index.vue';

Vue.use(Router);
import {childrenUser} from './user'
import {childernAmin} from './admin'
import {childernManager} from "./manager";
import {childrenVIP} from "./VIP";


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
      component: Network
    },
    {
      path: '/admin',
      name: 'admin',
      component: Admin,
      children: childernAmin
    },
    {
      path: '/manager',
      name: 'manager',
      component: Manager,
      children: childernManager
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
      path: '/VIP',
      name: 'VIP',
      component: VIP,
      children: childrenVIP

    },
  ]
})
