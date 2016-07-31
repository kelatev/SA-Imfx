package com.kelatev.imfx;

import com.kelatev.imfx.util.Constant;
import com.kelatev.imfx.model.DocList;
import com.kelatev.imfx.model.Envelope;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.print.Doc;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ImfxWrite {

    public static ZipOutputStream zip(FileOutputStream imfx) {
        return new ZipOutputStream(imfx);
    }
    /**
     * @param imfx
     * @param fileStream
     * @param fileName
     * @return
     */
    public void writeFile(ZipOutputStream imfx, OutputStream fileStream, String fileName) throws IOException {
        writeFile(imfx, fileStream, fileName, null);
    }

    /**
     * @param imfx
     * @param fileStream
     * @param fileName
     * @param sign
     * @return
     */
    public void writeFile(ZipOutputStream imfx, OutputStream fileStream, String fileName, InputStream sign) throws IOException {
        ZipEntry ze = new ZipEntry(fileName);
        imfx.putNextEntry(ze);

        ByteArrayOutputStream baos = (ByteArrayOutputStream)fileStream;
        byte[] arr = baos.toByteArray();
        baos.close();
        imfx.write(arr, 0, arr.length);

        imfx.closeEntry();
    }

    public void finish(ZipOutputStream imfx) throws IOException {
        //zout.finish();
        imfx.close();
    }


    /**
     * @param imfx
     * @param docList
     * @return
     */
    public void addDoclist(ZipOutputStream imfx, DocList docList) {
        addDoclist(imfx, docList);
    }

    /**
     * @param imfx
     * @param docList
     * @param sign
     * @return
     */
    public void addDoclist(ZipOutputStream imfx, DocList docList, InputStream sign) throws IOException, SAXException, JAXBException {
        OutputStream fileStream = null;

        JAXBContext jaxbContext = JAXBContext.newInstance(DocList.class);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File("doclist.xsd"));

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setSchema(schema);
        marshaller.marshal(docList, fileStream);

        writeFile(imfx, fileStream, Constant.DOCLIST_FILE_NAME, sign);
    }


    /**
     * @param imfx
     * @param envelope
     * @return
     */
    public void addEnvelope(ZipOutputStream imfx, Envelope envelope) {
        addEnvelope(imfx, envelope);
    }

    /**
     * @param imfx
     * @param envelope
     * @param sign
     * @return
     */
    public void addEnvelope(ZipOutputStream imfx, Envelope envelope, InputStream sign) throws IOException, SAXException, JAXBException {
        OutputStream fileStream = null;

        JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File("envelope.xsd"));

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setSchema(schema);
        marshaller.marshal(envelope, fileStream);

        writeFile(imfx, fileStream, Constant.ENVELOPE_FILE_NAME, sign);
    }

}
