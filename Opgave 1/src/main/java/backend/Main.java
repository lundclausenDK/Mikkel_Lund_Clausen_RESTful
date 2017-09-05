package backend;

public class Main {
    
    public static void main(String[] args) {
        
        Facade facade = new Facade();
        
        facade.demoAddPerson("Mike", "Tyson", 12345678);
        
        facade.close();
        
    }
    
}
