package service.impl;

import dao.BookDao;
import dao.OrderDAO;
import dao.OrderItemDAO;
import dao.impl.BookDaoImpl;
import dao.impl.OrderDAOImpl;
import dao.impl.OrderItemDAOImpl;
import pojo.*;
import service.OrderService;

import java.util.Date;
import java.util.Map;

/**
 * @author QFY
 * @Description
 * @create 2021-05-26 17:29
 */
public class OrderServiceImpl implements OrderService {
    private OrderDAO orderDAO =new OrderDAOImpl();
    private OrderItemDAO orderItemDAO=new OrderItemDAOImpl();
    private BookDao bookDao=new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号唯一性
        String orderId=System.currentTimeMillis()+""+userId;
        Order order=new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDAO.saveOrder(order);

        //遍历购物车中每一个商品项转成订单项保存到数据库
        for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {
            //获取购物车里每一个商品项
            CartItem cartItem = entry.getValue();
            //转成订单项
            OrderItem orderItem=new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(), cartItem.getTotalPrice(),orderId);
            //保存
            orderItemDAO.saveOrderItem(orderItem);
            //更新图书的库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        cart.clean();

        return orderId;
    }
}
