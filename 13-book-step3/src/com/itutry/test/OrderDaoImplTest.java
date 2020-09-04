package com.itutry.test;

import com.itutry.dao.OrderDao;
import com.itutry.dao.impl.OrderDaoImpl;
import com.itutry.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

public class OrderDaoImplTest {

    private final OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOder() {
        Order order = new Order("1", new Date(), new BigDecimal(100), 0, 4);
        System.out.println(orderDao.saveOder(order));
    }
}