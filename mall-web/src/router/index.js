import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * 公共路由，也就是所有权限都通用的路由表，比如首页、登录页面、404页面等等不需要权限的公用页面
 * https://panjiachen.github.io/vue-element-admin-site/zh/guide/essentials/router-and-nav.html
 * @type {any}
 */
export const constantRoutes = [
  {
    path: '/redirect',
    component: Layout,
    hidden: true,
    children: [
      {
        path: '/redirect/:path(.*)',
        component: (resolve) => require(['@/views/redirect'], resolve)
      }
    ]
  },
  {
    path: '/login',
    component: (resolve) => require(['@/views/login/index'], resolve),
    hidden: true
  },

  {
    path: '/404',
    component: (resolve) => require(['@/views/404'], resolve),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: (resolve) => require(['@/views/dashboard/index'], resolve),
      meta: { title: '首页', icon: 'dashboard', affix: true }
    }]
  }
]

export default new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})
