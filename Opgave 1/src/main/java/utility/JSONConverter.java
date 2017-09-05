package utility;

import com.google.gson.Gson;
import entity.Person;
import java.util.List;

public class JSONConverter {
    
    private static Gson gson = new Gson();

    public static Person getPersonFromJson(String js) {
        return gson.fromJson(js, Person.class);
    }

    public static String getJSONFromPerson(Person p) {
        return null;
    }

    public static String getJSONFromPerson(List<Person> persons) {
        return null;
    }
}
