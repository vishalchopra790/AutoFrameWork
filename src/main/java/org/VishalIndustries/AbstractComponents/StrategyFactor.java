package org.VishalIndustries.AbstractComponents;

import org.VishalIndustries.PageComponents.MultiTrip;
import org.VishalIndustries.PageComponents.SingleTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactor {

    WebDriver driver;
    By section = By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFlightAvail SelectStrategy(String StrategyType) {
        if (StrategyType.equalsIgnoreCase("multitrip")) {
            return new MultiTrip(driver, section);
        }
        if (StrategyType.equalsIgnoreCase("single")) {
            return new SingleTrip(driver, section);
        }
        return null;
    }


}
