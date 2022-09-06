package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.util.MyData;

public class InvariantApp {
    public static void main(String[] args) {

        MyData<String> stringMyData = new MyData<>("Rifki");
//        doIt(stringMyData); // Error
//        MyData<Object> objectMyData = stringMyData; // ERROR

        MyData<Object> objectMyData = new MyData<>(1000);
//        MyData<Integer> integerMyData = objectMyData; // Error
//        doItInteger(objectMyData); // Error

    }

    public static void doIt(MyData<Object> objectMyData) {
        // do something
    }

    public static void doItInteger(MyData<Integer> integerMyData) {
        // do something
    }
}
