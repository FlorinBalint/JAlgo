package com.github.jalgo.algorithm.sort;

import java.util.Comparator;

import static com.github.jalgo.util.ArrayUtils.swap;

public class HeapSorter implements Sorter {

    @Override
    public <T> void sort(T[] values, Comparator<T> comparator) {
        if (values == null) {
            return;
        }

        Comparator<T> reversedComparator = comparator.reversed();
        heapify(values, reversedComparator);
        int maxIndex = values.length - 1;

        while (maxIndex > 0) {
            swap(values, 0, maxIndex--);
            sinkDownIndexUpto(values, 0, maxIndex, reversedComparator);
        }
    }

    public static <T> void heapify(T[] values, Comparator<T> comparator) {
        for (int i = values.length - 1; i >= 0; i--) {
            sinkDownIndexUpto(values, i, values.length - 1, comparator);
        }
    }

    private static <T> void sinkDownIndexUpto(T[] values, int index, int maxSize, Comparator<T> comparator) {
        T value = values[index];
        int minIndex = index;

        int leftIndex = (index << 1) + 1;
        int rightIndex = (index << 1) + 2;

        if (leftIndex <= maxSize && comparator.compare(values[leftIndex], value) < 0) {
            minIndex = leftIndex;
        }

        if (rightIndex <= maxSize && comparator.compare(values[rightIndex], values[minIndex]) < 0) {
            minIndex = rightIndex;
        }

        if (minIndex != index) {
            swap(values, index, minIndex);
            sinkDownIndexUpto(values, minIndex, maxSize, comparator);
        }
    }
}
