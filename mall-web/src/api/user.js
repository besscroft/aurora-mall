import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/aurora-mall/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/aurora-mall/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/aurora-mall/user/logout',
    method: 'post'
  })
}
