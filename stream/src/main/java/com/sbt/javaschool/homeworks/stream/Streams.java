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
        List<T> newList = new ArrayList<>(this.list);
        for (Iterator<T> it = newList.iterator(); it.hasNext(); ) {
            T element = it.next();
            if (!predicate.test(element)) {
                it.remove();
            }
        }

        return new Streams<>(newList);
    }

    /**
     * Преобразует элемент в другой.
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

    /**
     * принимает 2 лямбды для создания мапы, в одной указывается,
     * что использовать в качестве ключа, в другой, что в качестве значения
     * @param keyFunc функция для ключей
     * @param valFunc функция для значений
     * @param <K> тип ключа
     * @param <V> тип значения
     * @return
     */
    public <K, V> Map<K, V> toMap(Function<? super T, ? extends K> keyFunc,
                                  Function<? super T, ? extends V> valFunc) {
        Map<K, V> map = new HashMap<>();

        for (T item : this.list) {
            K key = keyFunc.apply(item);
            V val = valFunc.apply(item);
            map.put(key, val);
        }

        return map;
    }

}
