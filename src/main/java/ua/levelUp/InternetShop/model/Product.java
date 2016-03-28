package ua.levelUp.InternetShop.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by java on 15.02.2016.
 */
@Entity
@Table(name = "product")
public class Product {
    private long id;
    private String title;
    private String description;
    private BigDecimal price;

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getTitle() {
        return title;
    }

    @Column
    public String getDescription() {
        return description;
    }

    @Column
    public BigDecimal getPrice() {
        return price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
