package org.VishalIndustries;

import org.VishalIndustries.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SRPTest extends BaseTest {
    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setup() {
        driver = initBrowser("chrome");
        travelHomePage = new TravelHomePage(driver);
    }


    @Test(dataProvider = "getData")
    public void FlightTest(HashMap<String, String> reservationDetails) throws InterruptedException {

        travelHomePage.goTo();
        travelHomePage.getFooterNavBar().clickonFlights();
        travelHomePage.getNavigationBar().clickonFlights();
        int i = travelHomePage.getFooterNavBar().getLinksCount();
        //Assert.assertEquals(12,i);
        travelHomePage.searchStrategdy("multitrip");

        travelHomePage.checkAvail(reservationDetails);


    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> li=getData("src/test/java/org/VishalIndustries/Dataloads/reservation.json");
        return new Object[][]{
                {li.get(0)}, {li.get(1)}};
    }
}
