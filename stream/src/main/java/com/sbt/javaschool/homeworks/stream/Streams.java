package com.sbt.javaschool.homeworks.stream;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Streams<T> {
    private List<T> list;

    /**
     * Конструктор класса
     * @param list коллекция передаваемая констурктору
     */
    private Streams(List<? extends T> list) {
        this.list = (List<T>) list;
    }

    /**
     * Создаем Streams для обработки
     * @param list типа данных
     * @param <T> тип данных
     * @return новый объект класса Streams
     */
    public static <T> Streams<T> of(List<T> list) {
        return new Streams<T>(list);
    }

    /**
     * Оставляет в коллекции только те элементы, которые удовлетворяют условию в лямбде.
     * @param predicate условие проверки
     * @return this.list
     */
    public Streams<T> filter(Predicate<T> predicate) {
        for (Iterator<T> it = list.iterator(); it.hasNext(); ) {
            T element = it.next();
            if (!predicate.test(element)) {
                it.remove();
            }
        }

        return this;
    }

    /**
     * преобразует элемент в другой.
     * @param function
     * @return
     */
    public Streams<T> transform(Function<? super T, ? extends T> function) {
        List<T> newList = new ArrayList<>();
        for (Iterator<T> itl = list.iterator(); itl.hasNext(); ) {
            T newItem = function.apply(itl.next());
            newList.add(newItem);
        }
        return new Streams<>(newList);
    }

    /*
    public HashMap toMap(Predicate<T> p1, Predicate<T> p2) {
        if (p1.test(t)) {
            return new HashMap(t.toString());
        }

        return null;
    }
    */
}
