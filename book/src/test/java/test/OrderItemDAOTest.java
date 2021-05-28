package test;

import dao.OrderItemDAO;
import dao.impl.OrderItemDAOImpl;
import org.junit.Test;
import pojo.OrderItem;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author QFY
 * @Description
 * @create 2021-05-26 17:24
 */
public class OrderItemDAOTest {
    private OrderItemDAO orderItemDAO=new OrderItemDAOImpl();
    @Test
    public void saveOrderItem() {
        orderItemDAO.saveOrderItem(new OrderItem(null,"java",1,new BigDecimal(199),new BigDecimal(199),"12121212"));
    }
}