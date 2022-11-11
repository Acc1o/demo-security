package cn.ww.system.controller;

import cn.ww.common.result.Result;
import cn.ww.common.utils.JwtHelper;
import cn.ww.common.utils.MD5;
import cn.ww.model.entity.SysUser;
import cn.ww.model.vo.LoginVo;
import cn.ww.system.exception.HandleException;
import cn.ww.system.service.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Suww
 * @createTime 2022-10-31
 */
@Api(tags =  "用户登录")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {
    
    @Resource
    private SysUserService sysUserService;
    

    /**
     * 登陆
     * @param loginVo 登陆vo对象
     * @return
     */
    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo){
        SysUser sysUser=  sysUserService.getUserInfoByUserName(loginVo.getUsername());
        if(sysUser == null){
            throw new HandleException(20001,"用户不存在");
        }
        
        String password = sysUser.getPassword();
        String md5Password = MD5.encrypt(password);
        if(loginVo.getPassword().equals(md5Password)){
            throw new HandleException(20001,"密码不正确");
        }
        
        if(sysUser.getStatus().intValue() == 0){
            throw new HandleException(20001,"用户已被禁用");
        }

        String token = JwtHelper.createToken(sysUser.getId(), sysUser.getUsername());
        
        Map<String, Object> map = new HashMap<>(16);
        map.put("token",token);
        return Result.ok(map);
    }

    /**
     * 获取用户信息
     * @param request 请求对象
     * @return
     */
    @GetMapping("info")
    public Result info(HttpServletRequest request){
        String token = request.getHeader("token");
        String username = JwtHelper.getUsername(token);
        Map<String, Object> map = sysUserService.getUserInfo(username);
        return Result.ok(map);
    }

    /**
     * 退出
     * @return
     */
    @PostMapping("/logout")
    public Result logout(){
        return Result.ok();
    }
    
}
