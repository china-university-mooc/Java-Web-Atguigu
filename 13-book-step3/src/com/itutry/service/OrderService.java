package com.itutry.service;

import com.itutry.pojo.Cart;

public interface OrderService {

    String createOrder(Cart cart, Integer userId);
}
