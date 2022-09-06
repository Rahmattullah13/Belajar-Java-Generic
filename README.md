# Java Generic

---

## Pengenalan Generic

- Generic adalah kemampuan menambahkan parameter type saat membuat class atau method.
- Berbeda dengan tipe data yang biasa kita gunakan di class function,
  generic memgungkinkan kita bisa mengubah-ubah bentuk tipe data sesuai dengan yang kita mau.

---

## Manfaat Generic

- Pengecekan ketika proses kompilasi.
- Tidak perlu manual menggunakan pengecekan tipe data dan konversi tipe data.
- Memudahkan programmer membuat kode program yang generic sehingga bisa digunakan oleh berbagai tipe data.

---

## Generic Class

- Generic class adalah class atau interface yang memiliki parameter type.
- Tidak ada ketentuan dalam pembuatan generic parameter type,
  namun biasanya kebanyakan orang menggunakan 1 karakter sebagai generic parameter type.
- Nama generic parameter type yang biasa digunakan adalah:
-
    - E : Element (Biasa digunakan di collection atau strukture data).
-
    - K : Key
-
    - N : Number
-
    - T : Type
-
    - V : Value
-
    - S,U,V etc. 2nd, 3rd, 4th, type

### Contoh Generic Class

```java
package rifki.rahmattullah.generic;

public class MyData<T> {

    private T data;

    public MyData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
```

### Contoh Generic Object

```java
package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.MyData;

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

```

---

## Multiple Parameter Type

- Parameter type di Generic class boleh lebih dari satu.
- Namun harus menggunakan nama type yang berbeda.
- Ini sangat berguna ketika kita ingin membuat generic parameter type yang banyak.

### Contoh Class Multiple Parameter Type

```java
package rifki.rahmattullah.generic;

public class Pair<T, U> {

    private T first;

    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }
}
```

### Contoh Object Multiple Parameter Type

```java
package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.util.Pair;

public class PairApp {
    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<String, Integer>("Rifki", 23);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}
```

---

## Generic Method

- Generic Parameter type tidak hanya bisa digunakan pada class atau interace saja.
- Kita juga menggunakan generic parameter type di method.
- Generic parameter type yang kita deklarasikan di method, hanya bisa diakses di method tersebut,
  tidak bisa diakses di luar method
- Ini cocok jika kita ingin membuat generic method, tanpa harus mengubah deklarasi class.

### Contoh Generic Method

```java
package rifki.rahmattullah.generic.util;

public class ArrayHelper {

    // Tidak harus static
    public static <T> int count(T[] array) {
        return array.length;
    }
}
```

### Contoh Menggunakan Generic Method

```java
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
```

---

## Invariant

- Secara default, saat kita membuat generic parameter type, sifat parameter tersebut adalah invariant.
- Invariant artinya, tidak boleh di subtitusi dengan subtype(child) atau supertype(parent).
- Artinya, saat kita membuat object Contoh<String>, maka tidak sama dengan Contoh<Object>,
  begitupun sebaliknya, saat membua object Contoh<Object>, maka tidak sama dengan Contoh<String>.
- Jadi, tidak ada hubungannya antara Polimorphism dan Generic.

### Contoh Invariant

```java
package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.MyData;

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
```

---

## Covariant

- Covariant artinya kita bisa melakukan subtitusi subtype(child) dengan supertype(parent).
- Caranya agar generic object kita menjadi covariant adalah dengan menggunakan kata kunci (? extends ParentClass).
- Artinya saat kita membuat object Contoh<String>, maka bisa disubtitusi menjadi Contoh(? extends Object).
- Covariant adalah read-only, jadi kita tidak bisa mengubah data genericnya.
- Jadi, tidak ada hubungannya antara Polimorphism dan Generic.
- Kita hanya bisa mengambil data generic nya.
- Kita tidak boleh merubah datanya.

### Contoh Covariant

```java
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

```

---

## Contravariant

- Contravariant artinya kita bisa melakukan subtitusi supertype(parent) dengan subtype(child).
- Caranya agar generic object kita menjadi contravariant adalah dengan menggunakan kata kunci (? super SubClass).
- Artinya saat kita membua object Contoh(Object), maka bisa disubtitusi menjadi Contoh<? super String>.
- Contravariant bisa write dan read, namun perlu berhati-hati ketika melakukan read,
  terutama jika sampai parent nya punya banyak child.

### Contoh Contravariant

```java
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

```

---

## Bounded Type Parameter

- Kadang kita ingin membatasi data yang boleh digunakan di generic parameter type.
- Kita bisa menambahkan constraint di generic parameter type dengan menyebutkan tipe yang diperbolehkan.
- Secara otomatis, type data yang bisa digunakan adalah type yang sudah kita sebutkan, atau class-class turunannya.
- Secara default, constraint type untuk generic parameter type adalah Object, sehingga semua tipe data bisa digunakan.

**Contoh Bounded Type Parameter**

