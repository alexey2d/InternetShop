package ua.levelUp.InternetShop.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;
import ua.levelUp.InternetShop.model.Product;
import ua.levelUp.InternetShop.repository.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Queue;

/**
 * Created by java on 20.03.2016.
 */
@Repository
@Transactional // надо ставить, иначе не будет генериться айди
public class ProductRepositoryImpl implements ProductRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        entityManager.merge(product);
        return product;
    }

    @Override
    public Product findById(long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public List<Product> getAll() {
        Query query = entityManager.createQuery("FROM Product");
        return query.getResultList();
    }

    @Override
    public boolean deleteById(long id) {
        Product product = findById(id);
        if(product != null) {
            entityManager.remove(product);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Product findOneByTitle(String title) {
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.title= :title");
        query.setParameter("title", title);
        List<Product> products = query.getResultList();
        if (!CollectionUtils.isEmpty(products)) {
            return products.get(0);
        }
        return null;
    }
}
