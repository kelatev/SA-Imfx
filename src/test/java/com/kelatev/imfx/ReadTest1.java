package com.kelatev.imfx;

import com.kelatev.imfx.model.DocList;
import com.kelatev.imfx.model.Envelope;
import com.kelatev.imfx.util.Constant;
import org.junit.*;

import java.io.*;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class ReadTest1 {

    @Rule
    public ResourceFile res = new ResourceFile("/PayBalance40075815.imfx");

    @Test
    public void fileExists() throws Exception
    {
        assertTrue(res.getContent().length() > 0);
        assertTrue(res.getFile().exists());
    }

    @Test
    public void readFile() throws Exception {
        ImfxRead imfx = new ImfxRead(new FileInputStream(res.getFile()));

        assertNull(imfx.readFile("envelope.xml"));
        assertNotNull(imfx.readFile("Envelope.xml", true));
        assertNotNull(imfx.readFile("doclist.xml"));
        assertNotNull(imfx.readFile("DocList.xml", true));
        assertNull(imfx.readFile("doclist123.xml"));

        assertNotNull(imfx.readFile("doclist.xml.p7s"));
        assertNotNull(imfx.readFile("Doc1.xml"));
        assertNotNull(imfx.readFile("Doc1.xml", true));

    }

    @Test
    public void readEnvelope() throws Exception {
        ImfxRead imfx = new ImfxRead(new FileInputStream(res.getFile()));
        final SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.dateFormat);

        Envelope envelope = imfx.readEnvelope();

        assertNotNull(envelope);
        assertEquals(envelope.getMessageId(), "1E1FED44-87FC-4463-900F-EE9A0F7A85AB");
        assertEquals(envelope.getCreationDate(), dateFormat.parse("20160512T110404"));
        assertEquals(envelope.getDirection(), 1);
        assertEquals(envelope.getSender(), "tyatechka@Gmail.com");
        assertEquals(envelope.getReceiver(), "A141.TEST");
    }

    @Test
    public void readDoclist() throws Exception {
        ImfxRead imfx = new ImfxRead(new FileInputStream(res.getFile()));
        final SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.dateFormat);

        DocList docList = imfx.readDoclist();

        assertNotNull(docList);
        assertEquals(docList.getCreationDate(), dateFormat.parse("20160512T110404"));
        assertEquals(docList.getSenderCode(), "0040075815");
        assertEquals(docList.getSenderName(), new String("ПАТ \"Українська залізниця\"".getBytes(), "UTF-8"));
        assertEquals(docList.getDocument().get(0).getDocCode(), 71);
        assertEquals(docList.getDocument().get(0).getDocNumber(), "807.40075815");
    }

}