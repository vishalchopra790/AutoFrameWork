package org.VishalIndustries.Dataloads;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public List<HashMap<String, String>> getData(String fileLocation) throws IOException {


        //conver json file to json String
      String json=  FileUtils.readFileToString(new File("reservation.json"), StandardCharsets.UTF_8);
        ObjectMapper ob=new ObjectMapper();
        List<HashMap<String, String>> data=ob.readValue(json, new TypeReference<List < HashMap < String, String > >>() {});

return data;
    }
}
