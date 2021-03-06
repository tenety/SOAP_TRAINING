
package com.khveras.jaxws.baseObjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trip complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trip">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="vehicleID" type="{http://www.khveras.com/TimeTable}vehicleID"/>
 *         &lt;element name="depStation" type="{http://www.khveras.com/TimeTable}station"/>
 *         &lt;element name="destStation" type="{http://www.khveras.com/TimeTable}station"/>
 *         &lt;element name="timeInWay">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="tripType" use="required" type="{http://www.khveras.com/TimeTable}tripType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trip", propOrder = {
    "vehicleID",
    "depStation",
    "destStation",
    "timeInWay"
})
public class Trip {

    @XmlElement(required = true)
    protected String vehicleID;
    @XmlElement(required = true)
    protected Station depStation;
    @XmlElement(required = true)
    protected Station destStation;
    @XmlElement(required = true)
    protected String timeInWay;
    @XmlAttribute(required = true)
    protected TripType tripType;

    /**
     * Gets the value of the vehicleID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVehicleID() {
        return vehicleID;
    }

    /**
     * Sets the value of the vehicleID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVehicleID(String value) {
        this.vehicleID = value;
    }

    /**
     * Gets the value of the depStation property.
     * 
     * @return
     *     possible object is
     *     {@link Station }
     *     
     */
    public Station getDepStation() {
        return depStation;
    }

    /**
     * Sets the value of the depStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Station }
     *     
     */
    public void setDepStation(Station value) {
        this.depStation = value;
    }

    /**
     * Gets the value of the destStation property.
     * 
     * @return
     *     possible object is
     *     {@link Station }
     *     
     */
    public Station getDestStation() {
        return destStation;
    }

    /**
     * Sets the value of the destStation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Station }
     *     
     */
    public void setDestStation(Station value) {
        this.destStation = value;
    }

    /**
     * Gets the value of the timeInWay property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeInWay() {
        return timeInWay;
    }

    /**
     * Sets the value of the timeInWay property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeInWay(String value) {
        this.timeInWay = value;
    }

    /**
     * Gets the value of the tripType property.
     * 
     * @return
     *     possible object is
     *     {@link TripType }
     *     
     */
    public TripType getTripType() {
        return tripType;
    }

    /**
     * Sets the value of the tripType property.
     * 
     * @param value
     *     allowed object is
     *     {@link TripType }
     *     
     */
    public void setTripType(TripType value) {
        this.tripType = value;
    }

}
