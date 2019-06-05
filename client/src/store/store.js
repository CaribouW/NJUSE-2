import Vue from 'vue'
import Vuex from 'vuex'
import todos from './module/todos.js';
import user from './module/user.js'
import movie from './module/movie.js'
import coupon from "./module/coupon";
import hall from "./module/hall";
import schedule from "./module/schedule";
import order from './module/order'
// 配置vuex
Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    todos, user, movie, coupon,
    hall, order, schedule,
  }
})
