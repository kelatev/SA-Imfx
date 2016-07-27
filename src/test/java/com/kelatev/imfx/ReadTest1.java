package com.kelatev.imfx;

import org.junit.*;
import org.junit.rules.ExternalResource;

import java.io.*;

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
        BufferedInputStream imfx = new BufferedInputStream(new FileInputStream(res.getFile()));

        assertNull(Read.readFile(imfx, "envelope.xml"));
        //imfx.reset();
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readFile(imfx, "Envelope.xml", true));
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readFile(imfx, "doclist.xml"));
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readFile(imfx, "DocList.xml", true));
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNull(Read.readFile(imfx, "doclist123.xml"));

        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readFile(imfx, "doclist.xml.p7s"));
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readFile(imfx, "Doc1.xml"));
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readFile(imfx, "Doc1.xml", true));

        imfx.close();
    }

    @Test
    public void readEnvelope() throws Exception {
        BufferedInputStream imfx = new BufferedInputStream(new FileInputStream(res.getFile()));

        assertNotNull(Read.readEnvelope(imfx));
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertEquals(Read.readEnvelope(imfx).getMessageId(), "1E1FED44-87FC-4463-900F-EE9A0F7A85AB");
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertEquals(Read.readEnvelope(imfx).getCreationDate(), "20160512T110404");
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertEquals(Read.readEnvelope(imfx).getDirection(), 1);
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertEquals(Read.readEnvelope(imfx).getSender(), "tyatechka@Gmail.com");
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertEquals(Read.readEnvelope(imfx).getReceiver(), "A141.TEST");
    }

    @Test
    public void readDoclist() throws Exception {
        BufferedInputStream imfx = new BufferedInputStream(new FileInputStream(res.getFile()));

        assertNotNull(Read.readDoclist(imfx));
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertEquals(Read.readDoclist(imfx).getCreationDate(), "20160512T110404");
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertEquals(Read.readDoclist(imfx).getSenderCode(), "0040075815");
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertEquals(Read.readDoclist(imfx).getSenderName(), "ПАТ \"Українська залізниця\"");
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertEquals(Read.readDoclist(imfx).getDocument().get(0).getDocCode(), 71);
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertEquals(Read.readDoclist(imfx).getDocument().get(0).getDocNumber(), "807.40075815");
    }

}