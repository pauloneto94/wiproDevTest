package com.pauloNeto.wipro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pauloNeto.wipro.model.Product;
import com.pauloNeto.wipro.model.ProductActivation;
import com.pauloNeto.wipro.repository.ProductRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ProductControllerTest {

    private static final ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductRepository productRepository;

    @Before
    public void addProducts(){
        Product product = new Product();
        product.setCode("1");product.setDescription("product");product.setProductActivation(ProductActivation.ACTIVE);
        product.setPrice(10);product.setDate(new Date());
        Product otherProduct = new Product();
        otherProduct.setCode("2");otherProduct.setDescription("product2");otherProduct.setDate(new Date());
        otherProduct.setProductActivation(ProductActivation.INACTIVE);otherProduct.setPrice(20);

        productRepository.save(product);
        productRepository.save(otherProduct);
    }

    @After
    public void deleteProdyucts(){

        Product product = new Product();
        product.setCode("1");product.setDescription("product");product.setProductActivation(ProductActivation.ACTIVE);
        product.setPrice(10);
        Product otherProduct = new Product();
        otherProduct.setCode("2");otherProduct.setDescription("product2");
        otherProduct.setProductActivation(ProductActivation.INACTIVE);otherProduct.setPrice(20);

        productRepository.delete(product);
        productRepository.delete(otherProduct);
    }

    @Test
    public void getActivateProductsTest() throws Exception{
        mockMvc.perform(get("/activateProducts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code", is("1")))
                .andExpect(jsonPath("$[0].description", is("product")))
                .andExpect(jsonPath("$[0].productActivation", is("ACTIVE")))
                .andExpect(jsonPath("$[0].price", is(10)));
    }

    @Test
    public void getInactivateProductsTest() throws Exception{
        mockMvc.perform(get("/inactivateProducts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code", is("2")))
                .andExpect(jsonPath("$[0].description", is("product2")))
                .andExpect(jsonPath("$[0].productActivation", is("INACTIVE")))
                .andExpect(jsonPath("$[0].price", is(20)));
    }

    @Test
    public void getProductTest() throws Exception{
        mockMvc.perform(get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is("1")))
                .andExpect(jsonPath("$.description", is("product")))
                .andExpect(jsonPath("$.productActivation", is("ACTIVE")))
                .andExpect(jsonPath("$.price", is(10)));
    }

    @Test
    public void inactivateProductTest() throws Exception{
        mockMvc.perform(get("/inactivate/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is("1")))
                .andExpect(jsonPath("$.description", is("product")))
                .andExpect(jsonPath("$.productActivation", is("INACTIVE")))
                .andExpect(jsonPath("$.price", is(10)));
    }

    @Test
    public void addProductTest() throws Exception{

        Product product = new Product();
        product.setCode("3");product.setDescription("product3");product.setProductActivation(ProductActivation.ACTIVE);
        product.setPrice(10);product.setDate(new Date());

        mockMvc.perform(post("/products")
                .content(om.writeValueAsString(product))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is("3")))
                .andExpect(jsonPath("$.description", is("product3")))
                .andExpect(jsonPath("$.productActivation", is("ACTIVE")))
                .andExpect(jsonPath("$.price", is(10)));
    }

    @Test
    public void editProductTest() throws Exception{
        Product product = new Product();
        product.setCode("2");product.setDescription("product3");product.setProductActivation(ProductActivation.ACTIVE);
        product.setPrice(10);product.setDate(new Date());

        mockMvc.perform(patch("/products/2")
                .content(om.writeValueAsString(product))
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code", is("2")))
                .andExpect(jsonPath("$.description", is("product3")))
                .andExpect(jsonPath("$.productActivation", is("ACTIVE")))
                .andExpect(jsonPath("$.price", is(10)));
    }

}
