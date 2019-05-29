package com.mavenit.selenium.training.pages;

import com.mavenit.selenium.training.driver.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ResultPage extends DriverManager {
    @FindBy(css = ".search-title__term")

    private WebElement headerText;

    @FindBy(css = ".ac-product-card__name")
    private List<WebElement> productNames;

    @FindBy(xpath = "//div[@class='xs-8--none']//button[contains(@class,'add-to-trolley-button button button--primary button--full')]")
    private WebElement addToTrolly;

    @FindBy(css = ".button.button--full.xs-hidden.sm-block")
    private WebElement clickbutton;


    @FindBy(css =".ac-facet__label" )
    private List<WebElement> filterBy;

    @FindBy(css = ".ac-product-price__amount")
    private List<WebElement> priceOnproduct;


    @FindBy(css = ".ac-star-rating")
    private List<WebElement> reviewImageOnProducts;




  public void linktext(String gotit) {
  driver.findElement(By.linkText(gotit)).click();
  sleep(3000);
  }


    public static String selectedProduct;

    public String getProductHeader() {
        return headerText.getText();
    }

    public void selectAnyProduct() {
        int totalProducts = productNames.size();

        Random random = new Random();
        int randomNumber = random.nextInt(totalProducts);
        WebElement selectedWebElement = productNames.get(randomNumber);
        selectedProduct = selectedWebElement.getText();
        System.out.println(selectedProduct);
        selectedWebElement.click();
    }

    public void addTrollytoBasket() {


        addToTrolly.click();
    }

    public void trollyButton() {
        clickbutton.click();
    }

    //left panel select

    public void selectFilterBy(String filterChoice){

        for (WebElement filterElement : filterBy){
            if(filterElement.getText().equalsIgnoreCase(filterChoice)){
                waitUntilElementClickable(filterElement).click();
                break;
            }

        }
         waitUntilElementInvisible(By.cssSelector(".icon--loading"));
    }


//Price review


    public List<Double> getAllProductsPrices() {
        List<Double> collectedPricelist = new ArrayList<>();

        for (WebElement filterWebelements : priceOnproduct) {

            double indivprice = Double.parseDouble(filterWebelements.getText().replace("£", ""));
            System.out.println(indivprice);
            collectedPricelist.add(indivprice);
        }
        return collectedPricelist;
    }

   //Star Review

    public List<Double>getAllratinOnproducts(){
        List<Double>  collectedRatingList = new ArrayList<>();

        for (WebElement filterWebelements : reviewImageOnProducts){
            String ratingValueInString = filterWebelements.getAttribute("data-star-rating");
            double ratingValueinDouble = Double.parseDouble(ratingValueInString);
            collectedRatingList.add(ratingValueinDouble);

        }
        return collectedRatingList;
    }




}



