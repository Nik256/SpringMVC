package com.epam.mvc.controller;

import com.epam.mvc.ProductApp;
import com.epam.mvc.model.Product;
import com.epam.mvc.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ProductApp.class})
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SpyBean
    private ProductService productService;

    @Test
    @WithMockUser(authorities = "USER")
    public void testProductList() throws Exception {
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("productList"));
    }

    @Test
    @WithMockUser
    public void testProductDeletion() throws Exception {
        int id = 0;
        assertNotNull(productService.getProduct(id));
        mockMvc.perform(get("/delete-product/{id}", id))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/products"));
        assertNull(productService.getProduct(id));
    }

    @Test
    @WithMockUser
    public void testProductCreation() throws Exception {
        Product product = new Product(0, "test name", "test description");
        mockMvc.perform(post("/create-product")
                .param("id", String.valueOf(product.getId()))
                .param("name", product.getName())
                .param("description", product.getDescription()))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/products"));
        assertNotNull(productService.getProductsByName(product.getName()));
    }

    public static String asJsonString(Product product) {
        try {
            return new ObjectMapper().writeValueAsString(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
