package com.mavenit.selenium.training.step_def;

import com.mavenit.selenium.training.pages.HeaderPage;
import com.mavenit.selenium.training.pages.ResultPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.CoreMatchers.*;


public class SearchSteps {
    private HeaderPage headerPage = new HeaderPage();

    private ResultPage resultPage = new ResultPage();



    @Given("^I am on homepage$")
    @Test
    public void i_am_on_homepage()  {
        String actual = headerPage.getCurrentUrl();
        assertThat(actual, is(endsWith("co.uk/")));

    }

    @When("^I search for a product \"([^\"]*)\"$")
    public void i_search_for_a_product(String item)  {
headerPage.doSearch(item);
    }

    @Then("^I should be able to see respective results$")
    public void i_should_be_able_to_see_respective_results() {
        String actual = resultPage.getProductHeader();
        assertThat(actual, is(equalToIgnoringCase(HeaderPage.searchItem)) );

    }

}
