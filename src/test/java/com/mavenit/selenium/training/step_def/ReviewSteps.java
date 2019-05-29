package com.mavenit.selenium.training.step_def;

import com.mavenit.selenium.training.pages.ResultPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Every.everyItem;

import java.util.Arrays;
import java.util.List;

public class ReviewSteps {
    private ResultPage resultPage = new ResultPage();



    @When("^I apply filter \"([^\"]*)\" on search result$")
    public void i_apply_filter_on_search_result(String filter)  {

        resultPage.linktext("GOT IT");
        resultPage.selectFilterBy(filter);


    }


    @Then("^I should see all products \"([^\"]*)\" are filtered \"([^\"]*)\"$")
    public void iShouldSeeAllProductsAreFiltered(String filter, String filterValue)  {

        if(filter.equalsIgnoreCase("review")){
            List<Double> actual = resultPage.getAllratinOnproducts();
            System.out.println(actual);
            assertThat("List is storing wrong value", actual,everyItem(greaterThanOrEqualTo(Double.parseDouble(filterValue))));
        }

        if (filterValue.equalsIgnoreCase("range")){

            List<Double> actual = resultPage.getAllProductsPrices();
            System.out.println(actual);
            List<String> rangeList = Arrays.asList(filterValue.split(" - "));

            System.out.println(rangeList);
            Double min = Double.parseDouble(rangeList.get(0));
            Double max = Double.parseDouble(rangeList.get(1));
            System.out.println(min);
            System.out.println(max);

assertThat(actual, everyItem(is(both(greaterThanOrEqualTo(min)).and(lessThanOrEqualTo(max)))) );

        }

    }

}
