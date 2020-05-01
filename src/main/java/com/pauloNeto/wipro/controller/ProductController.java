package com.pauloNeto.wipro.controller;

import com.pauloNeto.wipro.model.Product;
import com.pauloNeto.wipro.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/activateProducts")
    public List<Product> getActivateProducts(){
        return productService.getActivatedProducts();
    }

    @GetMapping("/inactivateProducts")
    public List<Product> getInactivateProducts(){
        return productService.getInactivatedProducts();
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody  Product product){
        return productService.newProduct(product);
    }

    @RequestMapping(value = "/products/{code}", method = RequestMethod.PATCH)
    public Product editProduct(@PathVariable String code, @RequestBody Product product){
        return productService.editProduct(code, product);
    }

    @GetMapping("products/{code}")
    public Product getProduct(@PathVariable String code){
        return productService.getProductByCode(code);
    }

    @RequestMapping(value = "/inactivate/{code}", method = RequestMethod.PATCH)
    public Product inactivateProduct(@PathVariable String code){
        return productService.editActivation(code);
    }

}
