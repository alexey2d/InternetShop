package ua.levelUp.InternetShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.levelUp.InternetShop.model.Product;
import ua.levelUp.InternetShop.repository.ProductRepository;
import ua.levelUp.InternetShop.service.ProductService;

import java.util.List;

/**
 * Created by java on 20.03.2016.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public Product findOneByTitle(String title) {
        return null;
    }
}
