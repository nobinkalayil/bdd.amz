package com.mavenit.selenium.training;

import com.mavenit.selenium.training.driver.DriverManager;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Test;

public class Hooks {
    private DriverManager drivermanager = new DriverManager();
    private String url = System.getProperty("url");


    @Before
    public void setup(){
        drivermanager.openBrowser();

        drivermanager.navigate(url);
        drivermanager.maximisebrowser();
        drivermanager.applyImplicitWait();
        drivermanager.handleAppCookies();
    }
   // @After
    public void teardown(){
        drivermanager.closebrowser();
    }

}
