package backend;

import com.google.gson.Gson;
import entity.Person;
import java.util.ArrayList;
import java.util.Random;

public class Generator {

    private Gson gson = new Gson();
    Random random = new Random();

    String[] firstnames = {"Peter", "Susan", "Mick", "Melinda", "George", "Michael", "George", "Michael", "Joe", "Mina", "Samson"};
    String[] lastnames = {"Sampras", "Jones", "Jagger", "Patrick", "Harrison", "Jackson", "Gabriel", "Miles", "Whales", "MiniMe", "Jennason"};

    public String createJson(int amount, int startpoint) {
        String firstname = "";
        String lastname = "";
        int id = startpoint-1;
        
        ArrayList<Person> group = new ArrayList();

        for (int i = 0; i < amount; i++) {
            
            int age = random.nextInt(70 - 17) + 17;

            int num = random.nextInt(firstnames.length);
            firstname = firstnames[num];

            num = random.nextInt(firstnames.length);
            lastname = lastnames[num];

            id++;
            
            group.add(new Person(firstname, lastname, id, age));
        }

        return gson.toJson(group);
    }

}
