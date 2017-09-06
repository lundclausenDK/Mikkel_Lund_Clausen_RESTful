package backend;

import entity.Person;
import interfaces.IPersonFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Facade implements IPersonFacade {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");
    private final EntityManager em = emf.createEntityManager();

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person addPerson(Person p) {

        em.getTransaction().begin();
        
        p.setFirstName(p.getFirstName());
        p.setLastName(p.getLastName());
        p.setPhonenumber(p.getPhonenumber());
        
        em.persist(p);
        em.getTransaction().commit();
        
        em.close();
        
        return p;
    }

    @Override
    public Person deletePerson(Long id) {
        em.getTransaction().begin();
        Person person = em.find(Person.class, id);
        em.remove(person);
        em.getTransaction().commit();
        
        return person;
    }

    @Override
    public Person getPerson(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getPersons() {

        List<Person> results = em.createQuery("SELECT p FROM Person p").getResultList();
        
        return results;
    }

    @Override
    public Person editPerson(Person p) {
        em.getTransaction().begin();
        
        Person person = em.find(Person.class, p.getId());
        
        person.setFirstName(p.getFirstName());
        person.setLastName(p.getLastName());
        person.setPhonenumber(p.getPhonenumber());
        
        em.getTransaction().commit();
        
        return person;
    }
    
    public void demoAddPerson(String firstname, String lastname, int phonenumber) {
        em.getTransaction().begin();
        
        Person person = new Person();
                
        person.setFirstName(firstname);
        person.setLastName(lastname);
        person.setPhonenumber(phonenumber);
        
        em.persist(person);
        em.getTransaction().commit();

    }
    
    public void close() {
        em.close();
    }

}
