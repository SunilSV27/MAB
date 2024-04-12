package com.gtm.uaf.steps;

import com.gtm.uaf.helper.ScenarioContext;
import com.gtm.uaf.helper.Context;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {
    ScenarioContext scenarioContext = new ScenarioContext();
    @Given("User is on the login page")
    public void userIsOnLoginPage() {
        System.out.println("User is on the login page");
    }
    @When("User enters {string}")
    public void userEntersUsernameAndPassword(String username) {
        scenarioContext.setContext(Context.ID, username);
        System.out.println("User enters username: " + username);
    }
    @Then("User should be logged in successfully")
    public void userLoggedInSuccessfully() {
        String enteredUsername = scenarioContext.getContext(Context.ID).toString();
        System.out.println("User logged in successfully with username: " + enteredUsername);
    }
}