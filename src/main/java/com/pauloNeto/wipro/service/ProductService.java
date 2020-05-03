package com.pauloNeto.wipro.service;

import com.pauloNeto.wipro.model.Product;
import com.pauloNeto.wipro.model.ProductActivation;
import com.pauloNeto.wipro.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
                .filter(product -> ProductActivation.ACTIVE.equals(product.getProductActivation()))
                .collect(Collectors.toList());
    }

    public List<Product> getInactivatedProducts(){
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .filter(product -> ProductActivation.INACTIVE.equals(product.getProductActivation()))
                .collect(Collectors.toList());
    }

    public Product editProduct(String code, Product product){
        deleteProduct(code);
        return productRepository.save(product);
    }

    public void deleteProduct(String code){
        productRepository.deleteById(code);
    }

    public Optional<Product> getProductByCode(String code){
        return productRepository.findById(code);
    }

    public Product editActivation(String code){
        Product product = productRepository.getOne(code);
        product.setProductActivation(ProductActivation.INACTIVE);
        return editProduct(code, product);
    }
}
