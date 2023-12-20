package web.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.PersonDao;
import web.dao.PersonDaoImpl;
import web.model.Person;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

@Autowired
    private PersonDao personDao;
    @Transactional
    @Override
    public void add(Person person) {
        personDao.add(person);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Person> listPerson() {
        return personDao.listPerson();
    }

    @Override
    public void deletePerson(Long id) {
        personDao.deletePerson(id);
    }

    @Override
    public Person getPerson(Long id) {
        return personDao.getPerson(id);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }
}
