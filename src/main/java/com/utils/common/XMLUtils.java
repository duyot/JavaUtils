package com.utils.common;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by duyot on 7/11/2016.
 */
public class XMLUtils {


    public static void main(String[] args) {
    }

    public static String objectToXMLString(Object object){
        StringWriter sw = new StringWriter();
        try {
            JAXBContext jaxbContext   = JAXBContext.newInstance(object.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object,sw);
            return sw.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static <T> T xmlToObject(String xmlContent,Class objectClass){
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(objectClass);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(xmlContent);
            return (T) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

}
