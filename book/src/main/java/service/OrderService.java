package service;

import pojo.Cart;

/**
 * @author QFY
 * @Description
 * @create 2021-05-26 17:28
 */
public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
