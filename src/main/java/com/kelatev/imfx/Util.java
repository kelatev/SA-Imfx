package com.kelatev.imfx;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.zip.CRC32;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Util {

    public static String date2String(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.dateFormat);
        return sdf.format(date);
    }

    public static Date string2Date(String string) {
        SimpleDateFormat sdf = new SimpleDateFormat(Constant.dateFormat);
        try
        {
            Date date = sdf.parse(string);
            return date;
        }
        catch (ParseException ex)
        {
            return null;
        }
    }

    public long getCRC32(InputStream inStream) {
        long r = 0;
        try {
            byte[] bytes = getBytes(inStream);
            CRC32 crc = new CRC32();

            crc.reset();
            crc.update(bytes);

            r = crc.getValue();
        } catch(Exception e) {

        }

        return r;
    }

    public static byte[] getBytes(InputStream is) throws IOException {

        int len;
        int size = 1024;
        byte[] buf;

        if (is instanceof ByteArrayInputStream) {
            size = is.available();
            buf = new byte[size];
            len = is.read(buf, 0, size);
        } else {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            buf = new byte[size];
            while ((len = is.read(buf, 0, size)) != -1)
                bos.write(buf, 0, len);
            buf = bos.toByteArray();
        }
        return buf;
    }
}
