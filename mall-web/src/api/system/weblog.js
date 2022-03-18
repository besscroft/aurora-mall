import request from '@/utils/request'

export function getLogList(listQuery) {
  return request({
    url: '/mall-admin/weblog/list',
    method: 'get',
    params: {
      pageNum: listQuery.pageNum,
      pageSize: listQuery.pageSize,
      keyword: listQuery.keyword
    }
  })
}
