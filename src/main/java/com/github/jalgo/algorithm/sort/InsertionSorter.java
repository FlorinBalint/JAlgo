package com.github.jalgo.algorithm.sort;

import java.util.Comparator;

import static java.util.Arrays.binarySearch;

public class InsertionSorter implements Sorter {

    @Override
    public <T> void sort(T[] values, Comparator<T> comparator) {
        if (values == null) {
            return;
        }

        for (int i = 1; i < values.length; i++) {
            T value = values[i];
            int insertPosition = binarySearch(values, 0, i, value);
            if (insertPosition < 0) {
                insertPosition = ~insertPosition;
            }

            insertInSortedSide(values, i, insertPosition);
        }
    }

    private static <T> void insertInSortedSide(T[] values, int source, int destination) {
        T value = values[source];
        System.arraycopy(values, destination, values, destination + 1, source - destination);
        values[destination] = value;
    }
}
