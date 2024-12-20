package com.td.api.mbalert.request.addalertevent;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Template {

    private String typeCd;
    private List<TemplateItem> templateItem = new ArrayList<TemplateItem>();

}
