package com.kelatev.imfx.model;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Envelope {

    @Element(name = "MessageId")
    private String messageId;
    @Element(name = "ReplyId", required = false)
    private String replyId;
    @Element(name = "Sender")
    private String sender;
    @Element(name = "Receiver")
    private String receiver;
    @Element(name = "CreationDate")
    private Date creationDate;
    @Element(name = "Direction")
    private byte direction;
    @Element(name = "MsgType")
    private int msgType;
    @Element(name = "Comment", required = false)
    private String comment;
    @Element(name = "DocListFile")
    private DocListFile docListFile;
    @Attribute(name = "version")
    private short version;


    public Envelope(){}
    public Envelope(@Element(name = "MessageId") String messageId,
                    @Element(name = "ReplyId") String replyId,
                    @Element(name = "Sender") String sender,
                    @Element(name = "Receiver") String receiver,
                    @Element(name = "CreationDate") Date creationDate,
                    @Element(name = "Direction") byte direction,
                    @Element(name = "MsgType") int msgType,
                    @Element(name = "Comment") String comment,
                    @Element(name = "DocListFile") DocListFile docListFile,
                    @Attribute(name = "version") short version) {
        this.messageId = messageId;
        this.replyId = replyId;
        this.sender = sender;
        this.receiver = receiver;
        this.creationDate = creationDate;
        this.direction = direction;
        this.msgType = msgType;
        this.comment = comment;
        this.docListFile = docListFile;
        this.version = version;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String value) {
        this.messageId = value;
    }

    public String getReplyId() {
        return replyId;
    }

    public void setReplyId(String value) {
        this.replyId = value;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String value) {
        this.sender = value;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String value) {
        this.receiver = value;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date value) {
        this.creationDate = value;
    }

    public byte getDirection() {
        return direction;
    }

    public void setDirection(byte value) {
        this.direction = value;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int value) {
        this.msgType = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String value) {
        this.comment = value;
    }

    public DocListFile getDocListFile() {
        return docListFile;
    }

    public void setDocListFile(DocListFile value) {
        this.docListFile = value;
    }

    public Short getVersion() {
        return version;
    }

    public void setVersion(Short value) {
        this.version = value;
    }


}
