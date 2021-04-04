import request from '@/utils/request'

export function listMenu(listQuery) {
  return request({
    url: '/mall-admin/menu/list',
    method: 'get',
    params: {
      pageNum: listQuery.pageNum,
      pageSize: listQuery.pageSize
    }
  })
}
