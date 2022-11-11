package cn.ww.system.controller;

import cn.ww.common.result.Result;
import cn.ww.model.entity.SysRole;
import cn.ww.model.vo.AssginRoleVo;
import cn.ww.model.vo.SysRoleQueryVo;
import cn.ww.system.service.SysRoleService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Suww
 * @createTime 2022-10-26
 */

@Api(tags = "角色管理")
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    
    @Resource
    private SysRoleService sysRoleService;


    /**
     * 查询所有角色
     * @return
     */
    @ApiOperation("查询所有记录")
    @GetMapping("findAll")
    public Result findAll(){
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list);
    }

    

    /**
     * 条件分页查询
     * @param page 页码
     * @param limit 记录数
     * @param sysRoleQueryVo entity查询对象
     * @return
     */
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result findRoleByPage(@PathVariable Long page, 
                                 @PathVariable Long limit, 
                                 SysRoleQueryVo sysRoleQueryVo){
        Page<SysRole> pageParam = new Page<>(page, limit);
        IPage<SysRole> pageModel= sysRoleService.selectPage(pageParam,sysRoleQueryVo);
        return Result.ok(pageModel);
    }

    /**
     * 添加角色
     * @param sysRole entity对象
     * @return
     */
    @ApiOperation("添加角色")
    @PostMapping("save")
    public Result saveRole(@RequestBody SysRole sysRole){
        boolean isSuccess = sysRoleService.save(sysRole);
        if(isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }
    
    /**
     * 根据Id查询
     * @param id 角色id
     * @return
     */
    @ApiOperation("根据Id查询")
    @PostMapping("findRoleById/{id}")
    public Result findRoleById(@PathVariable Long id){
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }
    
    /**
     * 修改
     * @param sysRole entity对象
     * @return
     */
    @ApiOperation("修改")
    @PostMapping("update")
    public Result updateRole(@RequestBody SysRole sysRole){
        boolean isSuccess = sysRoleService.updateById(sysRole);
        if(isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    /**
     * 逻辑删除角色
     * @param id 角色id
     * @return
     */
    @ApiOperation("逻辑删除")
    @DeleteMapping("remove/{id}")
    public Result removeRoleById(@PathVariable Long id){
        boolean isSuccess = sysRoleService.removeById(id);
        if(isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    /**
     * 批量删除
     * @param ids 角色ids
     * @return
     */
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> ids){
        boolean isSuccess = sysRoleService.removeByIds(ids);
        if(isSuccess){
            return Result.ok();
        }else {
            return Result.fail();
        }
    }

    /**
     * 获取用户角色信息
     * @param userId 用户id
     * @return
     */
    @ApiOperation("获取用户角色信息")
    @GetMapping("/toAssign/{userId}")
    public Result toAssign(@PathVariable String userId){
       Map<String,Object> rolesMap =  sysRoleService.getRoles(userId);
       return Result.ok(rolesMap);
    }

    /**
     * 分配用户角色 
     * @param assignRoleVo 角色:用户 关系表对象
     * @return
     */
    @ApiOperation("分配用户角色")
    @PostMapping("doAssign")
    public Result doAssign(@RequestBody AssginRoleVo assignRoleVo){
        sysRoleService.doAssign(assignRoleVo);
        return Result.ok();
    }
    
}
