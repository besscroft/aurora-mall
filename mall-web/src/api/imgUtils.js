import request from '@/utils/request'

// 获取Token
export function getToken(params) {
  return request({
    url: 'https://img.besscroft.com/api/token?email=' + params.email + '&password=' + params.password,
    method: 'get'
  })
}
