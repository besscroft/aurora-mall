import request from '@/utils/request'

// 获取商品套餐列表
export function listProductSkuList(listQuery) {
  return request({
    url: '/mall-admin/productSku/list',
    method: 'get',
    params: {
      productId: listQuery.productId,
      pageNum: listQuery.pageNum,
      pageSize: listQuery.pageSize,
      keyword: listQuery.keyword
    }
  })
}
