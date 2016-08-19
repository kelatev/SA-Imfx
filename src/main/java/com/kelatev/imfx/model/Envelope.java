
package com.kelatev.imfx.model;

import com.kelatev.imfx.adpter.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MessageId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReplyId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Sender" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Receiver" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CreationDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Direction" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="MsgType" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DocListFile">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Protection">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="MethodID" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="SelfSigned" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                             &lt;element name="SignFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "messageId",
    "replyId",
    "sender",
    "receiver",
    "creationDate",
    "direction",
    "msgType",
    "comment",
    "docListFile"
})
@XmlRootElement(name = "Envelope")
public class Envelope {

    @XmlElement(name = "MessageId", required = true)
    protected String messageId;
    @XmlElement(name = "ReplyId", required = true)
    protected String replyId;
    @XmlElement(name = "Sender", required = true)
    protected String sender;
    @XmlElement(name = "Receiver", required = true)
    protected String receiver;
    @XmlElement(name = "CreationDate", required = true)
    @XmlJavaTypeAdapter(DateAdapter.class)
    protected Date creationDate;
    @XmlElement(name = "Direction")
    protected byte direction;
    @XmlElement(name = "MsgType")
    protected int msgType;
    @XmlElement(name = "Comment", required = true)
    protected String comment;
    @XmlElement(name = "DocListFile", required = true)
    protected Envelope.DocListFile docListFile;
    @XmlAttribute(name = "version")
    protected Short version;

    /**
     * Gets the value of the messageId property.
     * 
     * @return
     *     possible model is
     *     {@link String }
     *     
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the value of the messageId property.
     * 
     * @param value
     *     allowed model is
     *     {@link String }
     *     
     */
    public void setMessageId(String value) {
        this.messageId = value;
    }

    /**
     * Gets the value of the replyId property.
     * 
     * @return
     *     possible model is
     *     {@link String }
     *     
     */
    public String getReplyId() {
        return replyId;
    }

    /**
     * Sets the value of the replyId property.
     * 
     * @param value
     *     allowed model is
     *     {@link String }
     *     
     */
    public void setReplyId(String value) {
        this.replyId = value;
    }

    /**
     * Gets the value of the sender property.
     * 
     * @return
     *     possible model is
     *     {@link String }
     *     
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     * @param value
     *     allowed model is
     *     {@link String }
     *     
     */
    public void setSender(String value) {
        this.sender = value;
    }

    /**
     * Gets the value of the receiver property.
     * 
     * @return
     *     possible model is
     *     {@link String }
     *     
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * Sets the value of the receiver property.
     * 
     * @param value
     *     allowed model is
     *     {@link String }
     *     
     */
    public void setReceiver(String value) {
        this.receiver = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible model is
     *     {@link String }
     *     
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed model is
     *     {@link String }
     *     
     */
    public void setCreationDate(Date value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the direction property.
     * 
     */
    public byte getDirection() {
        return direction;
    }

    /**
     * Sets the value of the direction property.
     * 
     */
    public void setDirection(byte value) {
        this.direction = value;
    }

    /**
     * Gets the value of the msgType property.
     * 
     */
    public int getMsgType() {
        return msgType;
    }

    /**
     * Sets the value of the msgType property.
     * 
     */
    public void setMsgType(int value) {
        this.msgType = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible model is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed model is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

    /**
     * Gets the value of the docListFile property.
     * 
     * @return
     *     possible model is
     *     {@link Envelope.DocListFile }
     *     
     */
    public Envelope.DocListFile getDocListFile() {
        return docListFile;
    }

    /**
     * Sets the value of the docListFile property.
     * 
     * @param value
     *     allowed model is
     *     {@link Envelope.DocListFile }
     *     
     */
    public void setDocListFile(Envelope.DocListFile value) {
        this.docListFile = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible model is
     *     {@link Short }
     *     
     */
    public Short getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed model is
     *     {@link Short }
     *     
     */
    public void setVersion(Short value) {
        this.version = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Protection">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="MethodID" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="SelfSigned" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *                   &lt;element name="SignFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "fileName",
        "protection"
    })
    public static class DocListFile {

        @XmlElement(name = "FileName", required = true)
        protected String fileName;
        @XmlElement(name = "Protection", required = true)
        protected Envelope.DocListFile.Protection protection;

        /**
         * Gets the value of the fileName property.
         * 
         * @return
         *     possible model is
         *     {@link String }
         *     
         */
        public String getFileName() {
            return fileName;
        }

        /**
         * Sets the value of the fileName property.
         * 
         * @param value
         *     allowed model is
         *     {@link String }
         *     
         */
        public void setFileName(String value) {
            this.fileName = value;
        }

        /**
         * Gets the value of the protection property.
         * 
         * @return
         *     possible model is
         *     {@link Envelope.DocListFile.Protection }
         *     
         */
        public Envelope.DocListFile.Protection getProtection() {
            return protection;
        }

        /**
         * Sets the value of the protection property.
         * 
         * @param value
         *     allowed model is
         *     {@link Envelope.DocListFile.Protection }
         *     
         */
        public void setProtection(Envelope.DocListFile.Protection value) {
            this.protection = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="MethodID" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="SelfSigned" type="{http://www.w3.org/2001/XMLSchema}byte"/>
         *         &lt;element name="SignFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "methodID",
            "selfSigned",
            "signFileName"
        })
        public static class Protection {

            @XmlElement(name = "MethodID")
            protected int methodID;
            @XmlElement(name = "SelfSigned")
            protected byte selfSigned;
            @XmlElement(name = "SignFileName", required = true)
            protected String signFileName;

            /**
             * Gets the value of the methodID property.
             * 
             */
            public int getMethodID() {
                return methodID;
            }

            /**
             * Sets the value of the methodID property.
             * 
             */
            public void setMethodID(int value) {
                this.methodID = value;
            }

            /**
             * Gets the value of the selfSigned property.
             * 
             */
            public byte getSelfSigned() {
                return selfSigned;
            }

            /**
             * Sets the value of the selfSigned property.
             * 
             */
            public void setSelfSigned(byte value) {
                this.selfSigned = value;
            }

            /**
             * Gets the value of the signFileName property.
             * 
             * @return
             *     possible model is
             *     {@link String }
             *     
             */
            public String getSignFileName() {
                return signFileName;
            }

            /**
             * Sets the value of the signFileName property.
             * 
             * @param value
             *     allowed model is
             *     {@link String }
             *     
             */
            public void setSignFileName(String value) {
                this.signFileName = value;
            }

        }

    }

}
