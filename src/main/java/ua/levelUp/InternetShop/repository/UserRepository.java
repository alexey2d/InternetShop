package ua.levelUp.InternetShop.repository;

import ua.levelUp.InternetShop.model.User;

import java.util.List;

/**
 * Created by java on 15.02.2016.
 */
public interface UserRepository {
        User save(User user);
        User update(User user);
        User findById(long id);
        List<User> getAll();
        boolean deleteById(long id);
        boolean newUser(User user);
}
