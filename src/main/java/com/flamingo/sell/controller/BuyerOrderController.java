package com.flamingo.sell.controller;

import com.flamingo.sell.converter.OrderForm2OrderDTOConverter;
import com.flamingo.sell.enums.ResultEnum;
import com.flamingo.sell.exception.SellException;
import com.flamingo.sell.form.OrderForm;
import com.flamingo.sell.model.dto.OrderDTO;
import com.flamingo.sell.model.vo.ResultVO;
import com.flamingo.sell.service.OrderService;
import com.flamingo.sell.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 买家订单api
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】 参数不正确, orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);

        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String ,String > map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtil.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】 openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    "openid不能为空");
        }
        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultVOUtil.success(orderDTOPage.getContent());//列表
        // orderDTOPage.getTotalElements();总数
        // orderDTOPage.getTotalPages();总页数
        // page;第几页

    }

    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId){
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单详情】 openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    "openid不能为空");
        }
        if (StringUtils.isEmpty(orderId)) {
            log.error("【查询订单详情】 orderId为空");
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    "orderId不能为空");
        }

        //TODO openid传来还未使用 有越权访问，不安全 需改进
        OrderDTO orderDTO = orderService.findOne(orderId);
        return ResultVOUtil.success(orderDTO);

    }

    //取消订单

}
