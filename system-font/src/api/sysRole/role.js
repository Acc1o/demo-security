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
    }
}
