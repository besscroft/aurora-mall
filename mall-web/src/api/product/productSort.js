import request from '@/utils/request'

// 获取商品分类列表
export function listProductSort(listQuery) {
  return request({
    url: '/mall-admin/productSort/list',
    method: 'get',
    params: {
      pageNum: listQuery.pageNum,
      pageSize: listQuery.pageSize
    }
  })
}

// 查询商品分类详细
export function getProductSort(id) {
  return request({
    url: '/mall-admin/productSort/getProductSort/' + id,
    method: 'get'
  })
}

// 新增商品分类
export function addProductSort(data) {
  return request({
    url: '/mall-admin/productSort/addProductSort',
    method: 'post',
    data: data
  })
}

// 修改商品分类
export function updateProductSort(data) {
  return request({
    url: '/mall-admin/productSort/updateProductSort',
    method: 'put',
    data: data
  })
}

// 删除商品分类
export function delProductSort(id) {
  return request({
    url: '/mall-admin/productSort/delProductSort/' + id,
    method: 'delete'
  })
}

// 导出商品分类列表
export function exportProductSort(query) {
  return request({
    url: '/mall-admin/productSort/exportProductSort',
    method: 'get',
    params: query
  })
}

// 商品分类启用状态更新
export function changeSwitch(row) {
  return request({
    url: '/mall-admin/productSort/changeSwitch',
    method: 'put',
    params: {
      showStatus: row.showStatus,
      id: row.id
    }
  })
}

// 查询商品分类所有父级
export function getProductSortByParent() {
  return request({
    url: '/mall-admin/productSort/getProductSortByParent' ,
    method: 'get'
  })
}

// 商品分类字典
export function getProductSortDict() {
  return request({
    url: '/mall-admin/productSort/getProductSortDict' ,
    method: 'get'
  })
}
