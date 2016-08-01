package com.kelatev.imfx;

import com.kelatev.imfx.util.Constant;
import com.kelatev.imfx.model.Envelope;
import com.kelatev.imfx.model.DocList;

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

/**
 * The type Imfx read.
 */
public class ImfxRead {
    //https://www.ibm.com/developerworks/ru/library/x-javaxmlvalidapi/


    private static Envelope parseEnvelope(InputStream xmlFile) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Envelope.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Envelope) unmarshaller.unmarshal(xmlFile);
    }

    private static DocList parseDoclist(InputStream xmlFile) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(DocList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (DocList) unmarshaller.unmarshal(xmlFile);
    }

    /**
     * Read file input stream.
     *
     * @param fis      the fis
     * @param fileName the file name
     * @return input stream
     * @throws IOException the io exception
     */
    public static InputStream readFile(BufferedInputStream fis, String fileName) throws IOException {
        return readFile(fis, fileName, false);
    }

    /**
     * Read file input stream.
     *
     * @param imfx         the imfx
     * @param fileName     the file name
     * @param ignoreRegist the ignore regist
     * @return input stream
     * @throws IOException the io exception
     */
    public static InputStream readFile(BufferedInputStream imfx, String fileName, boolean ignoreRegist) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        imfx.mark(0);
        try {
            ZipInputStream zis = new ZipInputStream(imfx);
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
            //zis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        imfx.reset();

        if (baos.size() > 0) {
            InputStream is = new ByteArrayInputStream(baos.toByteArray());
            baos.close();
            return is;
        } else {
            return null;
        }
    }

    /**
     * Has file boolean.
     *
     * @param fis          the fis
     * @param fileName     the file name
     * @param ignoreRegist the ignore regist
     * @return boolean
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
     * Read envelope envelope.
     *
     * @param imfx the imfx
     * @return envelope
     * @throws IOException   the io exception
     * @throws JAXBException the jaxb exception
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
     * Read doclist doc list.
     *
     * @param imfx the imfx
     * @return doc list
     * @throws IOException   the io exception
     * @throws JAXBException the jaxb exception
     */
    public static DocList readDoclist(BufferedInputStream imfx) throws IOException, JAXBException {
        return readDoclist(imfx, Constant.DOCLIST_FILE_NAME);
    }

    /**
     * Read doclist doc list.
     *
     * @param imfx     the imfx
     * @param filename the filename
     * @return doc list
     * @throws IOException   the io exception
     * @throws JAXBException the jaxb exception
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
