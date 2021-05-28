package dao.impl;

import dao.OrderItemDAO;
import pojo.OrderItem;

/**
 * @author QFY
 * @Description
 * @create 2021-05-26 17:12
 */
public class OrderItemDAOImpl extends BaseDao implements OrderItemDAO {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql="insert into t_order_item(`name`,`count`,price,`total_price`,order_id) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
