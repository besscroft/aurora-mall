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

// 获取商品套餐详情
export function getProductSkuById(id) {
  return request({
    url: '/mall-admin/productSku/getProductSkuById/' + id,
    method: 'get'
  })
}

// 新增商品套餐
export function addProductSku(data) {
  return request({
    url: '/mall-admin/productSku/addSku',
    method: 'post',
    data: {
      productId: data.productId,
      price: data.price,
      stock: data.stock,
      lowStock: data.lowStock,
      pic: data.pic,
      lockStock: data.lockStock,
      spData: data.spData
    }
  })
}

// 修改商品套餐
export function updateProductSku(data) {
  return request({
    url: '/mall-admin/productSku/updateSku',
    method: 'put',
    data: data
  })
}

// 删除商品套餐
export function deleteProductSku(id) {
  return request({
    url: '/mall-admin/productSku/productSkuDel/' + id,
    method: 'delete'
  })
}
