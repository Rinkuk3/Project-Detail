package com.td.api.mbalert.request.addalertevent;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class AltrExtension_TemplateItem {

    private List<TemplateItem> template = new ArrayList<TemplateItem>();

}
