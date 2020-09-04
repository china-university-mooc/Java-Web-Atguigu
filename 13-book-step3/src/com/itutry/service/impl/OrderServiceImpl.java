package com.itutry.service.impl;

import com.itutry.dao.BookDao;
import com.itutry.dao.OrderDao;
import com.itutry.dao.OrderItemDao;
import com.itutry.dao.impl.BookDaoImpl;
import com.itutry.dao.impl.OrderDaoImpl;
import com.itutry.dao.impl.OrderItemDaoImpl;
import com.itutry.pojo.Book;
import com.itutry.pojo.Cart;
import com.itutry.pojo.CartItem;
import com.itutry.pojo.Order;
import com.itutry.pojo.OrderItem;
import com.itutry.service.OrderService;

import java.util.Date;

public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao = new OrderDaoImpl();
    private final OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        String orderId = System.currentTimeMillis() + "" + userId;

        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOder(order);

        for (CartItem item : cart.getItems().values()) {
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getCount(),
                    item.getPrice(), item.getTotalPrice(), orderId);
            orderItemDao.saveOrderItem(orderItem);

            // 修改库存和销量
            Book book = bookDao.queryBookById(item.getId());
            book.setSales(book.getSales() + item.getCount());
            book.setStock(book.getStock() - item.getCount());
            bookDao.updateBook(book);
        }

        cart.clear();

        return orderId;
    }
}
