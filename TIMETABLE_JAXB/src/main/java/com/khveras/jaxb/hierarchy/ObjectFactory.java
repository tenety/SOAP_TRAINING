//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.03.27 at 08:12:21 AM VET 
//


package com.khveras.jaxb.hierarchy;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.khveras.jaxb.marshalling package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.khveras.jaxb.marshalling
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Trip }
     * 
     */
    public Trip createTrip() {
        return new Trip();
    }

    /**
     * Create an instance of {@link Timetable }
     * 
     */
    public Timetable createTimetable() {
        return new Timetable();
    }

    /**
     * Create an instance of {@link Station }
     * 
     */
    public Station createStation() {
        return new Station();
    }

}