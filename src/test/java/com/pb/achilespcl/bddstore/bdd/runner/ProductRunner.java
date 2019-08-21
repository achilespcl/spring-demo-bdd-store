package com.pb.achilespcl.bddstore.bdd.runner;

import com.pb.achilespcl.bddstore.bdd.testController.SpringStepDefs;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.pb.achilespcl.bddstore.bdd.stepDefs",
        features = "classpath:feature/delete_product.feature",
        plugin = {"pretty", "html:target/cucumber-reports"})
public class ProductRunner extends SpringStepDefs {
}
