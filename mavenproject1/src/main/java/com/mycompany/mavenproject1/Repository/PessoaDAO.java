package com.mycompany.mavenproject1.Repository;

import com.mycompany.mavenproject1.HibernateUtil;
import com.mycompany.mavenproject1.Model.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class PessoaDAO {
    public void savePerson(Person person) {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(person);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public List<Person> getAllPersons() {
        EntityManager em = HibernateUtil.getEntityManagerFactory().createEntityManager();
        try {
            TypedQuery<Person> query = em.createQuery("FROM Person", Person.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
