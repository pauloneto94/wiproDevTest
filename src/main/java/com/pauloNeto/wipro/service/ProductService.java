package com.pauloNeto.wipro.service;

import com.pauloNeto.wipro.model.Product;
import com.pauloNeto.wipro.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product newProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getActivatedProducts(){
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .filter(product -> "active".equals(product.getDescription()))
                .collect(Collectors.toList());
    }

    public List<Product> getInactivatedProducts(){
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .filter(product -> "inactive".equals(product.getDescription()))
                .collect(Collectors.toList());
    }

    public Product editProduct(String code, Product product){
        deleteProduct(code);
        return productRepository.save(product);
    }

    public void deleteProduct(String code){
        productRepository.deleteById(code);
    }

    public Product getProductByCode(String code){
        return productRepository.getOne(code);
    }

    public Product editActivation(String code){
        Product product = productRepository.getOne(code);
        product.setDescription("inactive");
        return editProduct(code, product);
    }
}
