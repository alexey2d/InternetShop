package ua.levelUp.InternetShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.levelUp.InternetShop.model.Product;
import ua.levelUp.InternetShop.service.ProductService;

import java.util.List;

/**
 * Created by java on 24.04.2016.
 */
// Start page
@Controller
@RequestMapping("/hello") // то, что добавится к урлу localhost:8080/hello/
public class HelloController {
    @Autowired
    ProductService productService; // ссылаться надо только на интерфейсы

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showMainPage(Model model) {
        List<Product> products = productService.getAll();

        model.addAttribute("products", products);

//        return "start";
        return("getProducts");
    }
}
