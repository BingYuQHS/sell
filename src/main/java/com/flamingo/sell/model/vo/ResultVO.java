package com.flamingo.sell.model.vo;

import lombok.Data;

/***
 * http请求返回的最外层对象
 */
@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 返回的内容. */
    private T data;

}
