package ua.levelUp.InternetShop.model;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by al on 23.03.2016.
 */
public class Order  {
    private long id;
    private HashMap<Long, OrderItem> orderItems;
    private BigDecimal totalOrderCost;

    public Order() {
        orderItems = new HashMap<Long, OrderItem>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderItem addOrderItem(Product product, int quantity) {
        OrderItem currentOrderItem = orderItems.get(product.getId());
        if(currentOrderItem != null) {
            currentOrderItem.add(quantity);
        } else {
            currentOrderItem = orderItems.put(product.getId(), new OrderItem(product, quantity));
        }

        return currentOrderItem;
    };

    public OrderItem addOrderItem(Product product){
        return addOrderItem(product, 1);
    };

    public int getOrderItemQuantity(Product product)  {
        return orderItems.get(product.getId()).getQuantity();
    };

    public OrderItem deleteOrderItem(Product product, int quantity) throws ProductException  {
        OrderItem currentOrderItem = orderItems.get(product.getId());
        if(currentOrderItem != null) {
            currentOrderItem.delete(quantity);
        }

//        add deleting 4 quantity 0 values

        return currentOrderItem;
    }

    private BigDecimal calculateTotalCost() {
        totalOrderCost = new BigDecimal(0);
//        for (HashMap<Long, OrderItem> items: orderItems.values())  {
//            totalOrderCost = totalOrderCost.add(items.getOrderItemPrice());
//        }
        Iterator it = orderItems.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, OrderItem> entry = (Map.Entry)it.next();
            totalOrderCost = totalOrderCost.add(entry.getValue().getOrderItemPrice());
        }
        return totalOrderCost;
    };

    public BigDecimal getTotalOrderCost() {
        calculateTotalCost();
        return totalOrderCost;
    }
}
