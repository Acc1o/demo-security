import request from '@/utils/request'

//常量
const api_name='/admin/system/sysRole/'

export default{
    //列表
    getPageList(page,limit,searchInfo){
        return request({
            //接口路径
            url: `${api_name}/${page}/${limit}`,
            method: 'get',//提交方式
            //参数
            params: searchInfo
          })
    },
    //删除
    removeById(id){
        return request({
            //接口路径
            url: `${api_name}/remove/${id}`,
            method: 'delete',//提交方式
          })
    },
    //添加
    save(role){
        return request({
            //接口路径
            url: `${api_name}/save/`,
            method: 'post',//提交方式
            data: role //传递json格式
          })
    },
    //根据id查询
    getRoleById(id){
      return request({
        //接口路径
        url: `${api_name}findRoleById/${id}`,
        method: 'post',//提交方式
      })
    },
    //根据id修改
    updateById(role){
      return request({
        //接口路径
        url: `${api_name}/update`,
        method: 'post',//提交方式
        data : role
      })
    },
    //根据id删除
    batchRemove(idList){
      return request({
        //接口路径
        url: `${api_name}/batchRemove`,
        method: 'delete',//提交方式
        data : idList
      })
    }

}
