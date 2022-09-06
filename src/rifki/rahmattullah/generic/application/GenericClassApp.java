package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.util.MyData;

public class GenericClassApp {
    public static void main(String[] args) {

        MyData<String> stringMyData = new MyData<String>("Rifki");
        MyData<Integer> integerMyData = new MyData<Integer>(23);

        String stringValue = stringMyData.getData();
        Integer integerValue = integerMyData.getData();

        System.out.println(stringValue);
        System.out.println(integerValue);
    }
}
