package com.kelatev.imfx;

import com.kelatev.imfx.doclist.DocList;
import com.kelatev.imfx.envelope.Envelope;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class Write {


    private InputStream writeFile(InputStream imfx, InputStream fileStream, String fileName) {
        return writeFile(imfx, fileStream, fileName, null);
    }
    private InputStream writeFile(InputStream imfx, InputStream fileStream, String fileName, InputStream sign) {
        return null;
    }


    private InputStream addDoclist(InputStream imfx, DocList docList) {
        return addDoclist(imfx, docList);
    }
    private InputStream addDoclist(InputStream imfx, DocList docList, InputStream sign) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();



        InputStream fileStream = new ByteArrayInputStream(baos.toByteArray());
        return writeFile(imfx, fileStream, Constant.DOCLIST_FILE_NAME, sign);
    }


    private InputStream addEnvelope(InputStream imfx, Envelope envelope) {
        return addEnvelope(imfx, envelope);
    }
    private InputStream addEnvelope(InputStream imfx, Envelope envelope, InputStream sign) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();



        InputStream fileStream = new ByteArrayInputStream(baos.toByteArray());
        return writeFile(imfx, fileStream, Constant.ENVELOPE_FILE_NAME, sign);
    }

}
