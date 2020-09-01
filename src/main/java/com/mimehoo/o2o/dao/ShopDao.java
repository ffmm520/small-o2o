package com.mimehoo.o2o.dao;

import com.mimehoo.o2o.entity.Shop;

public interface ShopDao {
    /**
     * 新增店铺
     * @param shop 店铺信息
     * @return 影响的行数
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息
     * @param shop
     * @return 印象行数
     */
    int updateShop(Shop shop);
}
