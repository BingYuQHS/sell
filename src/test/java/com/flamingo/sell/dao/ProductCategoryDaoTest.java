package com.flamingo.sell.dao;

import com.flamingo.sell.model.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void findOneTest() {
        ProductCategory productCategory = productCategoryDao.findOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱榜");
        productCategory.setCategoryType(3);
        productCategoryDao.save(productCategory);
    }

    /**
     * 先查出记录，再更新记录，只更新set的数据，没有动态的更新时间
     */
    @Test
    public void updateOne() {
        ProductCategory productCategory = productCategoryDao.findOne(2);
        productCategory.setCategoryName("男生最爱榜");
        productCategory.setCategoryType(10);
        productCategoryDao.save(productCategory);
    }
}