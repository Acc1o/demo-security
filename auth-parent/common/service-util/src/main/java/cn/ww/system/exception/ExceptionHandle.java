package cn.ww.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Suww
 * @createTime 2022-10-28
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionHandle extends RuntimeException{
    
    private Integer code;
    private String msg;
    
}
