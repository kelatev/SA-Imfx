package com.kelatev.imfx;

import com.google.common.io.ByteStreams;
import com.kelatev.imfx.util.Constant;
import com.kelatev.imfx.model.Envelope;
import com.kelatev.imfx.model.DocList;
import com.kelatev.imfx.util.DateFormatTransformer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ImfxRead {
    //https://www.ibm.com/developerworks/ru/library/x-javaxmlvalidapi/

    private static Map<String, InputStream> files = new HashMap<String, InputStream>();

    public ImfxRead(InputStream imfx) throws IOException {
        readFiles(new BufferedInputStream(imfx));
    }

    public ImfxRead(BufferedInputStream imfx) throws IOException {
        readFiles(imfx);
    }

    public ImfxRead(byte[] imfx) throws IOException {
        readFiles(new BufferedInputStream(new ByteArrayInputStream(imfx)));
    }

    private void readFiles(BufferedInputStream imfx) throws IOException {
        ByteArrayOutputStream baos = null;
        ZipInputStream zis = null;

        try {
            zis = new ZipInputStream(imfx);
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                baos = new ByteArrayOutputStream();

                int count;
                byte data[] = new byte[Constant.BUFFER];

                while ((count = zis.read(data, 0, Constant.BUFFER)) != -1) {
                    baos.write(data, 0, count);
                }
                InputStream is = new ByteArrayInputStream(baos.toByteArray());
                baos.close();

                files.put(entry.getName(), is);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (zis != null)
                zis.close();
            if (baos != null)
                baos.close();
        }
    }

    private static Envelope parseEnvelope(InputStream xmlFile) throws Exception {
        RegistryMatcher matcher = new RegistryMatcher();
        matcher.bind(Date.class, new DateFormatTransformer());
        Serializer serializer = new Persister(matcher);

        return serializer.read(Envelope.class, xmlFile);
    }

    private static DocList parseDoclist(InputStream xmlFile) throws Exception {
        RegistryMatcher matcher = new RegistryMatcher();
        matcher.bind(Date.class, new DateFormatTransformer());

        Serializer serializer = new Persister(matcher);
        return serializer.read(DocList.class, xmlFile);
    }

    public boolean hasFile(String fileName, boolean ignoreRegist) {
        for (Map.Entry<String, InputStream> file : files.entrySet()) {
            if ((file.getKey().equals(fileName) && !ignoreRegist)
                    || (file.getKey().equalsIgnoreCase(fileName) && ignoreRegist)) {
                return true;
            }
        }

        return false;
    }

    public InputStream readFile(String fileName) {
        return readFile(fileName, false);
    }

    public InputStream readFile(String fileName, boolean ignoreRegist) {
        for (Map.Entry<String, InputStream> file : files.entrySet()) {
            if ((file.getKey().equals(fileName) && !ignoreRegist)
                    || (file.getKey().equalsIgnoreCase(fileName) && ignoreRegist)) {
                return file.getValue();
            }
        }

        return null;
    }

    public byte[] readFileByte(String fileName) throws IOException {
        return readFileByte(fileName, false);
    }

    public byte[] readFileByte(String fileName, boolean ignoreRegist) throws IOException {
        for (Map.Entry<String, InputStream> file : files.entrySet()) {
            if ((file.getKey().equals(fileName) && !ignoreRegist)
                    || (file.getKey().equalsIgnoreCase(fileName) && ignoreRegist)) {
                return ByteStreams.toByteArray(file.getValue());
            }
        }

        return null;
    }

    public Envelope readEnvelope() throws Exception {
        return parseEnvelope(readFile(Constant.ENVELOPE_FILE_NAME, true));
    }

    public DocList readDoclist() throws Exception {
        return readDoclist(Constant.DOCLIST_FILE_NAME);
    }

    public DocList readDoclist(String filename) throws Exception {
        if ("".equals(filename)) {
            filename = Constant.DOCLIST_FILE_NAME;
        }

        return parseDoclist(readFile(filename, false));
    }
}
