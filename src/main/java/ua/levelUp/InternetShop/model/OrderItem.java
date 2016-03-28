package ua.levelUp.InternetShop.model;

import java.math.BigDecimal;

/**
 * Created by al on 23.03.2016.
 */
public class OrderItem {
    private Product product;
    private int quantity;
    private BigDecimal totalPrice; //  = new BigDecimal(0);


    public OrderItem() {
        this.quantity = 0;
    }

    public OrderItem(Product product) {
        this.product = product;
        this.quantity = 1;
    }

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public BigDecimal getOrderItemPrice() {
        totalPrice = new BigDecimal(quantity);
        totalPrice = totalPrice.multiply(product.getPrice());
        return totalPrice;
    }

    public void add(int quantity) {
        this.quantity += quantity;
    }

    public void delete(int quantity) throws ProductException{
        if(this.quantity - quantity < 0 ) {
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
        return Long.hashCode(product.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;

        OrderItem orderItem = (OrderItem) o;

        if (getQuantity() != orderItem.getQuantity()) return false;
        return getProduct().equals(orderItem.getProduct());

    }
}
