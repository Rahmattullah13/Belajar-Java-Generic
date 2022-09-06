package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.util.MyData;

public class TypeErasureApp {
    public static void main(String[] args) {

        MyData myData = new MyData<>("Rifki");

        MyData<Integer> integerMyData = (MyData<Integer>) myData;
        Integer integer = integerMyData.getData();
    }
}
