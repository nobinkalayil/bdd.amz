package com.mavenit.selenium.training.step_def;

import com.mavenit.selenium.training.pages.BasketPage;
import com.mavenit.selenium.training.pages.ResultPage;
import cucumber.api.java.en.Then;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RemoveSteps extends ResultPage {

    private BasketPage basketPage = new BasketPage();



    @Then("^I removed product from the basket$")
    public void i_removed_product_from_the_basket()  {
        basketPage.removeProduct();
        String actual = selectedProduct;
        String expected = basketPage.getRemoveText();

        assertThat(actual, anything(expected));
        System.out.println(actual);
        System.out.println(expected);


    }
}
