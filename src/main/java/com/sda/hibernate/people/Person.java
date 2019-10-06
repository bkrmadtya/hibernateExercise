package com.sda.hibernate.people;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(schema = "person_country", name = "person")
@EntityListeners(Listeners.class)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id_person;

    @Embedded
    private Name name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ElementCollection
    private List<String> nicknames;

    @Column
    private int id_country;

    public Person() {
    }

    Person(Name name, Gender gender, List<String> nicknames, int id_country) {
        this.name = name;
        this.gender = gender;
        this.nicknames = nicknames;
        this.id_country = id_country;
    }

    public long getId_person() {
        return id_person;
    }

    public void setId_person(long id_person) {
        this.id_person = id_person;
    }

    public Name getName() {
        return this.name;
    }

    public void setName(Name newName) {
        this.name = newName;
    }

    public int getId_country() {
        return id_country;
    }

    public void setId_country(int id_country) {
        this.id_country = id_country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<String> getNicknames() {
        return nicknames;
    }

    public void setNicknames(List<String> nicknames) {
        this.nicknames = nicknames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId_person() == person.getId_person();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId_person());
    }
}
