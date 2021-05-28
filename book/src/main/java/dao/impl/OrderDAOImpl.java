package dao.impl;

import dao.OrderDAO;
import pojo.Order;

/**
 * @author QFY
 * @Description
 * @create 2021-05-26 17:09
 */
public class OrderDAOImpl extends BaseDao implements OrderDAO {
    @Override
    public int saveOrder(Order order) {
        String sql="insert into t_order(order_id,create_time,price,`status`,user_id) values(?,?,?,?,?)";
        return update(sql,order.getOrderId(), order.getCreateTime(),order.getPrice(),order.getStatus(), order.getUserId());
    }
}
