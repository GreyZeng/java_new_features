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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void printPerson() {
        // ...
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
}
