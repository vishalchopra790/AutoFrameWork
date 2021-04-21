package org.VishalIndustries;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest {

WebDriver driver;
    public WebDriver initBrowser(String broswser){

        if(broswser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            return driver;
        }
        return null;
    }
    public List<HashMap<String, String>> getData(String fileLocation) throws IOException {


        //conver json file to json String
        String json=  FileUtils.readFileToString(new File(fileLocation), StandardCharsets.UTF_8);
        ObjectMapper ob=new ObjectMapper();
        List<HashMap<String, String>> data=ob.readValue(json, new TypeReference<List < HashMap < String, String > >>() {});

        return data;
    }
}
