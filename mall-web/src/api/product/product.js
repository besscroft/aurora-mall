import request from '@/utils/request'

// 获取商品列表
export function listProductList(listQuery) {
  return request({
    url: '/mall-admin/product/list',
    method: 'get',
    params: {
      pageNum: listQuery.pageNum,
      pageSize: listQuery.pageSize
    }
  })
}

export function getProduct(id) {
  return request({
    url: '/mall-admin/product/updateInfo/' + id,
    method: 'get',
  })
}

// 删除商品
export function delProduct(id) {
  return request({
    url: '/mall-admin/product/productDel/' + id,
    method: 'delete'
  })
}

// 导出商品信息
export function exportProduct(data) {
  return request({
    url: '/mall-admin/product/exportProduct',
    method: 'post',
    data: data,
    responseType: 'blob'
  })
}
