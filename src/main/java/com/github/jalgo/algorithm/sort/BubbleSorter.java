package com.github.jalgo.algorithm.sort;

import java.util.Comparator;

import static com.github.jalgo.util.ArrayUtils.swap;

public class BubbleSorter implements Sorter {

    @Override
    public <T> void sort(T[] values, Comparator<T> comparator) {
        if (values == null) {
            return;
        }

        boolean hasChanged = true;
        while (hasChanged) {
            hasChanged = false;

            for (int i = 0; i < values.length - 1; i++) {
                if (comparator.compare(values[i], values[i + 1]) > 0) {
                    swap(values, i, i + 1);
                    hasChanged = true;
                }
            }
        }
    }
}
