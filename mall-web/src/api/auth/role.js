import request from '@/utils/request'

// 获取角色列表
export function listRole(listQuery) {
  return request({
    url: '/mall-admin/role/list',
    method: 'get',
    params: {
      pageNum: listQuery.pageNum,
      pageSize: listQuery.pageSize
    }
  })
}

// 查询角色详细
export function getRole(id) {
  return request({
    url: '/mall-admin/role/getRole/' + id,
    method: 'get'
  })
}

// 新增后台角色
export function addRole(data) {
  return request({
    url: '/mall-admin/role/addRole',
    method: 'post',
    data: data
  })
}

// 修改后台角色
export function updateRole(data) {
  return request({
    url: '/mall-admin/role/updateRole',
    method: 'put',
    data: data
  })
}

// 删除角色
export function delRole(id) {
  return request({
    url: '/mall-admin/role/delRole/' + id,
    method: 'delete'
  })
}

// 导出角色列表
export function exportRole(query) {
  return request({
    url: '/mall-admin/role/exportRole',
    method: 'get',
    params: query
  })
}

// 角色启用状态更新
export function changeSwitch(row) {
  return request({
    url: '/mall-admin/role/changeSwitch',
    method: 'put',
    params: {
      status: row.status,
      id: row.id
    }
  })
}

// 查询所有可用角色
export function getRoleAll() {
  return request({
    url: '/mall-admin/role/getRoleAll',
    method: 'get'
  })
}

// 更新用户的角色
export function updateRoleById(data) {
  return request({
    url: '/mall-admin/role/updateRoleById',
    method: 'put',
    params: {
      userId: data.userId,
      roleId: data.roleId
    }
  })
}

// 根据用户id查询角色
export function getRoleById(id) {
  return request({
    url: '/mall-admin/role/getRoleById/' + id,
    method: 'get'
  })
}
