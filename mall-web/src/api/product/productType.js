import request from '@/utils/request'

// 获取商品类型列表
export function listProductType(listQuery) {
  return request({
    url: '/mall-admin/productType/list',
    method: 'get',
    params: {
      pageNum: listQuery.pageNum,
      pageSize: listQuery.pageSize
    }
  })
}

// 查询商品类型详细
export function getProductType(id) {
  return request({
    url: '/mall-admin/productType/getProductType/' + id,
    method: 'get'
  })
}

// 新增商品类型
export function addProductType(data) {
  return request({
    url: '/mall-admin/productType/addProductType',
    method: 'post',
    data: data
  })
}

// 修改商品类型
export function updateProductType(data) {
  return request({
    url: '/mall-admin/productType/updateProductType',
    method: 'put',
    data: data
  })
}

// 删除商品类型
export function delProductType(id) {
  return request({
    url: '/mall-admin/productType/delProductType/' + id,
    method: 'delete'
  })
}

// 导出商品类型列表
export function exportProductType(query) {
  return request({
    url: '/mall-admin/productType/exportProductType',
    method: 'get',
    params: query
  })
}

// 商品类型字典
export function getProductTypeDict() {
  return request({
    url: '/mall-admin/productType/getProductTypeDict',
    method: 'get'
  })
}
