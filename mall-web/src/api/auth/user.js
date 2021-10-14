import request from '@/utils/request'

// 后台管理系统用户登录
export function login(data) {
  return request({
    url: '/mall-admin/user/login',
    method: 'post',
    data
  })
}

// 获取用户信息
export function getInfo() {
  return request({
    url: '/mall-admin/user/info',
    method: 'get'
  })
}

// 后台管理系统用户退出登录
export function logout() {
  return request({
    url: '/mall-admin/user/logout',
    method: 'post'
  })
}

// 查询权限管理模块用户列表
export function listUser(listQuery) {
  return request({
    url: '/mall-admin/user/list',
    method: 'get',
    params: {
      pageNum: listQuery.pageNum,
      pageSize: listQuery.pageSize
    }
  })
}

// 查询权限管理模块用户详细
export function getUser(id) {
  return request({
    url: '/mall-admin/user/getUser/' + id,
    method: 'get'
  })
}

// 新增权限管理模块用户
export function addUser(data) {
  return request({
    url: '/mall-admin/user/addUser',
    method: 'post',
    data: data
  })
}

// 修改权限管理模块用户
export function updateUser(data) {
  return request({
    url: '/mall-admin/user/updateUser',
    method: 'put',
    data: data
  })
}

// 删除权限管理模块用户
export function delUser(id) {
  return request({
    url: '/mall-admin/user/delUser/' + id,
    method: 'delete'
  })
}

// 导出权限管理模块用户
export function exportUser(data) {
  return request({
    url: '/mall-admin/user/exportUser',
    method: 'post',
    data: data,
    responseType: 'blob'
  })
}

// 用户账户启用状态更新
export function changeSwitch(row) {
  return request({
    url: '/mall-admin/user/changeSwitch',
    method: 'put',
    params: {
      status: row.status,
      id: row.id
    }
  })
}
