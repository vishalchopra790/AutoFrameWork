package org.VishalIndustries.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractComponent {

    WebElement sectionElement;
    WebDriver driver;

    public AbstractComponent(WebDriver driver, By sectionElement) {
        this.driver=driver;
        this.sectionElement = driver.findElement(sectionElement);
    }

    public WebElement findElement(By findElementBy) {
        return sectionElement.findElement(findElementBy);
    }
    public List<WebElement> findElements(By findElementBy) {
        return sectionElement.findElements(findElementBy);
    }

    public void waitForInvisibilty(By findBy){

        WebDriverWait wait =new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
    }

}
