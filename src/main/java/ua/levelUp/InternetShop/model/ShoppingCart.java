package ua.levelUp.InternetShop.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by al on 23.03.2016.
 */
public class ShoppingCart {
    private long id;
    private HashMap<Long, ShoppingCartItem> shoppingCartItemHashMap;
    private BigDecimal totalCartCost;

    public ShoppingCart() {
        shoppingCartItemHashMap = new HashMap<Long, ShoppingCartItem>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ShoppingCartItem addOrderItem(Product product, int quantity) {
        ShoppingCartItem currentShoppingCartItem = shoppingCartItemHashMap.get(product.getId());
        if(currentShoppingCartItem != null) {
            currentShoppingCartItem.add(quantity);
        } else {
            currentShoppingCartItem = shoppingCartItemHashMap.put(product.getId(), new ShoppingCartItem(product, quantity));
        }

        return currentShoppingCartItem;
    };

    public ShoppingCartItem addOrderItem(Product product){
        return addOrderItem(product, 1);
    };

    public int getCartItemQuantity(Product product)  {
        return shoppingCartItemHashMap.get(product.getId()).getQuantity();
    };

    public ShoppingCartItem deleteOrderItem(Product product, int quantity) throws ProductException  {
        ShoppingCartItem currentShoppingCartItem = shoppingCartItemHashMap.get(product.getId());
        if(currentShoppingCartItem != null) {
            currentShoppingCartItem.delete(quantity);
        }

//        add deleting 4 quantity 0 values

        return currentShoppingCartItem;
    }

    private BigDecimal calculateTotalCost() {
        totalCartCost = new BigDecimal(0);
//        for (HashMap<Long, ShoppingCartItem> items: shoppingCartItemHashMap.values())  {
//            totalCartCost = totalCartCost.add(items.getOrderItemPrice());
//        }
        Iterator it = shoppingCartItemHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, ShoppingCartItem> entry = (Map.Entry)it.next();
            totalCartCost = totalCartCost.add(entry.getValue().getOrderItemPrice());
        }
        return totalCartCost;
    };

    public BigDecimal getTotalCartCost() {
        calculateTotalCost();
        return totalCartCost;
    }

    public int getTotalCartItemsQuantity() {
        int quantity = 0;

        Iterator it = shoppingCartItemHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Long, ShoppingCartItem> entry = (Map.Entry)it.next();
            quantity += entry.getValue().getQuantity();
        }

        return quantity;
    }
}
