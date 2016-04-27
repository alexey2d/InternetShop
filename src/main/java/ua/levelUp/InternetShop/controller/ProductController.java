package ua.levelUp.InternetShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.security.crypto.keygen.StringKeyGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.levelUp.InternetShop.model.Product;
import ua.levelUp.InternetShop.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by java on 28.03.2016.
 */

@Controller
@RequestMapping("/product") // то, что добавится к урлу localhost:8080/product/
public class ProductController {
    @Autowired
    ProductService productService; // ссылаться надо только на интерфейсы

    // методы паблик
    @RequestMapping(value = "getAll", method = RequestMethod.GET)
//    тут не нужен @ResponseBody
        public String getAllProducts(Model model, HttpServletRequest httpServletRequest) {
        List<Product> products = productService.getAll();

        HttpSession httpSession = httpServletRequest.getSession(true);

        String sortType = httpServletRequest.getParameter("sort");
        if (sortType == null) sortType = "";
        switch (sortType){
//            by title
            case "title" : Collections.sort(products, new Comparator(){
                public int compare(Object o1, Object o2) {
                    Product pr1 = (Product)o1;
                    Product pr2 = (Product)o2;
                    int compareResultTitle = pr1.getTitle().compareToIgnoreCase(pr2.getTitle());
                    return compareResultTitle != 0 ? compareResultTitle : pr1.getPrice().compareTo(pr2.getPrice());
                }
            });
                break;
//            by price inc
            case "price_inc" : Collections.sort(products, new Comparator(){
                public int compare(Object o1, Object o2) {
                    Product pr1 = (Product)o1;
                    Product pr2 = (Product)o2;
                    int compareResultPrice = pr1.getPrice().compareTo(pr2.getPrice());
                    return compareResultPrice != 0 ? compareResultPrice : pr1.getTitle().compareTo(pr2.getTitle());
                }
            });
                break;
            // by price desc
            case "price_desc" : Collections.sort(products, new Comparator(){
                    public int compare(Object o1, Object o2) {
                        Product pr1 = (Product)o1;
                        Product pr2 = (Product)o2;
                        int compareResultPrice = -1 * pr1.getPrice().compareTo(pr2.getPrice());
                        return compareResultPrice != 0 ? compareResultPrice : pr1.getPrice().compareTo(pr2.getPrice());
                    }
                });
                break;
            default:
                break;
        }

        model.addAttribute("products", products);
        return "getProducts";
        //ссылается на tiles.xml, где мапинг на allProd.jsp
        // ( <put-attribute name="body" value="/WEB-INF/views/allProd.jsp"/>)
    }
    @RequestMapping(value = "{productId}", method = RequestMethod.GET)
    public String getProductById(@PathVariable("productId") long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("title", product.getTitle());
        model.addAttribute("price", product.getPrice());
        model.addAttribute("description", product.getDescription());

        return "prodId";
    }

}
