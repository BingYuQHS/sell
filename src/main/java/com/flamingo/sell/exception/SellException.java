package com.flamingo.sell.exception;

import com.flamingo.sell.enums.ResultEnum;

/**
 * 异常处理
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();

    }
}
