package ua.levelUp.InternetShop.model;

import com.google.common.primitives.Longs;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.math.BigDecimal;

/**
 * Created by al on 23.03.2016.
 */
//@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartItem {
    private Product product;
    private int quantity;
    private BigDecimal totalItemPrice; //  = new BigDecimal(0);


    public ShoppingCartItem() {
        this.quantity = 0;
    }

    public ShoppingCartItem(Product product) {
        this.product = product;
        this.quantity = 1;
    }

    public ShoppingCartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal getTotalItemPrice() {
        totalItemPrice = new BigDecimal(quantity);
        totalItemPrice = totalItemPrice.multiply(product.getPrice());
        return totalItemPrice;
    }

    public void add(int quantity) {
        this.quantity += quantity;
    }

    public void delete(int quantity) throws ProductException {
        if (this.quantity - quantity < 0) {
            throw new ProductException("Amount can't be less zero.");
        } else {
            this.quantity -= quantity;
        }

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public int hashCode() {
        return Longs.hashCode(product.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCartItem)) return false;

        ShoppingCartItem shoppingCartItem = (ShoppingCartItem) o;

        if (getQuantity() != shoppingCartItem.getQuantity()) return false;
        return getProduct().equals(shoppingCartItem.getProduct());

    }
}
