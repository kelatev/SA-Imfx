package com.kelatev.imfx;

import com.kelatev.imfx.model.DocList;
import com.kelatev.imfx.model.Envelope;
import com.kelatev.imfx.util.Constant;
import com.kelatev.imfx.util.DateFormatTransformer;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ImfxWriteByte {

    private ByteArrayOutputStream imfx_baos;
    private ZipOutputStream imfx_zos;

    public ImfxWriteByte() throws IOException {
        imfx_baos = new ByteArrayOutputStream();
        imfx_zos = new ZipOutputStream(imfx_baos);
    }

    public void writeFile(byte[] fileStream, String fileName) throws IOException {
        writeFile(fileStream, fileName, null);
    }

    public void writeFile(byte[] fileStream, String fileName, byte[] sign) throws IOException {
        if (fileStream != null) {
            ZipEntry ze = new ZipEntry(fileName);
            imfx_zos.putNextEntry(ze);
            imfx_zos.write(fileStream, 0, fileStream.length);
            imfx_zos.closeEntry();
        }
    }

    public byte[] finish() {
        return imfx_baos.toByteArray();
    }

    public void addDoclist(DocList docList) {
        addDoclist(docList);
    }

    public void addDoclist(DocList docList, byte[] sign) throws Exception {
        OutputStream fileStream = new ByteArrayOutputStream();

        RegistryMatcher matcher = new RegistryMatcher();
        matcher.bind(Date.class, new DateFormatTransformer());
        Serializer serializer = new Persister(matcher);

        serializer.write(docList, fileStream);

        ByteArrayOutputStream baos = (ByteArrayOutputStream) fileStream;

        writeFile(baos.toByteArray(), Constant.DOCLIST_FILE_NAME, sign);
    }

    public void addEnvelope(Envelope envelope) {
        addEnvelope(envelope);
    }

    public void addEnvelope(Envelope envelope, byte[] sign) throws Exception {
        OutputStream fileStream = new ByteArrayOutputStream();

        RegistryMatcher matcher = new RegistryMatcher();
        matcher.bind(Date.class, new DateFormatTransformer());
        Serializer serializer = new Persister(matcher);

        serializer.write(envelope, fileStream);

        ByteArrayOutputStream baos = (ByteArrayOutputStream) fileStream;

        writeFile(baos.toByteArray(), Constant.ENVELOPE_FILE_NAME, sign);
    }
}
