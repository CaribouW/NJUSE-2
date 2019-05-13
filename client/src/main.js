/*
 * @Description: In User Settings Edit
 * @Author: your name
 * @Date: 2019-04-26 09:41:58
 * @LastEditTime: 2019-05-12 23:41:48
 * @LastEditors: Please set LastEditors
 */
// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// YYP2019/4/24加
// element组件
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

/*
 * @Description: add Axios to handle httpRequest
 * @Author: Zhou
 * @LastEditTime: 2019-05-12 23:40
*/
import axios from 'axios'
Vue.prototype.$axios = axios


Vue.config.productionTip = false

Vue.use(ElementUI)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
