package cn.ww.model.vo;

import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
/**
 * @author Suww
 */
@Data
public class SysLoginLogQueryVo {
	
	@ApiModelProperty(value = "用户账号")
	private String username;

	private String createTimeBegin;
	private String createTimeEnd;

}

