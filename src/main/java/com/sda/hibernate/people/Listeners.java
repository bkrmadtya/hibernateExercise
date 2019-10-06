package com.sda.hibernate.people;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class Listeners {
    @PrePersist
    public void printBefore(){

    }

    @PostPersist
    public void printName(Person person) {
        System.out.println("Saved : " + person.getName().getFirstName());
    }
}
