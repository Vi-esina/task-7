package web.dao;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.Person;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }
    @Override
    @SuppressWarnings("unchecked")
    public List<Person> listPerson() {
        //TypedQuery<Person> query = sessionFactory.getCurrentSession().createQuery("from Person");
        return sessionFactory.getCurrentSession().createQuery("FROM Person ").list();
    }

    @Override
    public void deletePerson(Long id) {
    Person person = getPerson(id);
    sessionFactory.getCurrentSession().delete(person);
    }

    @Override
    public Person getPerson(Long id) {

        return sessionFactory.getCurrentSession().get(Person.class, id);
    }

    @Override
    public void updatePerson(Person person) {
    sessionFactory.getCurrentSession().update(person);
    }



}
