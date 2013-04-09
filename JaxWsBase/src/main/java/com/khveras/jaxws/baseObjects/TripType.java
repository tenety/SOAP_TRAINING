
package com.khveras.jaxws.baseObjects;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tripType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tripType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRAIN"/>
 *     &lt;enumeration value="BUS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tripType")
@XmlEnum
public enum TripType {

    TRAIN,
    BUS;

    public String value() {
        return name();
    }

    public static TripType fromValue(String v) {
        return valueOf(v);
    }

}
