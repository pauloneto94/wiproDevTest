package com.pauloNeto.wipro.controller;

import com.pauloNeto.wipro.model.Product;
import com.pauloNeto.wipro.service.ProductService;
import com.pauloNeto.wipro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    UserService userService;

    @GetMapping("/activateProducts")
    public ResponseEntity<List<Product>> getActivateProducts(){
        if(userService.currentUser == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else return ResponseEntity.status(HttpStatus.OK).body(productService.getActivatedProducts());
    }

    @GetMapping("/inactivateProducts")
    public ResponseEntity<List<Product>> getInactivateProducts(){
        if(userService.currentUser == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else return ResponseEntity.status(HttpStatus.OK).body(productService.getInactivatedProducts());
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody  Product product){
        if(userService.currentUser == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else return ResponseEntity.status(HttpStatus.OK).body(productService.newProduct(product));
    }

    @RequestMapping(value = "/products/{code}", method = RequestMethod.PATCH)
    public ResponseEntity<Product> editProduct(@PathVariable String code, @RequestBody Product product){
        if(userService.currentUser == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else return ResponseEntity.status(HttpStatus.OK).body(productService.editProduct(code, product));
    }

    @GetMapping("products/{code}")
    public ResponseEntity<Product> getProduct(@PathVariable String code){
        if(userService.currentUser == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByCode(code));
    }

    @RequestMapping(value = "/inactivate/{code}", method = RequestMethod.PATCH)
    public ResponseEntity<Product> inactivateProduct(@PathVariable String code){
        if(userService.currentUser == null) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else return ResponseEntity.status(HttpStatus.OK).body(productService.editActivation(code));
    }

}
