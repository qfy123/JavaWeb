package test;

import org.junit.Test;
import pojo.Cart;
import pojo.CartItem;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author QFY
 * @Description
 * @create 2021-05-26 17:40
 */
public class OrderServiceTest {

    @Test
    public void createOrder() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"java",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"php",1,new BigDecimal(100),new BigDecimal(100)));
        OrderService orderService=new OrderServiceImpl();
        System.out.println("订单号是"+orderService.createOrder(cart, 1));
    }
}