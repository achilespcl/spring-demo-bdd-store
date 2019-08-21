package com.pb.achilespcl.bddstore.bdd.stepDefs;

import com.pb.achilespcl.bddstore.bdd.testController.SpringStepDefs;
import com.pb.achilespcl.bddstore.model.Product;
import com.pb.achilespcl.bddstore.service.ProductService;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.web.server.LocalServerPort;

import javax.persistence.EntityNotFoundException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class DeleteProductSteps extends SpringStepDefs{

    @Autowired
    private ProductService productService;

    @LocalServerPort
    private int port;

    private Product myProduct;

    @Before
    public void setup() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Given("I have a product in my store with an id {int}")
    public void i_have_a_product_in_my_store_with_an_id(Integer productId) {
        myProduct = productService.getProductById(Long.valueOf(productId));
        assertNotNull(myProduct.getId());
    }

    @When("I make a delete request to my api sending the product id")
    public void i_make_a_delete_request_to_my_api_sending_the_product_id() {
        given().when().delete("/products/{id}", myProduct.getId()).then().statusCode(200).body(equalTo("Product was removed successfully!"));
    }

    @Then("My product was removed from my store")
    public void my_product_was_removed_from_my_store() {
        try{
            productService.getProductById(Long.valueOf(myProduct.getId()));
            fail();
        } catch (EntityNotFoundException enf) {
            //if this exception was catched so the test is passed
        }
    }
}
