package com.it_academy.testng.steps;

import com.it_academy.testng.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class TestSteps {
    private HomePage homePage = new HomePage();

    @Given("the user opens Onliner website")
    public void theUserOpensOnlinerWebsite() {
        homePage.openOnlinerWebsite();
    }

    @When("the user navigate on the section {string}")
    public void theUserNavigateOnTheSection(String section) {
        homePage.navigateTo(section);
    }

    @Then("a drop-down menu appeared")
    public void aDropDownMenuAppeared() {
        assertThat(homePage.isDropDownMenuIsDisplayed())
                .as("Drop-down menu is not displayed")
                .isTrue();
    }

    @Then("categories are displayed")
    public void categoriesAreDisplayed() {
        assertThat(homePage.isElementsFromDropDownDisplayed())
                .as("Drop-down menu is not  filled in")
                .doesNotContainNull()
                .isNotEmpty();
    }
}
