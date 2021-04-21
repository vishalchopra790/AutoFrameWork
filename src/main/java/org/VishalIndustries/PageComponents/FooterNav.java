package org.VishalIndustries.PageComponents;

import org.VishalIndustries.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends AbstractComponent {
    WebDriver driver;
    By flights = By.cssSelector("div [title='Flights'] span");
    By links = By.cssSelector("a");


    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public void clickonFlights() {
        System.out.println(findElement(flights).getAttribute("class"));
        //findElement(flights).click();
    }

    public int getLinksCount(){
        return findElements(links).size();
    }
}
