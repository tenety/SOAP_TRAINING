
package com.khveras.jaxws.baseObjects;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.khveras.jaxws.client package. 
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

    private final static QName _GetTrnByDestResponse_QNAME = new QName("http://www.khveras.com/TimeTableSchema", "getTrnByDestResponse");
    private final static QName _OperationResultResponse_QNAME = new QName("http://www.khveras.com/TimeTableSchema", "operationResultResponse");
    private final static QName _DeleteBusRequest_QNAME = new QName("http://www.khveras.com/TimeTableSchema", "deleteBusRequest");
    private final static QName _AddBusRequest_QNAME = new QName("http://www.khveras.com/TimeTableSchema", "addBusRequest");
    private final static QName _GetTrnByDestRequest_QNAME = new QName("http://www.khveras.com/TimeTableSchema", "getTrnByDestRequest");
    private final static QName _AddTripRequest_QNAME = new QName("http://www.khveras.com/TimeTableSchema", "addTripRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.khveras.jaxws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EditTrnDestRequest }
     * 
     */
    public EditTrnDestRequest createEditTrnDestRequest() {
        return new EditTrnDestRequest();
    }

    /**
     * Create an instance of {@link Station }
     * 
     */
    public Station createStation() {
        return new Station();
    }

    /**
     * Create an instance of {@link Trip }
     * 
     */
    public Trip createTrip() {
        return new Trip();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Trip }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.khveras.com/TimeTableSchema", name = "getTrnByDestResponse")
    public JAXBElement<Trip> createGetTrnByDestResponse(Trip value) {
        return new JAXBElement<Trip>(_GetTrnByDestResponse_QNAME, Trip.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.khveras.com/TimeTableSchema", name = "operationResultResponse")
    public JAXBElement<String> createOperationResultResponse(String value) {
        return new JAXBElement<String>(_OperationResultResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.khveras.com/TimeTableSchema", name = "deleteBusRequest")
    public JAXBElement<String> createDeleteBusRequest(String value) {
        return new JAXBElement<String>(_DeleteBusRequest_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Trip }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.khveras.com/TimeTableSchema", name = "addBusRequest")
    public JAXBElement<Trip> createAddBusRequest(Trip value) {
        return new JAXBElement<Trip>(_AddBusRequest_QNAME, Trip.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Station }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.khveras.com/TimeTableSchema", name = "getTrnByDestRequest")
    public JAXBElement<Station> createGetTrnByDestRequest(Station value) {
        return new JAXBElement<Station>(_GetTrnByDestRequest_QNAME, Station.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Trip }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.khveras.com/TimeTableSchema", name = "addTripRequest")
    public JAXBElement<Trip> createAddTripRequest(Trip value) {
        return new JAXBElement<Trip>(_AddTripRequest_QNAME, Trip.class, null, value);
    }

}
