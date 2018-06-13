package com.sbt.javaschool.homeworks.stream;

import java.util.*;
import java.util.function.Predicate;

public class Streams<T> {
    private T t;

    private Streams(T t) {
        this.t = t;
    }


    public static <T> Streams<T> of(T t) {
        return new Streams<T>(t);
    }

    public <T> Streams<T> filter(Predicate<T> predicate) {
        if (predicate.test((T) t)) {
            return new Streams<T>((T) t);
        }

        return null;
    }

    public <T> Streams<T> transform(T t) {
        return new Streams<T>((T) t);
    }

    public HashMap toMap(Predicate<T> p1, Predicate<T> p2) {
        if (p1.test(t)) {
            return new HashMap(t,t.toString());
        }

        return null;
    }
}
