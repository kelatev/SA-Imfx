
package com.kelatev.imfx.doclist;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="SenderCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SenderName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CreationDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Document">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                   &lt;element name="DocCode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *                   &lt;element name="DocNumber" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *                   &lt;element name="ModificationDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="CRC" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "senderCode",
    "senderName",
    "creationDate",
    "document"
})
@XmlRootElement(name = "DocList")
public class DocList {

    @XmlElement(name = "SenderCode")
    protected int senderCode;
    @XmlElement(name = "SenderName", required = true)
    protected String senderName;
    @XmlElement(name = "CreationDate", required = true)
    protected String creationDate;
    @XmlElement(name = "Document", required = true)
    protected DocList.Document document;
    @XmlAttribute(name = "version")
    protected Byte version;

    /**
     * Gets the value of the senderCode property.
     * 
     */
    public int getSenderCode() {
        return senderCode;
    }

    /**
     * Sets the value of the senderCode property.
     * 
     */
    public void setSenderCode(int value) {
        this.senderCode = value;
    }

    /**
     * Gets the value of the senderName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * Sets the value of the senderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderName(String value) {
        this.senderName = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDate(String value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link DocList.Document }
     *     
     */
    public DocList.Document getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocList.Document }
     *     
     */
    public void setDocument(DocList.Document value) {
        this.document = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setVersion(Byte value) {
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
     *         &lt;element name="ID" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *         &lt;element name="DocCode" type="{http://www.w3.org/2001/XMLSchema}byte"/>
     *         &lt;element name="DocNumber" type="{http://www.w3.org/2001/XMLSchema}short"/>
     *         &lt;element name="ModificationDate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="FileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Comment" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="CRC" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
        "id",
        "docCode",
        "docNumber",
        "modificationDate",
        "fileName",
        "comment",
        "crc",
        "protection"
    })
    public static class Document {

        @XmlElement(name = "ID")
        protected byte id;
        @XmlElement(name = "DocCode")
        protected byte docCode;
        @XmlElement(name = "DocNumber")
        protected short docNumber;
        @XmlElement(name = "ModificationDate", required = true)
        protected String modificationDate;
        @XmlElement(name = "FileName", required = true)
        protected String fileName;
        @XmlElement(name = "Comment", required = true)
        protected String comment;
        @XmlElement(name = "CRC")
        protected int crc;
        @XmlElement(name = "Protection", required = true)
        protected DocList.Document.Protection protection;

        /**
         * Gets the value of the id property.
         * 
         */
        public byte getID() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         */
        public void setID(byte value) {
            this.id = value;
        }

        /**
         * Gets the value of the docCode property.
         * 
         */
        public byte getDocCode() {
            return docCode;
        }

        /**
         * Sets the value of the docCode property.
         * 
         */
        public void setDocCode(byte value) {
            this.docCode = value;
        }

        /**
         * Gets the value of the docNumber property.
         * 
         */
        public short getDocNumber() {
            return docNumber;
        }

        /**
         * Sets the value of the docNumber property.
         * 
         */
        public void setDocNumber(short value) {
            this.docNumber = value;
        }

        /**
         * Gets the value of the modificationDate property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getModificationDate() {
            return modificationDate;
        }

        /**
         * Sets the value of the modificationDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setModificationDate(String value) {
            this.modificationDate = value;
        }

        /**
         * Gets the value of the fileName property.
         * 
         * @return
         *     possible object is
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
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFileName(String value) {
            this.fileName = value;
        }

        /**
         * Gets the value of the comment property.
         * 
         * @return
         *     possible object is
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
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setComment(String value) {
            this.comment = value;
        }

        /**
         * Gets the value of the crc property.
         * 
         */
        public int getCRC() {
            return crc;
        }

        /**
         * Sets the value of the crc property.
         * 
         */
        public void setCRC(int value) {
            this.crc = value;
        }

        /**
         * Gets the value of the protection property.
         * 
         * @return
         *     possible object is
         *     {@link DocList.Document.Protection }
         *     
         */
        public DocList.Document.Protection getProtection() {
            return protection;
        }

        /**
         * Sets the value of the protection property.
         * 
         * @param value
         *     allowed object is
         *     {@link DocList.Document.Protection }
         *     
         */
        public void setProtection(DocList.Document.Protection value) {
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
            protected byte methodID;
            @XmlElement(name = "SelfSigned")
            protected byte selfSigned;
            @XmlElement(name = "SignFileName", required = true)
            protected String signFileName;

            /**
             * Gets the value of the methodID property.
             * 
             */
            public byte getMethodID() {
                return methodID;
            }

            /**
             * Sets the value of the methodID property.
             * 
             */
            public void setMethodID(byte value) {
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
             *     possible object is
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
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSignFileName(String value) {
                this.signFileName = value;
            }

        }

    }

}
