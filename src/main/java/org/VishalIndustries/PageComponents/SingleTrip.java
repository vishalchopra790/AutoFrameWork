package org.VishalIndustries.PageComponents;

import org.VishalIndustries.AbstractComponents.AbstractComponent;
import org.VishalIndustries.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class SingleTrip extends AbstractComponent implements SearchFlightAvail {

    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By cd = By.id("ctl00_mainContent_chk_IndArm");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");

    public SingleTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String,String> reservationDetails) {
        findElement(from).click();
        selectOrigin(reservationDetails.get("origin"));
        findElement(to).click();
        selectDestination(reservationDetails.get("destination"));

        findElement(cd).click();
        findElement(search).click();

    }
    public void selectOrigin(String origin){
        findElement(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void selectDestination(String destination){
        findElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }
}
