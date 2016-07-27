package com.kelatev.imfx;

import com.kelatev.imfx.object.DocList;
import com.kelatev.imfx.object.Envelope;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Write {


    /**
     * @param imfx
     * @param fileStream
     * @param fileName
     * @return
     */
    public OutputStream writeFile(OutputStream imfx, OutputStream fileStream, String fileName) throws IOException {
        return writeFile(imfx, fileStream, fileName, null);
    }

    /**
     * @param imfx
     * @param fileStream
     * @param fileName
     * @param sign
     * @return
     */
    public OutputStream writeFile(OutputStream imfx, OutputStream fileStream, String fileName, InputStream sign) throws IOException {
        ZipOutputStream zout = new ZipOutputStream(imfx);

        ZipEntry ze = new ZipEntry(fileName);
        zout.putNextEntry(ze);
        //отправка данных в поток zout
        zout.closeEntry();

        zout.close();
        return null;
    }


    /**
     * @param imfx
     * @param docList
     * @return
     */
    public OutputStream addDoclist(OutputStream imfx, DocList docList) {
        return addDoclist(imfx, docList);
    }

    /**
     * @param imfx
     * @param docList
     * @param sign
     * @return
     */
    public OutputStream addDoclist(OutputStream imfx, DocList docList, InputStream sign) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();



        OutputStream fileStream = baos;// = new ByteArrayInputStream(baos.toByteArray());
        return writeFile(imfx, fileStream, Constant.DOCLIST_FILE_NAME, sign);
    }


    /**
     * @param imfx
     * @param envelope
     * @return
     */
    public OutputStream addEnvelope(OutputStream imfx, Envelope envelope) {
        return addEnvelope(imfx, envelope);
    }

    /**
     * @param imfx
     * @param envelope
     * @param sign
     * @return
     */
    public OutputStream addEnvelope(OutputStream imfx, Envelope envelope, InputStream sign) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();



        OutputStream fileStream = baos;//new ByteArrayInputStream(baos.toByteArray());
        return writeFile(imfx, fileStream, Constant.ENVELOPE_FILE_NAME, sign);
    }

}
