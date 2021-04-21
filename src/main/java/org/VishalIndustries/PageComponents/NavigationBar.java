package org.VishalIndustries.PageComponents;

import org.VishalIndustries.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent {
    By flights = By.cssSelector("[title='Flights']");
    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public void clickonFlights() {
        System.out.println(findElement(flights).getAttribute("class"));
        //findElement(flights).click();
        System.out.println("Jai Guru Ji");
    }
}
