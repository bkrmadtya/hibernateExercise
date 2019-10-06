package com.sda.hibernate.people;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.function.Function;

public class PersonDao {

    public void createPerson(Person person) {
        queryData(session -> {
            session.save(person);
            return person;
        });
    }

    public void updatePerson(Person person) {
        queryData(session -> {
            session.update(person);
            return person;
        });
    }

    public void deletePerson(Person person) {
        queryData(session -> {
            session.delete(person);
            return person;
        });
    }

    public void loadPerson(Long id) {
        queryData(session -> {
            Person p = session.load(Person.class, id);
            System.out.println(p.getName().getFirstName());

            session.refresh(p);

            System.out.println(p.getName().getFirstName());

            return p;
        });
    }

    private void queryData(Function<Session, Person> fun) {
        Transaction transaction = null;

        try {
            Session session = HibernateUtils.getSessionFactory().openSession();

            // start a transaction
            transaction = session.beginTransaction();

            // save the person object
            fun.apply(session);

            // commit transaction
            transaction.commit();


        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }


}
