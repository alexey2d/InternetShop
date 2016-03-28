package ua.levelUp.InternetShop.repository.impl;

import org.springframework.stereotype.Repository;
import ua.levelUp.InternetShop.model.User;
import ua.levelUp.InternetShop.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by java on 15.02.2016.
 */
@Repository
@Transactional // надо ставить, иначе не будет генериться айди
public class UserRepositoryImpl implements UserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User save(User user) {
            entityManager.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        Query query = entityManager.createQuery("FROM User");
        return query.getResultList();
    }

    @Override
    public boolean deleteById(long id) {
        User user = findById(id);
        if (user != null) {
            entityManager.remove(user);
            return true;
        } else { return false; }
    }

    @Override
    public boolean newUser(User user) {
        if (user != null) {
            entityManager.persist(user);
            return true;
        } else { return false; }
    }
}
