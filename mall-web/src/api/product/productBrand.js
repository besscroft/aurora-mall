import request from '@/utils/request'

// 获取商品品牌列表
export function listProductBrand(listQuery) {
  return request({
    url: '/mall-admin/productBrand/list',
    method: 'get',
    params: {
      pageNum: listQuery.pageNum,
      pageSize: listQuery.pageSize
    }
  })
}

// 查询商品品牌详细
export function getProductBrand(id) {
  return request({
    url: '/mall-admin/productBrand/getProductBrand/' + id,
    method: 'get'
  })
}

// 新增商品品牌
export function addProductBrand(data) {
  return request({
    url: '/mall-admin/productBrand/addProductBrand',
    method: 'post',
    data: data
  })
}

// 修改商品品牌
export function updateProductBrand(data) {
  return request({
    url: '/mall-admin/productBrand/updateProductBrand',
    method: 'put',
    data: data
  })
}

// 删除商品品牌
export function delProductBrand(id) {
  return request({
    url: '/mall-admin/productBrand/delProductBrand/' + id,
    method: 'delete'
  })
}

// 导出商品品牌列表
export function exportProductBrand(query) {
  return request({
    url: '/mall-admin/productBrand/exportProductBrand',
    method: 'get',
    params: query
  })
}

// 商品品牌显示状态更新
export function changeSwitch(row) {
  return request({
    url: '/mall-admin/productBrand/changeSwitch',
    method: 'put',
    params: {
      showStatus: row.showStatus,
      id: row.id
    }
  })
}

// 商品品牌字典
export function getProductBrandDict() {
  return request({
    url: '/mall-admin/productBrand/getProductBrandDict',
    method: 'get'
  })
}
