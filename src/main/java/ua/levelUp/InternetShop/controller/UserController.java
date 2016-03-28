package ua.levelUp.InternetShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import ua.levelUp.InternetShop.dto.UserDto;
import ua.levelUp.InternetShop.model.Role;
import ua.levelUp.InternetShop.model.User;
import ua.levelUp.InternetShop.service.UserService;

import java.util.List;

/**
 * Created by java on 15.02.2016.
 */
@Controller
@RequestMapping("/user") // то, что добавится к урлу localhost:8080/user/
public class UserController {
    @Autowired
    UserService userService; // ссылаться надо только на интерфейсы

    // методы паблик
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getAllUsers() {
        List<User> users = userService.getAll();

        if (CollectionUtils.isEmpty(users)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(users, HttpStatus.OK);
    }

    // показывает, что дастоем из урла
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getOneById(@PathVariable("userId") long id) {
        User user = userService.findById(id);

            if (user == null) {
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(value =  "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestBody UserDto userDto) {
        User user = new User();

        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setLogin(userDto.getLogin());

        userService.save(user);

//        in case of id generation error
        if (user.getId() == 0) {
            System.out.println("User Id isn't set.");
        }

        return "New user created {  \"id\" : \"" + Long.toString(user.getId()) + "\" }";
    }
}