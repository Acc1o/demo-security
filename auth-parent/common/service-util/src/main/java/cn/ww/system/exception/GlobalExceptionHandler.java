package cn.ww.system.exception;

import cn.ww.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Suww
 * @createTime 2022-10-28
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        System.out.println("全局======<>");
        e.printStackTrace();
        return Result.fail().message("执行了全局异常处理");
    }

    /**
     * 特定异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
     public Result error(ArithmeticException e){
        System.out.println("特定======<>");
         e.printStackTrace();
         return Result.fail().message("执行了特定异常处理");
     }

    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(HandleException.class)
    @ResponseBody
    public Result error(HandleException e){
        System.out.println("特定======<>");
        e.printStackTrace();
        return Result.fail().code(e.getCode()).message(e.getMsg());
    }
    
}
