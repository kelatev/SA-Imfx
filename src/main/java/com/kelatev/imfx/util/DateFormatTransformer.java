package com.kelatev.imfx.util;

import org.simpleframework.xml.transform.Transform;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTransformer implements Transform<Date> {

    private DateFormat dateFormat = new SimpleDateFormat(Constant.dateFormat);

    public Date read(String value) throws Exception {
        return dateFormat.parse(value);
    }

    public String write(Date value) throws Exception {
        return dateFormat.format(value);
    }

}
