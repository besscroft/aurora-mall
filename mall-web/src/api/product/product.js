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

// 获取商品信息
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

// 上架状态更新
export function changeSwitchPush(row) {
  return request({
    url: '/mall-admin/product/changeSwitchPush',
    method: 'put',
    params: {
      hidden: row.pushStatus,
      id: row.id
    }
  })
}

// 新品状态更新
export function changeSwitchNew(row) {
  return request({
    url: '/mall-admin/product/changeSwitchNew',
    method: 'put',
    params: {
      hidden: row.newStatus,
      id: row.id
    }
  })
}

// 推荐状态更新
export function changeSwitchRecommend(row) {
  return request({
    url: '/mall-admin/product/changeSwitchRecommend',
    method: 'put',
    params: {
      hidden: row.recommandStatus,
      id: row.id
    }
  })
}
