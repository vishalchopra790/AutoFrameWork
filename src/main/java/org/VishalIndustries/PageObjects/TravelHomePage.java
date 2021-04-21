package org.VishalIndustries.PageObjects;

import org.VishalIndustries.AbstractComponents.SearchFlightAvail;
import org.VishalIndustries.AbstractComponents.StrategyFactor;
import org.VishalIndustries.PageComponents.FooterNav;
import org.VishalIndustries.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    By sectionElement = By.id("traveller-home");
    By headerSectionElement = By.id("buttons");
    SearchFlightAvail searchFlightAvail;
    WebDriver driver;

    public TravelHomePage(WebDriver driver) {
        this.driver=driver;
    }

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
    }
    public NavigationBar getNavigationBar() {

        return new NavigationBar(driver, headerSectionElement);
    }

    public FooterNav getFooterNavBar() {

        return new FooterNav(driver, sectionElement);
    }
    public void searchStrategdy(String  strategy){
        StrategyFactor strategyFactor=new StrategyFactor(driver);
        searchFlightAvail= strategyFactor.SelectStrategy(strategy);
        this.searchFlightAvail=searchFlightAvail;
    }
    public void checkAvail(HashMap<String,String> reservationDetails) throws InterruptedException {
        searchFlightAvail.checkAvail( reservationDetails);
    }
}
