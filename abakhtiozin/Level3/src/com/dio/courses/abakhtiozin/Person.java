package com.dio.courses.abakhtiozin;

/**
 * Created by AA on 19.10.2014.
 */
public class Person {

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    private String name;
    private String surname;

    @Override
    public String toString() {
        return name + " " + surname;
    }



}
