package com.td.api.mbalert.request.addalertevent;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Condition {

    private List<Identifier> identifier = new ArrayList<Identifier>();

}
