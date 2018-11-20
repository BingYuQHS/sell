package com.flamingo.sell.service.impl;

import com.flamingo.sell.enums.ResultEnum;
import com.flamingo.sell.exception.SellException;
import com.flamingo.sell.model.dto.OrderDTO;
import com.flamingo.sell.service.BuyerService;
import com.flamingo.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 买家
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid,orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (null == orderDTO){
            log.error("【取消订单】 查不到该订单, orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (null == orderDTO){
            return null;
        }
        //判断是否是当前用户的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】 订单的openid不一致, openid={}, orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.OREDR_OWNER_ERROR);
        }
        return orderDTO;
    }
}
