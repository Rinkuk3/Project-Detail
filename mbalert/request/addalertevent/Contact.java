package com.td.api.mbalert.request.addalertevent;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Contact {

    private List<Locator> locator = new ArrayList<Locator>();

}
