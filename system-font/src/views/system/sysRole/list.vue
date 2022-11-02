<template>
  <div class="app-container">

    <!--查询表单-->
<div class="search-div">
      <el-form label-width="70px" size="small">
        <el-row>
          <el-col :span="24">
            <el-form-item label="角色名称">
              <el-input style="width: 100%" v-model="searchInfo.roleName" placeholder="角色名称"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
        <el-row style="display:flex">
          <el-button type="primary" icon="el-icon-search" size="mini"  @click="fetchList()">搜索</el-button>
          <el-button icon="el-icon-refresh" size="mini" @click="resetData">重置</el-button>
        </el-row>
      </el-form>
    </div>

    <!-- 表格 -->
    <el-table
      v-loading="listLoading"
      :data="list"
      stripe
      border
      style="width: 100%;margin-top: 10px;">

      <el-table-column
        label="序号"
        width="70"
        align="center">
        <template slot-scope="scope">
          {{ (page - 1) * limit + scope.$index + 1 }}
        </template>
      </el-table-column>

      <el-table-column prop="roleName" label="角色名称" />
      <el-table-column prop="roleCode" label="角色编码" />
      <el-table-column prop="createTime" label="创建时间" width="160"/>
      <el-table-column label="操作" width="200" align="center">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" size="mini" @click="edit(scope.row.id)" title="修改"/>
          <el-button type="danger" icon="el-icon-delete" size="mini" @click="removeById(scope.row.id)" title="删除"/>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
  <el-pagination
    :current-page="page"
    :total="total"
    :page-size="limit"
    style="padding: 30px 0; text-align: center;"
    layout="total, prev, pager, next, jumper"
    @current-change="fetchList"
  />

  </div>
</template>
<script>
//引入接口定义js
import api from "@/api/sysRole/role"

export default {
  //定义初始值
  data(){
    return{
      listLoading: true, //是否显示加载图标
      list:[], //角色列表
      total: 0, //总记录数
      page: 1, //当前页
      limit: 3, //每页记录数
      searchInfo: {} //条件查询对象
    }
  },
  //页面渲染之前执行
  created(){
    this.fetchList()
  },
  //具体方法
  methods:{
    //条件分页查询列表
    fetchList(pageNum=1){
      //ajax请求
      this.page=pageNum
      api.getPageList(this.page,this.limit,this.searchInfo)
      .then(response =>{
        this.listLoading=false
        //console.log(response)
        this.list=response.data.records
        this.total=response.data.total
      })
    },
    // 重置表单
    resetData() {
        console.log('重置查询表单')
        this.searchInfo = {}
        this.fetchList()
    },
    //删除
    removeById(id){
         this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
    }).then(() => { // promise
        // 点击确定，远程调用ajax
        return api.removeById(id)
    }).then((response) => {
        this.fetchList(this.page)
        this.$message.success(response.message || '删除成功')
    }).catch(() => {
        this.$message.info('取消删除')
    })
        }

  }

}
</script>