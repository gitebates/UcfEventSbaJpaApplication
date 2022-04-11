package models;

import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlEnum;

@XmlEnum
@Component
public enum EventType {

    RSO,

    PRIVATE,

    PUBLIC

}