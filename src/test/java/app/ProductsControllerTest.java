package app;


import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import app.controller.ProductsController;
import app.model.Age;
import app.model.CustomerRequest;
import app.model.Income;
import app.model.PossibleProducts;
import app.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductsController.class)
public class ProductsControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService service;

    @Test
    public void getPossibleProducts() throws Exception {


        CustomerRequest request = new CustomerRequest(Age.fromValue("18-64"), Income.fromValue("1-12000"), true);

        List<PossibleProducts> products = new LinkedList<>();
          products.add(PossibleProducts.CURRENTACCOUNT);
          products.add(PossibleProducts.STUDENTACCOUNT);
          products.add(PossibleProducts.GOLDCREDITCARD);
          products.add(PossibleProducts.CURRENTACCOUNT);


        when(service.returnProducts(request)).thenReturn(products);

        mvc.perform(get("/customer/getPossibleProducts?age=18-64&student=true&income=1-12000")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

    }

@Test
    public void badRequest() throws Exception {


        CustomerRequest request = new CustomerRequest(Age.fromValue("18-64"), Income.fromValue("1-12000"), true);

        List<PossibleProducts> products = new LinkedList<>();
        products.add(PossibleProducts.CURRENTACCOUNT);
        products.add(PossibleProducts.STUDENTACCOUNT);
        products.add(PossibleProducts.GOLDCREDITCARD);
        products.add(PossibleProducts.CURRENTACCOUNT);

        given(service.returnProducts(request)).willReturn(products);
        when(service.returnProducts(request)).thenReturn(products);

        mvc.perform(get("/customer/getPossibleProducts?age=18-64&student=true")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

}