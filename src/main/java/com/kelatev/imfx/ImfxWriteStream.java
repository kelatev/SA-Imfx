package com.kelatev.imfx;

import com.kelatev.imfx.util.Constant;
import com.kelatev.imfx.model.DocList;
import com.kelatev.imfx.model.Envelope;
import com.kelatev.imfx.util.DateFormatTransformer;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
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

    public void addDoclist(DocList docList, OutputStream sign) throws Exception {
        OutputStream fileStream = null;

        RegistryMatcher matcher = new RegistryMatcher();
        matcher.bind(Date.class, new DateFormatTransformer());
        Serializer serializer = new Persister(matcher);

        serializer.write(docList, fileStream);

        writeFile(fileStream, Constant.DOCLIST_FILE_NAME, sign);
    }

    public void addEnvelope(Envelope envelope) {
        addEnvelope(envelope);
    }

    public void addEnvelope(Envelope envelope, OutputStream sign) throws Exception {
        OutputStream fileStream = null;

        RegistryMatcher matcher = new RegistryMatcher();
        matcher.bind(Date.class, new DateFormatTransformer());
        Serializer serializer = new Persister(matcher);

        serializer.write(envelope, fileStream);

        writeFile(fileStream, Constant.ENVELOPE_FILE_NAME, sign);
    }

}
