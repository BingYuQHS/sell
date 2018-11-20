package com.flamingo.sell.enums;

import lombok.Getter;

/**
 * 返回前端的消息枚举
 */
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10001,"商品不存在"),

    PRODUCT_STOCK_ERROR(10002,"商品库存不正确"),

    ORDER_NOT_EXIST(10003,"订单不存在"),

    ORDERDETAIL_NOT_EXIST(10004,"订单详情不存在"),

    ORDER_STATUS_ERROR(10005,"订单状态不正确"),

    ORDER_UPDATE_FAIL(10006,"订单更新失败"),

    ORDER_DETAIL_EMPTY(10007,"订单详情为空"),

    ORDER_PAY_STATUS_ERROR(10008,"订单支付状态不正确"),

    //表单验证异常
    PARAM_ERROR(20001,"参数不正确"),

    CART_EMPTY(20002,"购物车为空"),

    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
