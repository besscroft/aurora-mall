import request from '@/utils/request'

// 获取资源列表
export function listResource(listQuery) {
  return request({
    url: '/mall-admin/resource/list',
    method: 'get',
    params: {
      pageNum: listQuery.pageNum,
      pageSize: listQuery.pageSize
    }
  })
}

// 查询资源详细
export function getResource(id) {
  return request({
    url: '/mall-admin/resource/getResource/' + id,
    method: 'get'
  })
}

// 新增资源
export function addResource(data) {
  return request({
    url: '/mall-admin/resource/addResource',
    method: 'post',
    data: data
  })
}

// 修改资源
export function updateResource(data) {
  return request({
    url: '/mall-admin/resource/updateResource',
    method: 'put',
    data: data
  })
}

// 删除资源
export function delResource(id) {
  return request({
    url: '/mall-admin/resource/delResource/' + id,
    method: 'delete'
  })
}

// 导出资源列表
export function exportResource(query) {
  return request({
    url: '/mall-admin/resource/exportResource',
    method: 'get',
    params: query
  })
}

// 获取所有资源的资源树
export function getAllResourceTree() {
  return request({
    url: '/mall-admin/resource/getAllResourceTree',
    method: 'get'
  })
}

// 根据角色id获取资源树数组
export function getResourceTreeById(id) {
  return request({
    url: '/mall-admin/resource/getResourceTreeById/' + id,
    method: 'get'
  })
}

// 更新资源树
export function updateResourceTree(row) {
  return request({
    url: '/mall-admin/resource/updateResourceTree',
    method: 'put',
    params: {
      id: row.id
    },
    data: row.data
  })
}
