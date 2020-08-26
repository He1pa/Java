
import Vue from 'vue'
import App from './App'
import router from './router/index'


import ElementUI from "element-ui"
//导入element css
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import VueAxios from 'vue-axios'
Vue.use(VueAxios, axios)
Vue.use(ElementUI);

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)//ElementUI规定这样使用
})
