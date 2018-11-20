package com.flamingo.sell.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import com.flamingo.sell.model.entity.OrderDetail;
import com.flamingo.sell.serializer.Date2LongSerializer;

import java.util.Date;
import java.util.List;

/**
 * OrderDTO (data transferable object)
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)//该注解限制不返回值为null的字段到前端
public class OrderDTO {

    /** 订单id. */
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家电话. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信openId. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态. 默认0新下单. */
    private Integer orderStatus;

    /** 支付状态. 默认0未支付. */
    private Integer payStatus;

    /** 创建时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间. */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    /** 一条订单对应多条订单详情记录. */
    List<OrderDetail> orderDetailList;

}
