import request from '@/utils/request'

export function getList(params) {
  return request({
    url: '/aurora-mall/table/list',
    method: 'get',
    params
  })
}
