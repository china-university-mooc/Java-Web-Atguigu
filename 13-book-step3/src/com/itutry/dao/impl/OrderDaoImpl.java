package com.itutry.dao.impl;

import com.itutry.dao.BaseDao;
import com.itutry.dao.OrderDao;
import com.itutry.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public int saveOder(Order order) {
        String sql = "insert into `order`(order_id, create_time, price, status, user_id) values (?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(),
                order.getPrice(), order.getStatus(), order.getUserId());
    }
}
