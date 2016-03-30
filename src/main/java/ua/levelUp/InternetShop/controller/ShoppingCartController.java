package ua.levelUp.InternetShop.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.levelUp.InternetShop.model.Product;
import ua.levelUp.InternetShop.model.ShoppingCart;
import ua.levelUp.InternetShop.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by java on 28.03.2016.
 */
@Component
@Scope("session")
@JsonIgnoreProperties(ignoreUnknown = true)
@RequestMapping("/cart") // то, что добавится к урлу localhost:8080/cart/
public class ShoppingCartController {
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "showCart", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ShoppingCart> getCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        return new ResponseEntity(shoppingCart, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id_prod}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity showCart(@PathVariable("id_prod") long id, Model model, HttpServletRequest httpServletRequest) {
//    public ResponseEntity showCart(@PathVariable long id_prod, Model model, HttpServletRequest httpServletRequest) {
/*
//      Skityashin code
        Product productCart = productService.findById(id_prod);
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        shoppingCartItem.setQuantity(productCart.getQuantity());
        shoppingCartItem.setProduct(productCart);
        httpSession = httpServletRequest.getSession(true);
        httpSession.setAttribute("cart", shoppingCartItem);
        ShoppingCart cart = (ShoppingCart) httpSession.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
            cart.addItem(shoppingCartItem);
            httpSession.setAttribute("cart", cart);
        } else {
            cart.addItem(shoppingCartItem);
            httpSession.setAttribute("cart", cart);
        }
        model.addAttribute("totalAmount", cart.getTotalAmount());
        model.addAttribute("totalCost",  cart.getTotalCost());
        return new ResponseEntity(model, HttpStatus.OK);
        //end of Skityashing code
        */
        Product product = productService.findById(id);
        ShoppingCart shoppingCart;
        httpSession = httpServletRequest.getSession(true);
        shoppingCart = (ShoppingCart) httpServletRequest.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();

        }
        shoppingCart.addOrderItem(product);
        httpServletRequest.setAttribute("cart", shoppingCart);
        model.addAttribute("totalAmount", shoppingCart.getTotalCartItemsQuantity());
        model.addAttribute("totalCost",  shoppingCart.getTotalCartCost());

        return new ResponseEntity(model, HttpStatus.OK);
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
