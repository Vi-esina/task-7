package web.service;


import web.model.Person;

import java.util.List;

public interface PersonService {
    void add(Person person);

    List<Person> listPerson();

    void deletePerson(Long id);

    Person getPerson(Long id);

    void updatePerson(Person person);


}
