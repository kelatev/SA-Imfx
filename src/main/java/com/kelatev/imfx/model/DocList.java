package com.kelatev.imfx.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.Date;
import java.util.List;

@Root
public class DocList {

    @Element(name = "SenderCode")
    private String senderCode;
    @Element(name = "SenderName")
    private String senderName;
    @Element(name = "SenderProgName", required = false)
    private String senderProgName;
    @Element(name = "SenderProgVer", required = false)
    private String senderProgVer;
    @Element(name = "CreationDate")
    private Date creationDate;
    @ElementList(inline=true)
    private List<Document> document;
    @Attribute(name = "version")
    private Byte version;


    public DocList(){}

    public String getSenderCode() {
        return senderCode;
    }

    public void setSenderCode(String value) {
        this.senderCode = value;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String value) {
        this.senderName = value;
    }

    public String getSenderProgName() {
        return senderProgName;
    }

    public void setSenderProgName(String senderProgName) {
        this.senderProgName = senderProgName;
    }

    public String getSenderProgVer() {
        return senderProgVer;
    }

    public void setSenderProgVer(String senderProgVer) {
        this.senderProgVer = senderProgVer;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date value) {
        this.creationDate = value;
    }

    public List<Document> getDocument() {
        return document;
    }

    public void setDocument(List<Document> value) {
        this.document = value;
    }

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte value) {
        this.version = value;
    }

}
