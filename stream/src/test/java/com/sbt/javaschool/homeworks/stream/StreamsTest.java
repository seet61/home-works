package com.sbt.javaschool.homeworks.stream;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class StreamsTest {
    private static List<Person> someCollection = new ArrayList<>();

    @BeforeClass
    public static void setUpClass() {
        someCollection.add(new Person(10));
        someCollection.add(new Person(15));
        someCollection.add(new Person(20));
        someCollection.add(new Person(25));
        someCollection.add(new Person(30));
        someCollection.add(new Person(35));
    }

    @Test
    public void of() {
        assertEquals("of()", Streams.class, Streams.of(someCollection).getClass());
    }

    @Test
    public void filter() {
        assertNotEquals(String message, Object unexpected, Object actual);
    }

    @Test
    public void transform() {
    }

    @Test
    public void toMap() {
    }
}