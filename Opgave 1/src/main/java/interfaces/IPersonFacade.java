package interfaces;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManagerFactory;

public interface IPersonFacade {

    public void addEntityManagerFactory(EntityManagerFactory emf);

    public Person addPerson(Person p);

    public Person deletePerson(Long id);

    public Person getPerson(Long id);

    public List<Person> getPersons();

    public Person editPerson(Person p);
}
