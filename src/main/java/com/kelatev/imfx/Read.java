package com.kelatev.imfx;

import com.kelatev.imfx.envelope.Envelope;
import com.kelatev.imfx.doclist.DocList;

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

public class Read {
    //https://www.ibm.com/developerworks/ru/library/x-javaxmlvalidapi/

    private Envelope parseEnvelope(InputStream xmlFile) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Envelope.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Envelope) unmarshaller.unmarshal(xmlFile);
    }

    private DocList parseDoclist(InputStream xmlFile) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(DocList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (DocList) unmarshaller.unmarshal(xmlFile);
    }

    public static InputStream readFile(BufferedInputStream fis, String fileName, boolean ignoreRegist) throws IOException {
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
                zis.closeEntry();
            }
            zis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        InputStream is = new ByteArrayInputStream(baos.toByteArray());

        //baos.flush();
        baos.close();
        return is;
    }

    /**
     * Check file to exists from Stream.
     *
     * @return
     *     possible object is
     *     {@link boolean }
     *
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

    public Envelope readEnvelope(BufferedInputStream imfx) throws IOException, JAXBException {
        Envelope envelope;

        InputStream envelope_xml = readFile(imfx, Constant.ENVELOPE_FILE_NAME, true);
        envelope = parseEnvelope(envelope_xml);
        if (envelope_xml != null) {
            envelope_xml.close();
        }

        return envelope;
    }

    public DocList readDoclist(BufferedInputStream imfx, String filename) throws IOException, JAXBException {
        DocList doclist;

        if (filename.equals("")) {
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
