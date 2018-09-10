package com.flamingo.sell.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/***
 * 类目
 * 数据库表：product_category
 * 注解@Table(name = "product_category") //数据库表名与实体类名不对应时可设置,如果驼峰式可省略
 */
@Proxy(lazy = false)
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Entity
@DynamicUpdate
@Data //lombok可省略get,set,toString方法
public class ProductCategory {

    /** 类目id. */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    private Date updateTime;

    /***
     * 自定义构造方法
     * @param categoryName
     * @param categoryType
     */
    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    /***
     * 默认构造方法
     */
    public ProductCategory() {

    }
}
