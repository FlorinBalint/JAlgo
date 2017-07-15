package com.github.jalgo.algorithm.sort;

import java.util.Comparator;

import static com.github.jalgo.util.ArrayUtils.swap;

public class QuickSorter implements Sorter {

    @Override
    public <T> void sort(T[] values, Comparator<T> comparator) {
        if (values == null) {
            return;
        }

        quickSort(values, 0, values.length - 1, comparator);
    }

    private <T> void quickSort(T[] values, int startIndex, int endIndex, Comparator<T> comparator) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = partition(values, startIndex, endIndex, comparator);
        quickSort(values, startIndex, pivotIndex - 1, comparator);
        quickSort(values, pivotIndex + 1, endIndex, comparator);
    }

    private <T> int partition(T[] values, int startIndex, int endIndex, Comparator<T> comparator) {
        T pivot = values[endIndex];
        int smallerIndex = startIndex;

        for (int i = startIndex; i < endIndex; i++) {
            if (comparator.compare(pivot, values[i]) >= 0) {
                swap(values, smallerIndex++, i);
            }
        }

        swap(values, smallerIndex, endIndex);

        return smallerIndex;
    }
}
