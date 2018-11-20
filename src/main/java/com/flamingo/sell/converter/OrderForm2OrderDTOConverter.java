package com.flamingo.sell.converter;

import com.flamingo.sell.enums.ResultEnum;
import com.flamingo.sell.exception.SellException;
import com.flamingo.sell.form.OrderForm;
import com.flamingo.sell.model.dto.OrderDTO;
import com.flamingo.sell.model.entity.OrderDetail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * orderform对象转orderDTO
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        //jsonStr转List<OrderDetail>对象,要注意jsonStr格式不正确的情况
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转换】 错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
