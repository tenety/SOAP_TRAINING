
package com.khveras.jaxws.baseObjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="trnID" type="{http://www.khveras.com/TimeTable}vehicleID"/>
 *         &lt;element name="newDestination" type="{http://www.khveras.com/TimeTable}station"/>
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
    "trnID",
    "newDestination"
})
@XmlRootElement(name = "editTrnDestRequest", namespace = "http://www.khveras.com/TimeTableSchema")
public class EditTrnDestRequest {

    @XmlElement(namespace = "", required = true)
    protected String trnID;
    @XmlElement(namespace = "", required = true)
    protected Station newDestination;

    /**
     * Gets the value of the trnID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrnID() {
        return trnID;
    }

    /**
     * Sets the value of the trnID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrnID(String value) {
        this.trnID = value;
    }

    /**
     * Gets the value of the newDestination property.
     * 
     * @return
     *     possible object is
     *     {@link Station }
     *     
     */
    public Station getNewDestination() {
        return newDestination;
    }

    /**
     * Sets the value of the newDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link Station }
     *     
     */
    public void setNewDestination(Station value) {
        this.newDestination = value;
    }

}
