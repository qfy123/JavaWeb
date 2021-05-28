package pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author QFY
 * @Description
 * @create 2021-05-26 10:34
 */
public class Cart {
//    private Integer totalCount;
//    private BigDecimal totalPrice;
    //key是商品编号，value是商品信息
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>();

    /**
     * 添加商品
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        //先查看是否已经添加，如果已经添加，数量更新，总金额更新；如果没有添加过，直接添加
        CartItem item = items.get(cartItem.getId());
        if (item==null){
            //null说明没有添加过
            items.put(cartItem.getId(),cartItem);
        }
        else {
            //已经添加过
            item.setCount(item.getCount()+1);//数量累加
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//总金额更新
        }
    }

    /**
     * 删除商品项
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空购物车
     */
    public void clean(){
        items.clear();
    }

    /**
     * 修改商品数量
     */
    public void updateCount(Integer id,Integer count){
        //先查看购物车中是否有此商品，如果有，修改商品数量，更新总金额
        CartItem cartItem = items.get(id);
        if (cartItem!=null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }
    public Integer getTotalCount() {
        Integer totalCount=0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
           totalCount+= entry.getValue().getCount();
        }

        return totalCount;
    }



    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice=new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice=totalPrice.add(entry.getValue().getTotalPrice());

        }

        return totalPrice;
    }



    public Map<Integer,CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer,CartItem> items) {
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
