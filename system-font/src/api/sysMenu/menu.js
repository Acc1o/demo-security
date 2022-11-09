import request from '@/utils/request'

const api_name = '/admin/system/sysMenu'
export default{
    //列表
  findNodes() {
    return request({
      url: `${api_name}/findNodes`,
      method: 'get'
    })
  },

  //删除
  removeById(id) {
    return request({
      url: `${api_name}/remove/${id}`,
      method: "delete"
    })
  },

  //新增
  save(sysMenu) {
    return request({
      url: `${api_name}/save`,
      method: "post",
      data: sysMenu
    })
  },

  //修改
  updateById(sysMenu) {
    return request({
      url: `${api_name}/update`,
      method: "post",
      data: sysMenu
    })
  },
  //修改菜单状态
  updateStatus(id,status){
    return request({
      //接口路径
      url: `${api_name}/updateStatus/${id}/${status}`,
      method: 'get',//提交方式
    })
  },
  //查看角色权限列表
  toAssign(roleId) {
    return request({
      url: `${api_name}/toAssign/${roleId}`,
      method: 'get'
    })
  },

  //角色授权
  doAssign(assginMenuVo) {
    return request({
      url: `${api_name}/doAssign`,
      method: "post",
      data: assginMenuVo
    })
  }

}
