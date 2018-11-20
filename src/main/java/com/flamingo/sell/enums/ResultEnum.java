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
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
