package com.kelatev.imfx.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.Date;

@Root(name = "Document")
public class Document {
    @Element(name = "ID")
    private int id;
    @Element(name = "ParentID", required = false)
    private int parentId;
    @Element(name = "DocCode")
    private int docCode;
    @Element(name = "DocNumber")
    private String docNumber;
    @Element(name = "Description", required = false)
    private String description;
    @Element(name = "ModificationDate")
    private Date modificationDate;
    @Element(name = "FileName")
    private String fileName;
    @Element(name = "Comment", required = false)
    private String comment;
    @Element(name = "CRC", required = false)
    private int crc;
    @Element(name = "Protection", required = false)
    private Protection protection;


    public Document() {}
    public Document(@Element(name = "ID") int id,
                    @Element(name = "ParentID") int parentId,
                    @Element(name = "DocCode") int docCode,
                    @Element(name = "DocNumber") String docNumber,
                    @Element(name = "Description") String description,
                    @Element(name = "ModificationDate") Date modificationDate,
                    @Element(name = "FileName") String fileName,
                    @Element(name = "Comment") String comment,
                    @Element(name = "CRC") int crc,
                    @Element(name = "Protection") Protection protection) {
        this.id = id;
        this.parentId = parentId;
        this.docCode = docCode;
        this.docNumber = docNumber;
        this.description = description;
        this.modificationDate = modificationDate;
        this.fileName = fileName;
        this.comment = comment;
        this.crc = crc;
        this.protection = protection;
    }

    public int getID() {
        return id;
    }

    public void setID(int value) {
        this.id = value;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getDocCode() {
        return docCode;
    }

    public void setDocCode(int value) {
        this.docCode = value;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String value) {
        this.docNumber = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date value) {
        this.modificationDate = value;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String value) {
        this.fileName = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String value) {
        this.comment = value;
    }

    public int getCRC() {
        return crc;
    }

    public void setCRC(int value) {
        this.crc = value;
    }

    public Protection getProtection() {
        return protection;
    }

    public void setProtection(Protection value) {
        this.protection = value;
    }
}
