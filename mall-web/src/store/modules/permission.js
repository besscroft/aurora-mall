import { constantRoutes } from '@/router/index';
import Layout from '@/layout/index'
import ParentView from '@/layout/components/ParentView/index';

const permission = {
  state: {
    routers: [],
    addRouters: [],
    sidebarRouters: []
  },
  mutations: {
    SET_ROUTERS: (state, routers) => {
      // addRoutes 保持动态路由
      state.addRouters = routers;
      // 合并路由
      state.routers = constantRoutes.concat(routers);
    },
    SET_SIDEBAR_ROUTERS: (state, routers) => {
      state.sidebarRouters = constantRoutes.concat(routers)
    }
  },
  actions: {
    GenerateRoutes({ commit }, data) {
      return new Promise(resolve => {
        const { menus, username, roles } = data
        // 通过递归过滤异步路由表
        const sidebarRoutes = filterAsyncRouter(menus)
        const rewriteRoutes = filterAsyncRouter(menus, true)
        rewriteRoutes.push({ path: '*', redirect: '/404', hidden: true })
        commit('SET_ROUTERS', rewriteRoutes)
        commit('SET_SIDEBAR_ROUTERS', sidebarRoutes)
        resolve(rewriteRoutes)
      })
    }
  }
};

// 遍历后台传来的路由字符串，转换为组件对象
function filterAsyncRouter(asyncRouterMap, isRewrite = false) {
  const res = []
  asyncRouterMap.forEach(route => {
    const tmp = {...route}
    if (isRewrite && tmp.children) {
      tmp.children = filterChildren(tmp.children)
    }
    if (tmp.component) {
      // Layout ParentView 组件特殊处理
      if (tmp.component === 'Layout') {
        tmp.component = Layout
      } else if (tmp.component === 'ParentView') {
        tmp.component = ParentView
      } else {
        const component = tmp.component
        tmp.component = loadView(component)
      }
    }
    res.push(tmp)
  })
  return res
}

function filterChildren(childrenMap) {
  var children = []
  childrenMap.forEach(el => {
    const component = el.component
    el.component = loadView(component)
    children = children.concat(el)
  })
  return children
}

export const loadView = (view) => {
  return (resolve) => require([`@/views${view}`], resolve)
}

export default permission;

