package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.util.ArrayHelper;

public class ArrayHelperApp {
    public static void main(String[] args) {

        String[] names = {"Rifki", "Hasby", "Agifa"};
        Integer[] numbers = {1, 2, 3, 4, 5};

        System.out.println(
                ArrayHelper.<String>count(names)
        );

        // Lebih aman tidak menulis <Integer>
        System.out.println(
                ArrayHelper.count(numbers)
        );
    }
}
