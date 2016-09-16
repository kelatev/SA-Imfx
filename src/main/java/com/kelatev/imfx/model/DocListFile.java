package com.kelatev.imfx.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class DocListFile {

    @Element(name = "FileName")
    private String fileName;
    @Element(name = "Protection")
    private Protection protection;


    public DocListFile(){}
    public DocListFile(@Element(name = "FileName") String fileName,
                       @Element(name = "Protection") Protection protection) {
        this.fileName = fileName;
        this.protection = protection;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String value) {
        this.fileName = value;
    }

    public Protection getProtection() {
        return protection;
    }

    public void setProtection(Protection value) {
        this.protection = value;
    }

}