```java
package rifki.rahmattullah.generic.application;

public class ConstraintApp {
    public static void main(String[] args) {
        NumberData<Integer> integerNumberData = new NumberData<>(2);
        NumberData<Long> longNumberData = new NumberData<>(1L);

//        NumberData<String> stringNumberData = new NumberData<String>("Rifki") // ERROR!
    }

    public static class NumberData<T extends Number> {

        private T data;

        public NumberData(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
```

## Multiple Bounded Type Parametert

- Kadang kita ingin membatasi tipe data dengan beberapa jenis tipe data di generic parameter type.
- Kita bisa menambagkan beberapa bounded type parameter dengan karakter & setelah bounded type pertama.
- Jika ingin menambahkan lagi, kita cukup gunakan karakter & diikuti bounded type nya lagi.
- Class hanya untuk yang pertama, kedua dan seterusnya harus interface.

**Multiple Bounded Type Parametert**

```java
package rifki.rahmattullah.generic.application;

public class MultipleConstraintApp {
    public static void main(String[] args) {
//        Data<Manager> managerData = new Data<>(new Manager()) // ERROR : Manager tidak implement CanSayHello
        Data<VicePresident> vicePresidentData = new Data<>(new VicePresident());
    }

    public static interface CanSayHello {
        void sayHello(String name);
    }

    public static abstract class Employee {

    }

    public static class Manager extends Employee {

    }

    public static class VicePresident extends Employee implements CanSayHello {

        @Override
        public void sayHello(String name) {
            System.out.println("Hello " + name);
        }
    }

    public static class Data<T extends Employee & CanSayHello> {

        private T data;

        public Data(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}

```

---

## Wildcard

- Kadang ada kasus kita tidak peduli dengan generic parameter type pada object.
- Misal kita hanya ingin menampilkan data T, tidak peduli tipe apapun.
- Jika kita mengalamai kasus seperti itu, kita bisa menggunakan wildcard.
- Wildcard bisa dibuat dengan mengganti generic parameter type dengan karakter tanda tanya(?).

```java
package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.MyData;

public class WildcardApp {
    public static void main(String[] args) {

        print(new MyData<Integer>(100));
        print(new MyData<String>("Rifki"));
        print(new MyData<MultipleConstraintApp.Manager>(new MultipleConstraintApp.Manager()));
    }

    public static void print(MyData<?> myData) {
        System.out.println(myData.getData());
    }
}

```

---

## Type Erasure

- Type erasure adalah proses pengecekan generic pada saat compile time, dan menghiraukan pengecekan pada saat runtime.
- Type erasure menjadikan informasi generic yang kita buat akan hilang ketika kode program kita telah
  di compile menjadi binary file.
- Compiler akan mengubah generic parameter type menjadi tipe Object di Java.

### Contoh Type Erasure

**Kode sebelum di compile**

```java
public static class Data<T> {
    private T data;

    public Data(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
```

**Kode Setelah di Compile**

```java
public static class Data<T> {
    private Object data;

    public Data(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
```

## Probelem Type Erasure

- Karena informasi generic hilang ketika sudah menjadi binary file
- Oleh karena itu, konversi tipe data generic akan berbahasy jika dilakukan sexara tidak bijak.

**Contoh Probelem Type Erasure**

```java
package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.MyData;

public class TypeErasureApp {
    public static void main(String[] args) {

        MyData myData = new MyData<>("Rifki");

        MyData<Integer> integerMyData = (MyData<Integer>) myData;
        Integer integer = integerMyData.getData();
    }
}

```

---

## Comparable

- Sebelumnya kita sudah tahu bahwa operator perbandingan object menggunakan method equals.
- Bagaimana dengan operator perbandingan lainnya? seperti kurang dari atau lebih dari?
- Operator perbandingan tersebut bisa kita lakukan, jika kita mewariskan interface generic Comparable.
- Ini banyak sekali digunakan seperti untuk proses pengurutan data misalnya.
- [Dokumentasi Comparable](https://docs.oracle.com/en/java/javase/14/java.base/java/lang/Comparable.html)

**Contoh Comparable**

```java
package rifki.rahmattullah.generic.util;

public class Person implements Comparable<Person> {

    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

```

---

## Comparator Interface

- Jika kita ingin menurutkan class yang kita gunakan, cukup mudah tinggal implement interface Comparable.
- Namun bagaimana jika class tersebut milik orang lain? Tidak bisa diubah?
- Makan kita bisa menggunakan interface generic yang bernama Comparator.
- [Dokumentasi Comparator Interface](https://docs.oracle.com/en/java/javase/14/java.base/java/util/Comparator.html)

**Contoh Comparator Interface**

```java
package rifki.rahmattullah.generic.application;

import rifki.rahmattullah.generic.util.Person;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorApp {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Rifki", "Indonesia"),
                new Person("Hasby", "Indonesia"),
                new Person("Agifa", "Indonesia")
        };

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Arrays.sort(people, comparator);

        System.out.println(Arrays.toString(people));
    }
}

```

---

# Selesai