package com.pb.achilespcl.bddstore.bdd.stepDefs;

import com.pb.achilespcl.bddstore.bdd.testController.SpringStepDefs;
import com.pb.achilespcl.bddstore.model.Product;
import com.pb.achilespcl.bddstore.service.ProductService;
import com.pb.achilespcl.bddstore.web.rest.request.ProductRequest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GetProductSteps {

    @Autowired
    private ProductService productService;

    @LocalServerPort
    private int port;

    private Product myProduct, getProduct;

    @Before
    public void setup() {
        RestAssured.port = port;
        RestAssured.baseURI = "http://localhost";
    }

    @Given("I have a product in my store with a valid id")
    public void i_have_a_product_in_my_store_with_id() {
        myProduct = productService.createProduct(new ProductRequest("Notebook Dell", "Core i7, 8GB RAM, 256 SSD", 2367.50));
        assertNotNull(myProduct.getId());
    }

    @When("I make a request to my api sending the product id")
    public void i_search_the_product_id() {
        getProduct = given().when().get("/products/{id}", myProduct.getId()).then().statusCode(200).extract().as(Product.class);
    }

    @Then("I get the respective product")
    public void i_get_the_respective_product() {
        assertEquals(getProduct.getId(), myProduct.getId());
    }
}
