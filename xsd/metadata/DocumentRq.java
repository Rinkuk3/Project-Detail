//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.10 at 06:26:48 PM EDT 
//


package com.td.mbna.msec.midtier.disclosure.xsd.metadata;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="DocumentTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Party">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PartyTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Agreement">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="AgreementTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="AgreementFeature">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="AgreementFeatureTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="AgreementFeatureMetric">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="AgreementFeatureMetricCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                 &lt;element name="AgreementFeatureMetricAmt" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                                               &lt;/sequence>
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
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
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="", propOrder = {
    "documentTypeCd",
    "party"
})
@XmlRootElement(name = "DocumentRq")
public class DocumentRq {

    @XmlElement(name = "DocumentTypeCd", required = true)
    protected String documentTypeCd;
    @XmlElement(name = "Party", required = true)
    protected Party party;

    /**
     * Gets the value of the documentTypeCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentTypeCd() {
        return documentTypeCd;
    }

    /**
     * Sets the value of the documentTypeCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentTypeCd(String value) {
        this.documentTypeCd = value;
    }

    /**
     * Gets the value of the party property.
     * 
     * @return
     *     possible object is
     *     {@link Party }
     *     
     */
    public Party getParty() {
        return party;
    }

    /**
     * Sets the value of the party property.
     * 
     * @param value
     *     allowed object is
     *     {@link Party }
     *     
     */
    public void setParty(Party value) {
        this.party = value;
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
     *         &lt;element name="PartyTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Agreement">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="AgreementTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="AgreementFeature">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="AgreementFeatureTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="AgreementFeatureMetric">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="AgreementFeatureMetricCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                       &lt;element name="AgreementFeatureMetricAmt" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                                     &lt;/sequence>
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
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
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "partyTypeCd",
        "agreement"
    })
    public static class Party {

        @XmlElement(name = "PartyTypeCd", required = true)
        protected String partyTypeCd;
        @XmlElement(name = "Agreement", required = true)
        protected Agreement agreement;

        /**
         * Gets the value of the partyTypeCd property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPartyTypeCd() {
            return partyTypeCd;
        }

        /**
         * Sets the value of the partyTypeCd property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPartyTypeCd(String value) {
            this.partyTypeCd = value;
        }

        /**
         * Gets the value of the agreement property.
         * 
         * @return
         *     possible object is
         *     {@link Agreement }
         *     
         */
        public Agreement getAgreement() {
            return agreement;
        }

        /**
         * Sets the value of the agreement property.
         * 
         * @param value
         *     allowed object is
         *     {@link Agreement }
         *     
         */
        public void setAgreement(Agreement value) {
            this.agreement = value;
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
         *         &lt;element name="AgreementTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="AgreementFeature">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="AgreementFeatureTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="AgreementFeatureMetric">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="AgreementFeatureMetricCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                             &lt;element name="AgreementFeatureMetricAmt" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "agreementTypeCd",
            "agreementFeature"
        })
        public static class Agreement {

            @XmlElement(name = "AgreementTypeCd", required = true)
            protected String agreementTypeCd;
            @XmlElement(name = "AgreementFeature", required = true)
            protected AgreementFeature agreementFeature;

            /**
             * Gets the value of the agreementTypeCd property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getAgreementTypeCd() {
                return agreementTypeCd;
            }

            /**
             * Sets the value of the agreementTypeCd property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setAgreementTypeCd(String value) {
                this.agreementTypeCd = value;
            }

            /**
             * Gets the value of the agreementFeature property.
             * 
             * @return
             *     possible object is
             *     {@link AgreementFeature }
             *     
             */
            public AgreementFeature getAgreementFeature() {
                return agreementFeature;
            }

            /**
             * Sets the value of the agreementFeature property.
             * 
             * @param value
             *     allowed object is
             *     {@link AgreementFeature }
             *     
             */
            public void setAgreementFeature(AgreementFeature value) {
                this.agreementFeature = value;
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
             *         &lt;element name="AgreementFeatureTypeCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="AgreementFeatureMetric">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="AgreementFeatureMetricCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                   &lt;element name="AgreementFeatureMetricAmt" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
                "agreementFeatureTypeCd",
                "agreementFeatureMetric"
            })
            public static class AgreementFeature {

                @XmlElement(name = "AgreementFeatureTypeCd", required = true)
                protected String agreementFeatureTypeCd;
                @XmlElement(name = "AgreementFeatureMetric", required = true)
                protected AgreementFeatureMetric agreementFeatureMetric;

                /**
                 * Gets the value of the agreementFeatureTypeCd property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getAgreementFeatureTypeCd() {
                    return agreementFeatureTypeCd;
                }

                /**
                 * Sets the value of the agreementFeatureTypeCd property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setAgreementFeatureTypeCd(String value) {
                    this.agreementFeatureTypeCd = value;
                }

                /**
                 * Gets the value of the agreementFeatureMetric property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link AgreementFeatureMetric }
                 *     
                 */
                public AgreementFeatureMetric getAgreementFeatureMetric() {
                    return agreementFeatureMetric;
                }

                /**
                 * Sets the value of the agreementFeatureMetric property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link AgreementFeatureMetric }
                 *     
                 */
                public void setAgreementFeatureMetric(AgreementFeatureMetric value) {
                    this.agreementFeatureMetric = value;
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
                 *         &lt;element name="AgreementFeatureMetricCd" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *         &lt;element name="AgreementFeatureMetricAmt" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
                    "agreementFeatureMetricCd",
                    "agreementFeatureMetricAmt"
                })
                public static class AgreementFeatureMetric {

                    @XmlElement(name = "AgreementFeatureMetricCd", required = true)
                    protected String agreementFeatureMetricCd;
                    @XmlElement(name = "AgreementFeatureMetricAmt")
                    protected float agreementFeatureMetricAmt;

                    /**
                     * Gets the value of the agreementFeatureMetricCd property.
                     * 
                     * @return
                     *     possible object is
                     *     {@link String }
                     *     
                     */
                    public String getAgreementFeatureMetricCd() {
                        return agreementFeatureMetricCd;
                    }

                    /**
                     * Sets the value of the agreementFeatureMetricCd property.
                     * 
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *     
                     */
                    public void setAgreementFeatureMetricCd(String value) {
                        this.agreementFeatureMetricCd = value;
                    }

                    /**
                     * Gets the value of the agreementFeatureMetricAmt property.
                     * 
                     */
                    public float getAgreementFeatureMetricAmt() {
                        return agreementFeatureMetricAmt;
                    }

                    /**
                     * Sets the value of the agreementFeatureMetricAmt property.
                     * 
                     */
                    public void setAgreementFeatureMetricAmt(float value) {
                        this.agreementFeatureMetricAmt = value;
                    }

                }

            }

        }

    }

}
