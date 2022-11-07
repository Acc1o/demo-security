package cn.ww.system.controller;


import cn.ww.common.Result;
import cn.ww.model.entity.SysUser;
import cn.ww.model.vo.SysRoleQueryVo;
import cn.ww.model.vo.SysUserQueryVo;
import cn.ww.system.service.SysUserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Suww
 * @since 2022-11-03
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/admin//system/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    
    @ApiOperation("用户列表")
    @GetMapping("/{page}/{limit}")
    public Result List(@PathVariable Long page,
                       @PathVariable Long limit,
                       SysUserQueryVo sysUser){

        Page<SysUser> pageParam = new Page<>(page, limit);
        IPage<SysUser> pageModel = sysUserService.selectByPage(pageParam,sysUser);
        return Result.ok(pageModel);
    }

    @ApiOperation("添加用户")
    @PostMapping("save")
    public Result save(@RequestBody SysUser user){
        boolean isSuccess = sysUserService.save(user);
        if (isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    @ApiOperation("根据id用户查询")
    @GetMapping("getUser/{id}")
    public Result getUser(@PathVariable String id){
        SysUser user = sysUserService.getById(id);
        return Result.ok(user);
    }

    @ApiOperation("修改用户")
    @PostMapping("update")
    public Result update(@RequestBody SysUser user){
        boolean isSuccess = sysUserService.updateById(user);
        if (isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

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
}

