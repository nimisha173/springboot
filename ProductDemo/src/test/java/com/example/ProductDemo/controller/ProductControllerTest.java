package com.example.ProductDemo.controller;

import com.example.ProductDemo.model.Product;
import com.example.ProductDemo.service.ProService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProService mockProductService;

    @Test
    void testPropost() throws Exception {
        // Setup
        // Configure ProService.propost(...).
        final Product product = new Product(0, "pname", "pprice", "pcategory");
        when(mockProductService.propost(new Product(0, "pname", "pprice", "pcategory"))).thenReturn(product);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(post("/pro/post")
                        .content(asJsonString(product)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    private String asJsonString(Product product) {
            try{
                return new ObjectMapper().writeValueAsString(product);
            }
            catch(JsonProcessingException e){
                e.printStackTrace();
            }
            return null;
        }


    @Test
    void testGetpro() throws Exception {
        // Setup
        // Configure ProService.getproall(...).
        final List<Product> products = List.of(new Product(0, "pname", "pprice", "pcategory"));
        when(mockProductService.getproall()).thenReturn(products);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/pro/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetpro_ProServiceReturnsNoItems() throws Exception {
        // Setup
        when(mockProductService.getproall()).thenReturn(Collections.emptyList());

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/pro/all")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("[]");
    }

    @Test
    void testGetproById() throws Exception {
        // Setup
        // Configure ProService.getproById(...).
        final Product product = new Product(0, "pname", "pprice", "pcategory");
        when(mockProductService.getproById(0)).thenReturn(product);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/pro/ge/{id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testGetname() throws Exception {
        // Setup
        // Configure ProService.getproByPname(...).
        final Product product = new Product(0, "pname", "pprice", "pcategory");
        when(mockProductService.getproByPname("pname")).thenReturn(product);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/pro/{pname}", "pname")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testPutpro() throws Exception {
        // Setup
        // Configure ProService.putpro(...).
        final Product product = new Product(0, "pname", "pprice", "pcategory");
        when(mockProductService.putpro(new Product(0, "pname", "pprice", "pcategory"))).thenReturn(product);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(put("/pro/update/{id}")
                        //.content("content").contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        //assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }

    @Test
    void testDelete() throws Exception {
        // Setup
        when(mockProductService.DeleteId(0)).thenReturn("result");

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(delete("/pro/d/{Id}", 0)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
       // assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }
}
