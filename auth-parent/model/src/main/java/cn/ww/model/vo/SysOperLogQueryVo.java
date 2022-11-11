package cn.ww.model.vo;

import lombok.Data;
/**
 * @author Suww
 */
@Data
public class SysOperLogQueryVo {

	private String title;
	private String operName;

	private String createTimeBegin;
	private String createTimeEnd;

}

