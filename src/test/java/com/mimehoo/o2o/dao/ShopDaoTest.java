package com.mimehoo.o2o.dao;

import com.mimehoo.o2o.BaseTest;
import com.mimehoo.o2o.entity.Area;
import com.mimehoo.o2o.entity.PersonInfo;
import com.mimehoo.o2o.entity.Shop;
import com.mimehoo.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;

    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        Area area = new Area();
        ShopCategory shopCategory = new ShopCategory();
        owner.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCateGoryId(1L);
        shop.setOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopAddr("test");
        shop.setShopDesc("test");
        shop.setShopImg("test");
        shop.setPhone("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.insertShop(shop);
        System.out.println(effectedNum);
    }
    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("测试的店铺");
        shop.setShopAddr("测试地址");
        shop.setShopDesc("测试描述");
        shop.setShopImg("test");
        shop.setPhone("test");
        shop.setLastEditTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");
        int effectedNum = shopDao.updateShop(shop);
        System.out.println(effectedNum);
    }
}
