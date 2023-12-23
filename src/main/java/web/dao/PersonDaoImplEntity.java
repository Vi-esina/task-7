package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDaoImplEntity implements PersonDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager entityManager;

    @Override
    public void add(Person person) {
        entityManager.persist(person);
    }

    @Override
    public List<Person> listPerson() {
        return entityManager.createQuery("select p from Person p", Person.class).getResultList();
    }

    @Override
    public void deletePerson(Long id) {
        Person person = entityManager.find(Person.class, id);
        if (person != null) {
            entityManager.remove(person);
        }
    }

    @Override
    public Person getPerson(Long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void updatePerson(Person person) {
        entityManager.merge(person);
    }
}
