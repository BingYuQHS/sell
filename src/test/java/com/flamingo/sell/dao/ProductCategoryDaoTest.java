package com.flamingo.sell.dao;

import com.flamingo.sell.model.entity.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

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
    @Transactional
    public void saveTest() {
        ProductCategory productCategory = new ProductCategory("女生最爱榜",4);
        ProductCategory result = productCategoryDao.save(productCategory);
        Assert.assertNotNull(result);
        // Assert.assertNotEquals(null,result);
    }

    @Test
    @Transactional
    public void updateOne() {
        ProductCategory productCategory = productCategoryDao.findOne(2);
        productCategory.setCategoryName("男生最爱榜");
        productCategoryDao.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> typeList = Arrays.asList(2,3,4,5);
        List<ProductCategory> result = productCategoryDao.findByCategoryTypeIn(typeList);
        Assert.assertNotEquals(0,result.size());
    }
}