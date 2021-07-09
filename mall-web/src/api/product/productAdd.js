import request from '@/utils/request'

// 获取商品列表
export function productAdd(productParam) {
  return request({
    url: '/mall-admin/product/productAdd',
    method: 'post',
    data: productParam
  })
}
