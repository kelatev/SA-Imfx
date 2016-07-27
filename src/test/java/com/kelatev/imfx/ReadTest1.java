package com.kelatev.imfx;

import com.kelatev.imfx.helper.Constant;
import com.kelatev.imfx.helper.DateAdapter;
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
        BufferedInputStream imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        //imfx = new BufferedInputStream(new FileInputStream(res.getFile()));

        assertNull(ImfxRead.readFile(imfx, "envelope.xml"));
        assertNotNull(ImfxRead.readFile(imfx, "Envelope.xml", true));
        assertNotNull(ImfxRead.readFile(imfx, "doclist.xml"));
        assertNotNull(ImfxRead.readFile(imfx, "DocList.xml", true));
        assertNull(ImfxRead.readFile(imfx, "doclist123.xml"));

        assertNotNull(ImfxRead.readFile(imfx, "doclist.xml.p7s"));
        assertNotNull(ImfxRead.readFile(imfx, "Doc1.xml"));
        assertNotNull(ImfxRead.readFile(imfx, "Doc1.xml", true));

        imfx.close();
    }

    @Test
    public void readEnvelope() throws Exception {
        BufferedInputStream imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        final SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.dateFormat);

        assertNotNull(ImfxRead.readEnvelope(imfx));
        assertEquals(ImfxRead.readEnvelope(imfx).getMessageId(), "1E1FED44-87FC-4463-900F-EE9A0F7A85AB");
        assertEquals(ImfxRead.readEnvelope(imfx).getCreationDate(), dateFormat.parse("20160512T110404"));
        assertEquals(ImfxRead.readEnvelope(imfx).getDirection(), 1);
        assertEquals(ImfxRead.readEnvelope(imfx).getSender(), "tyatechka@Gmail.com");
        assertEquals(ImfxRead.readEnvelope(imfx).getReceiver(), "A141.TEST");
    }

    @Test
    public void readDoclist() throws Exception {
        BufferedInputStream imfx = new BufferedInputStream(new FileInputStream(res.getFile()));
        final SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.dateFormat);

        assertNotNull(ImfxRead.readDoclist(imfx));
        assertEquals(ImfxRead.readDoclist(imfx).getCreationDate(), dateFormat.parse("20160512T110404"));
        assertEquals(ImfxRead.readDoclist(imfx).getSenderCode(), "0040075815");
        assertEquals(ImfxRead.readDoclist(imfx).getSenderName(), new String("ПАТ \"Українська залізниця\"".getBytes(), "UTF-8"));
        assertEquals(ImfxRead.readDoclist(imfx).getDocument().get(0).getDocCode(), 71);
        assertEquals(ImfxRead.readDoclist(imfx).getDocument().get(0).getDocNumber(), "807.40075815");
    }

}