import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/mall-admin/user/login',
    method: 'post',
    data
  })
}

export function getInfo() {
  return request({
    url: '/mall-admin/user/info',
    method: 'get'
  })
}

export function logout() {
  return request({
    url: '/mall-admin/user/logout',
    method: 'post'
  })
}
