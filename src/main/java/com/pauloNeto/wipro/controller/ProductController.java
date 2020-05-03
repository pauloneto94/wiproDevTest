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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/activateProducts")
    public ResponseEntity<List<Product>> getActivateProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getActivatedProducts());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/inactivateProducts")
    public ResponseEntity<List<Product>> getInactivateProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getInactivatedProducts());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody  Product product){
        return ResponseEntity.status(HttpStatus.OK).body(productService.newProduct(product));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/products/{code}", method = RequestMethod.PATCH)
    public ResponseEntity<Product> editProduct(@PathVariable String code, @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.OK).body(productService.editProduct(code, product));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("products/{code}")
    public ResponseEntity<Product> getProduct(@PathVariable String code){
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByCode(code));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "products/{code}/inactivate", method = RequestMethod.PATCH)
    public ResponseEntity<Product> inactivateProduct(@PathVariable String code){
        return ResponseEntity.status(HttpStatus.OK).body(productService.editActivation(code));
    }

}
