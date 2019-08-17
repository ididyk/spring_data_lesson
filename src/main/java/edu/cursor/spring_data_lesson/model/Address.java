package edu.cursor.spring_data_lesson.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

//@Embeddable
//@Getter
//@Setter
public class Address {
    private String country;
    private String city;
    private String zip;
}
