package app.controller;

import app.model.PossibleProducts;
import app.model.Age;
import app.model.CustomerRequest;
import app.model.Income;
import app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class ProductsController {


    @Autowired
    private ProductService productService;


    @GetMapping("/customer/getPossibleProducts")
    public ResponseEntity<List<PossibleProducts>> getPossibleProducts(
        @RequestParam("age") String age,
        @RequestParam("student") boolean student,
        @RequestParam("income") String income) {
        CustomerRequest request = new CustomerRequest(Age.fromValue(age), Income.fromValue(income), student);

        List<PossibleProducts> products = productService.returnProducts(request);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @GetMapping("/customer/home")
    public ModelAndView passParametersWithModelAndView() {
        ModelAndView modelAndView = new ModelAndView("home");
        List<Age> age = new ArrayList<Age>(Arrays.asList(Age.values()));
        modelAndView.addObject("customerAge", Arrays.asList(Age.values()));
        modelAndView.addObject("customerIncome", Arrays.asList(Income.values()));
        return modelAndView;
    }


    @GetMapping("/customer/getCustomerIncome")
    ResponseEntity<List<Income>> getCustomerIncome(){

        List<Income> customerIncome= Arrays.asList(Income.class.getEnumConstants());
        return new ResponseEntity <List<Income>> (customerIncome, HttpStatus.OK);

    }


}
