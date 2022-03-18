import request from '@/utils/request'

// 获取版本日志列表
export function listUpdateLog() {
  return request({
    url: '/mall-admin/updateLog/list',
    method: 'get'
  })
}
