package ua.levelUp.InternetShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.levelUp.InternetShop.model.User;
import ua.levelUp.InternetShop.repository.UserRepository;
import ua.levelUp.InternetShop.service.UserService;

import java.util.List;

/**
 * Created by java on 15.02.2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User can't be null");
        } else {
            return userRepository.save(user);
        }
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public boolean deleteById(long id) {
        return userRepository.deleteById(id);
    }

    @Override
    public boolean newUser(User user) {
        return userRepository.newUser(user);
    }
}
