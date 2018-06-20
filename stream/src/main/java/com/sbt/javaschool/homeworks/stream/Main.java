package com.sbt.javaschool.homeworks.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        /**
         * Подсказка по тестам с сонаром
         * https://stackoverflow.com/questions/22174501/sonarqube-not-picking-up-unit-test-coverage
         */


        List<Person> someCollection = new ArrayList<>();
        someCollection.add(new Person(10));
        someCollection.add(new Person(15));
        someCollection.add(new Person(20));
        someCollection.add(new Person(25));
        someCollection.add(new Person(30));
        someCollection.add(new Person(35));


        System.out.println("Before");
        for (int i =0; i < someCollection.size(); i++) {
            System.out.println(someCollection.get(i));
        }

        System.out.println("Stream");
        Map m1 = someCollection.stream()
                .filter(p -> p.getAge() > 20)
                .map(p -> new Person(p.getAge() + 30))
                .collect(Collectors.toMap(p -> p.getName(), p -> p.getAge()));

        for (Object entry : m1.entrySet()) {
            System.out.println(entry);
        }

        Stream.generate(() -> "-").limit(20).forEach(System.out::print);
        System.out.println();

        Map m = Streams.of(someCollection)
                .filter(p -> p.getAge() > 20)
                .transform( p -> new Person(p.getAge() + 30))
                .toMap(p -> p.getName(), p -> p);

        System.out.println("Before");
        for (int i =0; i < someCollection.size(); i++) {
            System.out.println(someCollection.get(i));
        }

        System.out.println("Streams");
        for (Object entry : m1.entrySet()) {
            System.out.println(entry);
        }
    }
}
