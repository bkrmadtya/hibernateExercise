package com.sda.hibernate.people;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Person person = new Person(new Name("TOm", "Harri"), Gender.MALE, Arrays.asList("Omm", "Hom", "Tom"), 1);
        PersonDao personDao = new PersonDao();

//        personDao.createPerson(person);

        personDao.loadPerson(7L);

        HibernateUtils.shutdown();
    }
}
