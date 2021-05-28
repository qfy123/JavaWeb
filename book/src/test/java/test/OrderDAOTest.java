package test;

import dao.OrderDAO;
import dao.impl.OrderDAOImpl;
import org.junit.Test;
import pojo.Order;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author QFY
 * @Description
 * @create 2021-05-26 17:16
 */
public class OrderDAOTest {
    private OrderDAO orderDAO=new OrderDAOImpl();
    @Test
    public void saveOrder() {
        orderDAO.saveOrder(new Order("12121212",new Date(),new BigDecimal(100),0,1));
    }
}