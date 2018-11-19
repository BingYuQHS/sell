package com.flamingo.sell.dao;

import com.flamingo.sell.model.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("111223");
        orderDetail.setOrderId("123457");
        orderDetail.setProductId("111222");
        orderDetail.setProductIcon("http://xxx.jpg");
        orderDetail.setProductName("李老冒");
        orderDetail.setProductPrice(new BigDecimal(3.21));
        orderDetail.setProductQuantity(10);

        OrderDetail save = orderDetailDao.save(orderDetail);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByOrderId() throws Exception {
        List<OrderDetail> byOrderId = orderDetailDao.findByOrderId("123457");
        Assert.assertNotEquals(0,byOrderId.size());
    }

}