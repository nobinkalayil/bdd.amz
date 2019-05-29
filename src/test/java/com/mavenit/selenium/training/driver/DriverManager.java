package com.mavenit.selenium.training.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;
    private String browser =  System.getProperty("instance");
    public DriverManager(){ PageFactory.initElements(driver, this);
    }

    public void openBrowser(){
        switch (browser){
            case "ie":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

                default:
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
        }


    }

    public void maximisebrowser(){driver.manage().window().maximize();}

    public void navigate(String url){driver.get(url);
    }


    public void handleAppCookies(){driver.findElement(By.linkText("GOT IT"));}

    public void closebrowser(){driver.quit();}
    public void sleep(int milli) {
        try {
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void applyImplicitWait(){driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);}

    public WebElement waitUntilElementClickable(WebElement element){
        return new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(element));

    }
    public Boolean waitUntilElementInvisible(By by){
        return new WebDriverWait(driver,15).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

}
