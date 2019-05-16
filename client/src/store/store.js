import Vue from 'vue'
import Vuex from 'vuex'
import todos from './module/todos.js'

// 配置vuex
Vue.use(Vuex);

export default new Vuex.Store({
    modules: {
        todos
    }
})