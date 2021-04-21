package org.VishalIndustries.PageComponents;

import org.VishalIndustries.AbstractComponents.AbstractComponent;
import org.VishalIndustries.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {

    private By multiAlert = By.id("MultiCityModelAlert");
    private By multiRD = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By from2 = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By to2 = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");

    private By cd = By.id("ctl00_mainContent_chk_IndArm");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String,String> reservationDetails) throws InterruptedException {
        makStateReady(s->findElement(from).click());

        selectOrigin(reservationDetails.get("origin"));
        findElement(to).click();
        selectDestination(reservationDetails.get("destination"));
        findElement(from2).click();
        selectOrigin2(reservationDetails.get("origin1"));
        findElement(to2).click();
        Thread.sleep(3000);
        selectDestination2(reservationDetails.get("destination2"));
        findElement(cd).click();
        findElement(search).click();
        System.out.println("I'm done");
    }

    public void selectOrigin(String origin) {
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void selectDestination(String destination) {
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
    }

    public void selectOrigin2(String Origin2) {
        findElement(By.xpath("(//a[@value='" + Origin2 + "'])[3]")).click();
    }

    public void selectDestination2(String destination2) {
        findElement(By.xpath("(//a[@value='"+ destination2 +"'])[4]")).click();
    }


    public void makStateReady(Consumer<MultiTrip> consumer){
        System.out.println("I'm in multi trip");
        findElement(multiRD).click();
        findElement(multiAlert).click();
        waitForInvisibilty(multiAlert);
        consumer.accept(this);
        System.out.println("I'm done bro");
    }
}
