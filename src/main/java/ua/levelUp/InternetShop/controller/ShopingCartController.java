package ua.levelUp.InternetShop.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.levelUp.InternetShop.model.Order;
import ua.levelUp.InternetShop.model.User;
import ua.levelUp.InternetShop.service.ProductService;

import javax.servlet.http.HttpSession;

/**
 * Created by java on 28.03.2016.
 */
@Component
@Scope("session")
@JsonIgnoreProperties(ignoreUnknown = true)
@RequestMapping("/cart") // то, что добавится к урлу localhost:8080/cart/
public class ShopingCartController {
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "showCart", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Order> getCart() {
        Order order = new Order();
        return new ResponseEntity(order, HttpStatus.OK);
    }

/*
получаем сессию
получаем карту
если шопингкарта не равна нулю - добавляем в нее аттрибут - product

ShoppingCart cart;
        session = request.getSession(true);

        cart = (ShoppingCart) session.getAttribute("cart");
        if (cart != null) {
            cart.addItem(cartItem);
            session.setAttribute("cart", cart);
            cart = (ShoppingCart) session.getAttribute("cart");
        }


*/
}
