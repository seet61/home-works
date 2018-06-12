package com.sbt.javaschool.homeworks.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Person> someCollection = new ArrayList<>();
        someCollection.add(new Person(10));
        someCollection.add(new Person(15));
        someCollection.add(new Person(20));
        someCollection.add(new Person(25));
        someCollection.add(new Person(30));
        someCollection.add(new Person(35));

        /*
        for (int i =0; i < someCollection.size(); i++) {
            System.out.println(someCollection.get(i).getAge());
        }
        */


        Map m = Streams.of(someCollection)
                .filter(p -> p.getAge() > 20)
                .transform( p -> new Person(p.getAge() + 30))
                .toMap(p -> p.getName(), p -> p);

    }
}
