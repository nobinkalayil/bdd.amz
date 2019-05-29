package com.mavenit.selenium.training.pages;

import com.mavenit.selenium.training.driver.DriverManager;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends DriverManager {
    @FindBy(css = ".ProductCard__removeButton__2O6Cw")
    private WebElement removeBasketProduct;

    @FindBy(css = ".co_marginright_12")
    private WebElement getbuttonText;

    @FindBy(css = "a[data-e2e='product-name']")
    private List<WebElement> productsInBasket;

   // @FindBy(css = ".ProductCard__titleLink__1PgaZ")
 //   private WebElement getbasketproductname;


    public void removeProduct() {
        removeBasketProduct.click();

    }

    public String getRemoveText() {
        String getRText = getbuttonText.getText();
        return getRText;
    }


   /* public String getproductName() {
        String getproductText = getbasketproductname.getText();
        System.out.println("this is product test name" + getproductText);
        return getproductText;

    }*/

    public List<String> getProductsInBaskets(){
        List<String> productNamesInBasket= new ArrayList<>();

        for (WebElement productInBasket: productsInBasket){
            productNamesInBasket.add(productInBasket.getText());
        }
        return productNamesInBasket;
    }
}







