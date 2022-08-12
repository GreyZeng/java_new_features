package git.snippets.jdk8;

import java.time.LocalDate;
import java.util.List;

public class Person {
    public static List<Person> createRoster() {
        return null;
    }

    public Sex getGender() {
        return null;
    }

    public int getAge() {
        return 0;
    }

    public String getEmailAddress() {
        return null;
    }

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;


    public void printPerson() {
        // ...
    }
}
