package com.flamingo.sell.dao;

import com.flamingo.sell.model.entity.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {

    @Autowired
    private OrderMasterDao orderMasterDao;

    private final String OPENID = "118";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("秦小二");
        orderMaster.setBuyerPhone("18300019288");
        orderMaster.setBuyerAddress("xxx栋1802室");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.88));

        OrderMaster save = orderMasterDao.save(orderMaster);
        Assert.assertNotNull(save);
    }

    @Test
    public void findByBuyerOpenid() throws Exception {

        PageRequest pageRequest = new PageRequest(0, 2);
        Page<OrderMaster> result = orderMasterDao.findByBuyerOpenid(OPENID, pageRequest);
        System.out.println(result.getContent().size());
        System.out.println(result.getTotalElements());//记录总数要这样算
        // Assert.assertNotEquals(0, result.getContent().size());
    }

}