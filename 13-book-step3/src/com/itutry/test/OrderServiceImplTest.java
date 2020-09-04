package com.itutry.test;

import com.itutry.pojo.Cart;
import com.itutry.pojo.CartItem;
import com.itutry.service.OrderService;
import com.itutry.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceImplTest {

    private final OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(150), new BigDecimal(150)));

        System.out.println(orderService.createOrder(cart, 1));
    }
}