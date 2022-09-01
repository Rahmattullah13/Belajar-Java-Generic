package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.MyData;

public class ContravariantApp {
    public static void main(String[] args) {
        MyData<Object> objectMyData = new MyData<>("Rifki");
        MyData<? super String> myData = objectMyData;

        process(objectMyData);

        System.out.println(objectMyData.getData());
    }

    public static void process(MyData<? super String> myData) {
        myData.setData("Rifki Rahmattullah");
    }
}
