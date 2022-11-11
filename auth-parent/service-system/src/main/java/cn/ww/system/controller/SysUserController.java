package cn.ww.system.controller;


import cn.ww.common.result.Result;
import cn.ww.common.utils.MD5;
import cn.ww.model.entity.SysUser;
import cn.ww.model.vo.SysUserQueryVo;
import cn.ww.system.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author Suww
 * @since 2022-11-03
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/admin//system/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 用户列表
     * @param page 页码
     * @param limit 记录数
     * @param sysUserQueryVo entity查询对象
     * @return
     */
    @ApiOperation("用户列表")
    @GetMapping("/{page}/{limit}")
    public Result list(@PathVariable Long page,
                       @PathVariable Long limit,
                       SysUserQueryVo sysUserQueryVo){

        Page<SysUser> pageParam = new Page<>(page, limit);
        IPage<SysUser> pageModel = sysUserService.selectByPage(pageParam,sysUserQueryVo);
        return Result.ok(pageModel);
    }

    /**
     * 添加用户
     * @param sysUser entity对象
     * @return
     */
    @ApiOperation("添加用户")
    @PostMapping("save")
    public Result save(@RequestBody SysUser sysUser){
        String encrypt = MD5.encrypt(sysUser.getPassword());
        sysUser.setPassword(encrypt);
        boolean isSuccess = sysUserService.save(sysUser);
        if (isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    /**
     * 根据id用户查询
     * @param id 用户id
     * @return
     */
    @ApiOperation("根据id用户查询")
    @GetMapping("getUserById/{id}")
    public Result getUserById(@PathVariable String id){
        SysUser user = sysUserService.getById(id);
        return Result.ok(user);
    }

    /**
     * 修改用户
     * @param sysUser entity对象
     * @return
     */
    @ApiOperation("修改用户")
    @PostMapping("update")
    public Result update(@RequestBody SysUser sysUser){
        boolean isSuccess = sysUserService.updateById(sysUser);
        if (isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    /**
     * 删除用户
     * @param id 用户id
     * @return
     */
    @ApiOperation("删除用户")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable String id){
        boolean isSuccess = sysUserService.removeById(id);
        if (isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    /**
     * 修改用户状态
     * @param id 用户id
     * @param status 用户状态 标识(0 :启用  ,1 :禁用 )
     * @return
     */
    @ApiOperation(value = "修改状态")
    @GetMapping("updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        sysUserService.updateStatus(id, status);
        return Result.ok();
    }
}

