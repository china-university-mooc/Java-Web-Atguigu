package com.itutry.pojo;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public void addItem(CartItem item) {
        CartItem cartItem = items.get(item.getId());
        if (null == cartItem) {
            items.put(item.getId(), item);
        } else {
            cartItem.setCount(cartItem.getCount() + 1);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(BigDecimal.valueOf(cartItem.getCount())));
        }
    }

    public void deleteItem(Integer id) {
        items.remove(id);
    }

    public void clear() {
        items.clear();
    }

    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(BigDecimal.valueOf(cartItem.getCount())));
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;

        for (CartItem value : items.values()) {
            totalCount += value.getCount();
        }

        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.valueOf(0);

        for (CartItem value : items.values()) {
            totalPrice = totalPrice.add(value.getTotalPrice());
        }

        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
