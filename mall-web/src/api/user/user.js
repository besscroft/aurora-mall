import request from '@/utils/request'

// 获取用户列表
export function getUserList(listQuery) {
  return request({
    url: '/mall-admin/mall/user/list',
    method: 'get',
    params: {
      pageNum: listQuery.pageNum,
      pageSize: listQuery.pageSize
    }
  })
}

// 获取用户详情
export function getUserDetail(id) {
  return request({
    url: '/mall-admin/mall/user/detail',
    method: 'get',
    params: {
      id
    }
  })
}

// 删除用户（软删除）
export function delUser(id) {
  return request({
    url: '/mall-admin/mall/user/delUser/' + id,
    method: 'delete'
  })
}
