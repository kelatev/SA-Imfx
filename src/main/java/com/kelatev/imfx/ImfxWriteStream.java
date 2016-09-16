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
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ImfxWriteStream {

    private static ZipOutputStream imfx;

    public ImfxWriteStream(FileOutputStream imfx1) {
        imfx = new ZipOutputStream(imfx1);
    }

    public void writeFile(OutputStream fileStream, String fileName) throws IOException {
        writeFile(fileStream, fileName, null);
    }

    public void writeFile(OutputStream fileStream, String fileName, OutputStream sign) throws IOException {
        ZipEntry ze = new ZipEntry(fileName);
        imfx.putNextEntry(ze);

        ByteArrayOutputStream baos = (ByteArrayOutputStream)fileStream;
        byte[] arr = baos.toByteArray();
        imfx.write(arr, 0, arr.length);
        baos.close();

        imfx.closeEntry();
    }

    public void finish() throws IOException {
        //zout.finish();
        imfx.close();
    }

    public void addDoclist(DocList docList) {
        addDoclist(docList);
    }

    public void addDoclist(DocList docList, OutputStream sign) throws IOException, SAXException, JAXBException {
        OutputStream fileStream = null;

        JAXBContext jaxbContext = JAXBContext.newInstance(DocList.class);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File("doclist.xsd"));

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setSchema(schema);
        marshaller.marshal(docList, fileStream);

        writeFile(fileStream, Constant.DOCLIST_FILE_NAME, sign);
    }

    public void addEnvelope(Envelope envelope) {
        addEnvelope(envelope);
    }

    public void addEnvelope(Envelope envelope, OutputStream sign) throws IOException, SAXException, JAXBException {
        OutputStream fileStream = null;

        JAXBContext jaxbContext = JAXBContext.newInstance(Envelope.class);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new File("envelope.xsd"));

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setSchema(schema);
        marshaller.marshal(envelope, fileStream);

        writeFile(fileStream, Constant.ENVELOPE_FILE_NAME, sign);
    }

}
