package com.github.jalgo.algorithm.sort;

import java.util.Comparator;

@FunctionalInterface
public interface Sorter {
    //todo add javadoc && comments for each implementation

    default <T extends Comparable<T>> void sort(T[] values) {
        sort(values, Comparable::compareTo);
    }

    <T> void sort(T[] values, Comparator<T> comparator);

}
