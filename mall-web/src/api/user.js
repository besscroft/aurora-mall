import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/mall-auth/bms/auth/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/mall-auth/bms/auth/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/mall-auth/bms/auth/logout',
    method: 'post'
  })
}
