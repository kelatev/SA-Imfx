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
        assertNotNull(Read.readEnvelope(imfx).getMessageId());
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readEnvelope(imfx).getCreationDate());
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readEnvelope(imfx).getDirection());
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readEnvelope(imfx).getSender());
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readEnvelope(imfx).getReceiver());
    }

    @Test
    public void readDoclist() throws Exception {
        BufferedInputStream imfx = new BufferedInputStream(new FileInputStream(res.getFile()));

        assertNotNull(Read.readDoclist(imfx));
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readDoclist(imfx).getDocument().get(0).getDocCode());
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readDoclist(imfx).getCreationDate());
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readDoclist(imfx).getSenderCode());
        imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        assertNotNull(Read.readDoclist(imfx).getSenderName());
    }

}