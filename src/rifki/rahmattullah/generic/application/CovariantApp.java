package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.MyData;

public class CovariantApp {
    public static void main(String[] args) {

        MyData<String> stringMyData = new MyData<>("Rifki");
        process(stringMyData);

        MyData<? extends Object> myData = stringMyData;
    }

    public static void process(MyData<? extends Object> myData) {
        System.out.println(myData.getData());

//        myData.setData(1); tidak boleh mengubah data, karena berbahaya.
    }
}
