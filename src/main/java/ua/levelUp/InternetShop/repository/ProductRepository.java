package ua.levelUp.InternetShop.repository;

import ua.levelUp.InternetShop.model.Product;

import java.util.List;

/**
 * Created by java on 20.03.2016.
 */
public interface ProductRepository {
    Product save(Product product);
    Product update(Product product);
    Product findById(long id);
    List<Product> getAll();
    boolean deleteById(long id);
    Product findOneByTitle(String title);
}
