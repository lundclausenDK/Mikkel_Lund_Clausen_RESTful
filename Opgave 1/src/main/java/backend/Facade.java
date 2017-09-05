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
        p = new Person();
        em.getTransaction().begin();
        
        p.setFirstName(p.getFirstName());
        p.setLastName(p.getLastName());
        p.setPhonenumber(p.getPhonenumber());
        
        em.persist(p);
        em.getTransaction().commit();
               
        
        return p;
    }

    @Override
    public Person deletePerson(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person getPerson(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> getPersons() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Person editPerson(Person p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void demoAddPerson(String firstname, String lastname, int phonenumber) {
        Person p = new Person();
        em.getTransaction().begin();
        
        p.setFirstName(firstname);
        p.setLastName(lastname);
        p.setPhonenumber(phonenumber);
        
        em.persist(p);
        em.getTransaction().commit();

    }
    
    public void close() {
        em.close();
    }

}
