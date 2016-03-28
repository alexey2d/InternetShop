package ua.levelUp.InternetShop.model;

import java.util.Properties;

/**
 * Created by al on 23.03.2016.
 */
public class ProductException extends Exception {
    public ProductException() {
    }

    public ProductException(String msg){
        super(msg);
    }
}
