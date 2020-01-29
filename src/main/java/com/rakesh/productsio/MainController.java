package com.rakesh.productsio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    ProductService productService=new ProductService();

    @RequestMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping(method = RequestMethod.POST,path = "/addProduct")
    public void addProduct(@RequestBody Product product){
        Product p =new Product();
        p.setName(product.getName());
        p.setDescription(product.getDescription());
        productService.addProduct(p);

    }


}
