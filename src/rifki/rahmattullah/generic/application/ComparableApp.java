package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.util.Person;

import java.util.Arrays;

public class ComparableApp {
    public static void main(String[] args) {

        Person[] people = {
                new Person("Rifki", "Indonesia"),
                new Person("Hasby", "Indonesia"),
                new Person("Agifa", "Indonesia")
        };

        Arrays.sort(people);

        System.out.println(Arrays.toString(people));
    }
}
