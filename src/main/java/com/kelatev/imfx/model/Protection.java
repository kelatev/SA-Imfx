package com.kelatev.imfx.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Protection {

    @Element(name = "MethodID")
    private int methodID;
    @Element(name = "SelfSigned", required = false)
    private byte selfSigned;
    @Element(name = "SignFileName")
    private String signFileName;


    public Protection(){}

    public int getMethodID() {
        return methodID;
    }

    public void setMethodID(int value) {
        this.methodID = value;
    }

    public byte getSelfSigned() {
        return selfSigned;
    }

    public void setSelfSigned(byte value) {
        this.selfSigned = value;
    }

    public String getSignFileName() {
        return signFileName;
    }

    public void setSignFileName(String value) {
        this.signFileName = value;
    }

}
