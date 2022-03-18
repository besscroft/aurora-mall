import router from './router'
import store from './store'
import { Message } from 'element-ui'
import NProgress from 'nprogress' // progress 进度条
import 'nprogress/nprogress.css' // progress 进度条样式
import { getToken } from '@/utils/auth' // 从cookie中获取token
import getPageTitle from '@/utils/get-page-title'

NProgress.configure({ showSpinner: false }) // NProgress 配置

const whiteList = ['/login'] // 不重定向白名单

router.beforeEach(async(to, from, next) => {
  // 启动 progress 进度条
  NProgress.start()

  // 设置页面 title
  document.title = getPageTitle(to.meta.title)

  // 从cookie中获取token
  const hasToken = getToken()

  if (hasToken) {
    // 判断路由是否为 /login
    if (to.path === '/login') {
      // 路由重定向到 '/'
      next({ path: '/' })
      NProgress.done()
    } else {
      // 获取用户的角色
      if (store.getters.roles.length > 0) {
        // 角色存在
        next()
      } else {
        try {
          // 角色不存在
          // 获取用户角色
          store.dispatch('user/getInfo').then(res => {
            const roles = res.roles
            const menus = res.menus
            const username = res.username
            store.dispatch('GenerateRoutes', { menus, username, roles }).then(accessRoutes => {
              // 动态生成路由表
              router.addRoutes(accessRoutes)
              // replace 设置为 true 时，导航不会留下历史记录，回退时不会回退到登录页
              next({ ...to, replace: true })
            })
          })
        } catch (error) {
          // 如果出现异常，把 token 、 roles 、cookie 清空
          await store.dispatch('user/resetToken')
          Message.error(error || 'Has Error')
          // 重定向到 login ，并带上上次访问的路由
          next(`/login?redirect=${to.path}`)
          NProgress.done()
        }
      }
    }
  } else {
    /* 如果 token 不存在 */
    if (whiteList.indexOf(to.path) !== -1) {
      // 如果路由存在白名单里面，直接 next
      next()
    } else {
      // 如果路由不在白名单里面，或者其他无权访问的页面，将被重定向到登录页面，并带上上次访问的路由。
      next(`/login?redirect=${to.path}`)
      NProgress.done()
    }
  }
})

router.afterEach(() => {
  // 结束 progress 进度条
  NProgress.done()
})
