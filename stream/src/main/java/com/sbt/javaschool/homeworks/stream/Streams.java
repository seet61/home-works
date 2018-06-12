package com.sbt.javaschool.homeworks.stream;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Streams<T> {
    private static Stream stream;

    public static <T> Stream<T> of(List list) {
        stream = Arrays.stream((T[]) list.toArray());
        return stream;
    }

    public <T> Stream<T> filter(Predicate<T> predicate) {
        /*for (Iterator it = stream.iterator(); it.hasNext(); ) {
            T t = (T) it.next();

            if (!predicate.test(t)) {
                this.stream.
            }
        }*/
        return this.stream;
    }

    public Streams transform() {
        return this;
    }

    public Map toMap() {
        return new HashMap();
    }
}
