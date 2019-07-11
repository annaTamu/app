package app.service;

import app.model.PossibleProducts;
import app.model.Age;
import app.model.CustomerRequest;
import app.model.Income;
import app.util.AgeConverter;
import app.util.IncomeConverter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.LinkedList;
import java.util.List;

@Service

public class ProductService {

    private static final Log log = LogFactory.getLog(ProductService.class);

    @InitBinder
    public void initBinder(final WebDataBinder webdataBinder) {
        webdataBinder.registerCustomEditor(Age.class, new AgeConverter());
        webdataBinder.registerCustomEditor(Income.class, new IncomeConverter());
    }

    public List<PossibleProducts> returnProducts(CustomerRequest request)  {

       log.info("Request: {}" + request);

        List<PossibleProducts> productList = new LinkedList<>();
        if (request.getAge() != null && request.getIncome() != null) {

            if (request.getAge() == Age.SENIOR) {
                productList.add(PossibleProducts.SENIORACCOUNT);
            }

            if (request.getAge() == Age.JUNIOR) {
                productList.add(PossibleProducts.valueOf("JUNIORSAVERACCOUNT"));
            }

            if (request.getAge() == Age.MIDDLE || request.getAge() == Age.SENIOR) {
                if (request.getIncome() == Income.ZERO) {
                    productList.add(PossibleProducts.DEBITCARD);
                }

                if (request.getIncome() != Income.ZERO) {
                    productList.add(PossibleProducts.CURRENTACCOUNT);
                    productList.add(PossibleProducts.DEBITCARD);

                }
                if (request.isStudent()) {
                    productList.add(PossibleProducts.STUDENTACCOUNT);
                }
                if (request.getIncome() == Income.OVER_40000) {
                    productList.add(PossibleProducts.GOLDCREDITCARD);
                    productList.add(PossibleProducts.CURRENTACCOUNTPLUS);
                    productList.add(PossibleProducts.CURRENTACCOUNT);
                    productList.add(PossibleProducts.DEBITCARD);

                }
                if (request.getIncome() == Income.TILL_12000) {
                    productList.add(PossibleProducts.DEBITCARD);
                    productList.add(PossibleProducts.CURRENTACCOUNT);
                }
                if (request.getIncome() == Income.OVER_12000) {
                    productList.add(PossibleProducts.CURRENTACCOUNT);
                    productList.add(PossibleProducts.CREDITCARD);
                    productList.add(PossibleProducts.DEBITCARD);
                }

            }
            log.info("Result list: {}" + productList);
            return productList;
        }
        log.info("Result list: {}" + productList);
        return productList;

    }



}