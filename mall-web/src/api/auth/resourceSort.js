import request from '@/utils/request'

// 获取资源类别列表
export function listResourceSort(listQuery) {
  return request({
    url: '/mall-admin/resourceSort/list',
    method: 'get',
    params: {
      pageNum: listQuery.pageNum,
      pageSize: listQuery.pageSize
    }
  })
}

// 查询资源类别详细
export function getResourceSort(id) {
  return request({
    url: '/mall-admin/resourceSort/getResourceSort/' + id,
    method: 'get'
  })
}

// 新增资源类别
export function addResourceSort(data) {
  return request({
    url: '/mall-admin/resourceSort/addResourceSort',
    method: 'post',
    data: data
  })
}

// 修改资源类别
export function updateResourceSort(data) {
  return request({
    url: '/mall-admin/resourceSort/updateResourceSort',
    method: 'put',
    data: data
  })
}

// 删除资源类别
export function delResourceSort(id) {
  return request({
    url: '/mall-admin/resourceSort/delResourceSort/' + id,
    method: 'delete'
  })
}

// 导出资源类别列表
export function exportResourceSort(query) {
  return request({
    url: '/mall-admin/resourceSort/exportResourceSort',
    method: 'get',
    params: query
  })
}
