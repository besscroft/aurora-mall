import request from '@/utils/request'

// 获取订单列表
export function getOrderList(listQuery) {
  return request({
    url: '/mall-admin/order/list',
    method: 'get',
    params: {
      pageNum: listQuery.pageNum,
      pageSize: listQuery.pageSize
    }
  })
}

// 获取订单详情
export function getOrderDetail(orderId) {
  return request({
    url: '/mall-admin/order/detail/' + orderId,
    method: 'get'
  })
}

// 删除订单
export function deleteOrder(orderId) {
  return request({
    url: '/mall-admin/order/delete/' + orderId,
    method: 'delete'
  })
}

// 导出订单信息
export function exportOrder(data) {
  return request({
    url: '/mall-admin/order/export',
    method: 'post',
    data: data,
    responseType: 'blob'
  })
}
