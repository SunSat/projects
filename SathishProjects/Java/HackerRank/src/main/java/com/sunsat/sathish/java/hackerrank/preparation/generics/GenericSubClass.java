package com.sunsat.sathish.java.hackerrank.preparation.generics;

class Sample1 {

    public Class getEntityType() {
        return Sample1.class;
    }
}

class Sample2 extends Sample1 {

    public Class getEntityType() {
        return Sample2.class;
    }

}

class Sample3 extends Sample2 {
    public Class getEntityType() {
        return Sample3.class;
    }

}


class GenericSuperClass<T extends Sample1> {
    public T helloWorld(T t) {
        System.out.println(t.toString());
        return t;
    }
}

class GenericSubClass2<T extends Sample1> extends GenericSuperClass<T> {

}

class GenericSubClass3 extends GenericSubClass2<Sample3> {

}


public class GenericSubClass {

    public static void main(String[] args) {
        Sample3 sam3  = new Sample3();
        GenericSubClass3 helloworld = new GenericSubClass3();
        Sample3  sa = helloworld.helloWorld(sam3);
    }
}
