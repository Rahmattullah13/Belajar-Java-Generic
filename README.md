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

import rifki.rahmattullah.generic.Pair;

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