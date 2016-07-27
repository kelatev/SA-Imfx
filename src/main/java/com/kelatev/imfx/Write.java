package com.kelatev.imfx;

import com.kelatev.imfx.object.DocList;
import com.kelatev.imfx.object.Envelope;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Write {


    /**
     * @param imfx
     * @param fileStream
     * @param fileName
     * @return
     */
    public InputStream writeFile(InputStream imfx, InputStream fileStream, String fileName) {
        return writeFile(imfx, fileStream, fileName, null);
    }
    public InputStream writeFile(InputStream imfx, InputStream fileStream, String fileName, InputStream sign) {
        return null;
    }


    /**
     * @param imfx
     * @param docList
     * @return
     */
    public InputStream addDoclist(InputStream imfx, DocList docList) {
        return addDoclist(imfx, docList);
    }
    public InputStream addDoclist(InputStream imfx, DocList docList, InputStream sign) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();



        InputStream fileStream = new ByteArrayInputStream(baos.toByteArray());
        return writeFile(imfx, fileStream, Constant.DOCLIST_FILE_NAME, sign);
    }


    /**
     * @param imfx
     * @param envelope
     * @return
     */
    public InputStream addEnvelope(InputStream imfx, Envelope envelope) {
        return addEnvelope(imfx, envelope);
    }
    public InputStream addEnvelope(InputStream imfx, Envelope envelope, InputStream sign) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();



        InputStream fileStream = new ByteArrayInputStream(baos.toByteArray());
        return writeFile(imfx, fileStream, Constant.ENVELOPE_FILE_NAME, sign);
    }

}
