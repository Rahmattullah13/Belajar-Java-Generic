package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.Pair;

public class PairApp {
    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<String, Integer>("Rifki", 23);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}
