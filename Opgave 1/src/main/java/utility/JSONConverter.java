package utility;

import com.google.gson.Gson;
import entity.Person;
import java.util.List;

public class JSONConverter {
    
    private Gson gson = new Gson();

    public Person getPersonFromJson(String js) {
        return gson.fromJson(js, Person.class);
    }

    public String getJSONFromPerson(Person p) {
        return null;
    }

    public String getJSONFromPerson(List<Person> persons) {
        return gson.toJson(persons);
    }
}
