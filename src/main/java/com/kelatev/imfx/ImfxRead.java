package com.kelatev.imfx;

import com.kelatev.imfx.object.Envelope;
import com.kelatev.imfx.object.DocList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ImfxRead {
    //https://www.ibm.com/developerworks/ru/library/x-javaxmlvalidapi/

    /**
     * @param xmlFile
     * @return
     * @throws JAXBException
     */
    private static Envelope parseEnvelope(InputStream xmlFile) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Envelope.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Envelope) unmarshaller.unmarshal(xmlFile);
    }

    /**
     * @param xmlFile
     * @return
     * @throws JAXBException
     */
    private static DocList parseDoclist(InputStream xmlFile) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(DocList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (DocList) unmarshaller.unmarshal(xmlFile);
    }

    /**
     * @param fis
     * @param fileName
     * @return
     * @throws IOException
     */
    public static InputStream readFile(BufferedInputStream fis, String fileName) {
        return readFile(fis, fileName, false);
    }

    /**
     * @param fis
     * @param fileName
     * @param ignoreRegist
     * @return
     */
    public static InputStream readFile(BufferedInputStream fis, String fileName, boolean ignoreRegist) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if ((entry.getName().equals(fileName) && !ignoreRegist)
                        || (entry.getName().equalsIgnoreCase(fileName) && ignoreRegist)) {
                    int count;
                    byte data[] = new byte[Constant.BUFFER];

                    while ((count = zis.read(data, 0, Constant.BUFFER)) != -1) {
                        baos.write(data, 0, count);
                    }
                }
            }
            zis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (baos.size() > 0) {
            InputStream is = new ByteArrayInputStream(baos.toByteArray());
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return is;
        } else {
            return null;
        }
    }

    /**
     * @param fis
     * @param fileName
     * @param ignoreRegist
     * @return
     */
    public static boolean hasFile(BufferedInputStream fis, String fileName, boolean ignoreRegist) {
        boolean result = false;
        try {
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                if ((entry.getName().equals(fileName) && !ignoreRegist)
                        || (entry.getName().equalsIgnoreCase(fileName) && ignoreRegist)) {
                    result = true;
                }
                zis.closeEntry();
            }
            zis.close();
        } catch (Exception e) {
        }
        return result;
    }

    /**
     * @param imfx
     * @return
     * @throws IOException
     * @throws JAXBException
     */
    public static Envelope readEnvelope(BufferedInputStream imfx) throws IOException, JAXBException {
        Envelope envelope;

        InputStream envelope_xml = readFile(imfx, Constant.ENVELOPE_FILE_NAME, true);
        envelope = parseEnvelope(envelope_xml);
        if (envelope_xml != null) {
            envelope_xml.close();
        }

        return envelope;
    }

    /**
     * @param imfx
     * @return
     * @throws IOException
     * @throws JAXBException
     */
    public static DocList readDoclist(BufferedInputStream imfx) throws IOException, JAXBException {
        return readDoclist(imfx, Constant.DOCLIST_FILE_NAME);
    }

    /**
     * @param imfx
     * @param filename
     * @return
     * @throws IOException
     * @throws JAXBException
     */
    public static DocList readDoclist(BufferedInputStream imfx, String filename) throws IOException, JAXBException {
        DocList doclist;

        if ("".equals(filename)) {
            filename = Constant.DOCLIST_FILE_NAME;
        }

        InputStream doclist_xml = readFile(imfx, filename, false);
        doclist = parseDoclist(doclist_xml);
        if (doclist_xml != null) {
            doclist_xml.close();
        }

        return doclist;
    }
}
