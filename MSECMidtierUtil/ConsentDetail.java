package com.td.mbna.msec.midtier.util;

import com.td.mbna.msec.midtier.configuration.beans.ConsentDocBaseDetail;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * No need to go through the WSDL > CodeGen ... cycle because:
 * (1) OSC CusomterAgreement Web Service is near EOL. The next change will be completely changing to use the OSCCE Consent Event REST API.
 *     Therefore, no 'Standardization", "Interoperability", "Documentation", or "Maintainability" issue.
 * (2) No need to parse the entire consent search result.
 * (3) This significantly simplifies the parsing; therefore, more reliable.
 *     This works as long as the document/disclosure type and consent-captured time are there are remain in their current format.
 * (4) This code will be used for about a year. Then, all Web Service calls will be replaced with REST API calls.
 */
public class ConsentDetail {
        public static List<ConsentDocBaseDetail> getDetailsOfDisclosureDocuments(String customerAgreementXmlResponse) {
        List<ConsentDocBaseDetail> docBaseDetails = new ArrayList<>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new InputSource(new StringReader(customerAgreementXmlResponse)));

            doc.getDocumentElement().normalize();

            NodeList parentList = doc.getElementsByTagName("c:CustomerAgreement");

            if (parentList.getLength() > 0) {

                for (int i = 0; i < parentList.getLength(); i++) {
                    Element agreementElement = (Element) parentList.item(i);
                    NodeList docBaseList = agreementElement.getElementsByTagName("c:DocumentBase");
                    Element docBaseElement = (Element) docBaseList.item(0);
                    NodeList docDateList = docBaseElement.getElementsByTagName("c:DocumentCreateDT");
                    NodeList docTypeCodeList = docBaseElement.getElementsByTagName("c:DocumentTypeCD");
                    Element docDateElement = (Element) docDateList.item(0);
                    Element docTypeCodelement = (Element) docTypeCodeList.item(0);

                    ConsentDocBaseDetail docBaseDetail = new ConsentDocBaseDetail();
                    docBaseDetail.setDate(parseDateFromXml(docDateElement.getTextContent()));
                    docBaseDetail.setDocTypeCode(docTypeCodelement.getTextContent());
                    docBaseDetails.add(docBaseDetail);
                }
            } else {
                System.out.println("No CustomerAgreement node found inside CustomerAgreementService Response.");
            }
        }catch (Exception e) {
                e.printStackTrace();
        }
        return docBaseDetails;
    }

    private static XMLGregorianCalendar parseDateFromXml(String xmlElementStr) {
        StringBuilder sb = new StringBuilder();
        sb.append("<root><date>").append(xmlElementStr).append("</date></root>");
        System.out.println("Date String: " + sb.toString());

        XMLGregorianCalendar xmlGregorianCalendar = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Root.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(sb.toString());
            Root root = (Root) unmarshaller.unmarshal(reader);
            xmlGregorianCalendar = root.getDate();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlGregorianCalendar;
    }

    @XmlRootElement
    static class Root {
        private XMLGregorianCalendar date;

        @XmlElement
        public XMLGregorianCalendar getDate() {
            return date;
        }

        public void setDate(XMLGregorianCalendar date) {
            this.date = date;
        }
    }
}