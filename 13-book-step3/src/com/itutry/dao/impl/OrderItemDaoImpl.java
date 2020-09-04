package com.itutry.dao.impl;

import com.itutry.dao.BaseDao;
import com.itutry.dao.OrderItemDao;
import com.itutry.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into order_item(name, count, price, total_price, order_id) values (?,?,?,?,?)";
        return update(sql, orderItem.getName(), orderItem.getCount(),
                orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
