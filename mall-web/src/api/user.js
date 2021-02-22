import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/mall-admin/bms/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/mall-admin/bms/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/mall-admin/bms/user/logout',
    method: 'post'
  })
}
