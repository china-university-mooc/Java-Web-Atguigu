package com.itutry.test;

import com.itutry.dao.OrderItemDao;
import com.itutry.dao.impl.OrderItemDaoImpl;
import com.itutry.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderItemDaoImplTest {

    private final OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        OrderItem orderItem = new OrderItem(null, "数据结构", 1, new BigDecimal(100), new BigDecimal(100), "1");
        System.out.println(orderItemDao.saveOrderItem(orderItem));
    }
}