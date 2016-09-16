package com.kelatev.imfx;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class WriteTest1 {

    @Test
    public void writeFileByte() throws Exception {
        byte[] test_file = new BigInteger("1111000011110001", 2).toByteArray();
        String test_name = "doc1.xml";

        ImfxWriteByte write = new ImfxWriteByte();
        write.writeFile(test_file, test_name);

        byte[] outFile = write.finish();

        assertNotNull(outFile);

        //ImfxRead read = new ImfxRead(outFile);
        //byte[] readFile = read.readFileByte(test_name);

        //assertEquals(test_file, readFile);
    }

    @Test
    public void addDoclistByte() throws Exception {

    }

    @Test
    public void addEnvelopeByte() throws Exception {

    }

}