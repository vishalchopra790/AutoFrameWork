package org.VishalIndustries.AbstractComponents;

import java.util.HashMap;

public interface SearchFlightAvail {

    void checkAvail(HashMap<String,String> reservationDetails) throws InterruptedException;
}
