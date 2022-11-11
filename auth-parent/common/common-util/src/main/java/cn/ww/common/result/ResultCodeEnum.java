package cn.ww.common.result;

import lombok.Getter;

/**
 * @author Suww
 * @createTime 2022-10-26
 */
@Getter
public enum ResultCodeEnum {
    /**
     * 成功
     */
    SUCCESS(200,"成功"),
    /**
     * 失败
     */
    FAIL(201, "失败"),
    /**
     * 服务异常
     */
    SERVICE_ERROR(2012, "服务异常"),
    /**
     * 数据异常
     */
    DATA_ERROR(204, "数据异常"),
    /**
     * 非法请求
     */
    ILLEGAL_REQUEST(205, "非法请求"),
    /**
     * 重复提交
     */
    REPEAT_SUBMIT(206, "重复提交"),
    /**
     * 参数校验异常
     */
    ARGUMENT_VALID_ERROR(210, "参数校验异常"),
    /**
     * 未登陆
     */
    LOGIN_AUTH(208, "未登陆"),
    /**
     * 没有权限
     */
    PERMISSION(209, "没有权限"),
    /**
     * 账号不正确
     */
    ACCOUNT_ERROR(214, "账号不正确"),
    /**
     * 密码不正确
     */
    PASSWORD_ERROR(215, "密码不正确"),
    /**
     * 账号不正确
     */
    LOGIN_MOBILE_ERROR( 216, "账号不正确"),
    /**
     * 账号已停用
     */
    ACCOUNT_STOP( 217, "账号已停用"),
    /**
     * 该节点下有子节点，不可以删除
     */
    NODE_ERROR( 218, "该节点下有子节点，不可以删除")
    ;

    private Integer code;

    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
