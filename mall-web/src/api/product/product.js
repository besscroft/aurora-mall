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
    url:'/mall-admin/product/updateInfo/'+id,
    method:'get',
  })
}
