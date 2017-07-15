package com.github.jalgo.algorithm.sort;

import java.util.Comparator;

import static com.github.jalgo.util.ArrayUtils.swap;

public class SelectionSorter implements Sorter {

    @Override
    public <T> void sort(T[] values, Comparator<T> comparator) {
        if (values == null) {
            return;
        }

        for (int currentIndex = 0; currentIndex < values.length - 1; currentIndex++) {
            int minIndex = currentIndex;

            for (int i = currentIndex; i < values.length; i++) {
                if (comparator.compare(values[minIndex], values[i]) > 0) {
                    minIndex = i;
                }
            }

            swap(values, currentIndex, minIndex);
        }
    }
}
