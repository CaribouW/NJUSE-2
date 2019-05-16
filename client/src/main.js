// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// YYP2019/4/24加
// element组件
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

// 加入axios、mock
import axios from 'axios'
import Mock from './mock/mock.js'
Vue.prototype.$axios = axios

// 加入vuex
import store from './store/store.js'


Vue.config.productionTip = false

Vue.use(ElementUI)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
