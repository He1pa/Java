import Vue from 'vue'
import Router from 'vue-router'
import Main from "../views/Main"
import Login from "../views/Login"
import List from "../views/user/List";
import Profile from "../views/user/Profile";
import NotFound from "../views/NotFound";
Vue.use(Router);

export default new Router({
  mode:'history',
  routes:[
    {
      path:'/main',
      component:Main,
      props:true,
      children:[
        {path:'/user/profile/:id',name:'UserProfile',
          component:Profile,props:true
        },{path:'/user/list',
          component:List
        }
      ]
    },{
      path:'/login',
      component:Login
    },{
      path:'/goHome',
      component:Login,
      redirect:'/main'
    },{
      path:'/*',
      component:NotFound,

    }
  ]
});
