package com.github.jalgo.algorithm.sort;

import com.github.jalgo.util.ArrayGrower;

import java.util.Comparator;

public class MergeSorter implements Sorter {

    private static final int DEFAULT_CAPACITY = 20;

    @SuppressWarnings("unchecked")
    private static final ArrayGrower ARRAY_GROWER = new ArrayGrower(Object.class);

    private transient Object[] auxArray = new Object[DEFAULT_CAPACITY];

    @Override
    public <T> void sort(T[] values, Comparator<T> comparator) {
        if (values == null) {
            return;
        }

        auxArray = growToNewSizeIfNeeded(auxArray, values.length);
        mergeSort(values, 0, values.length - 1, comparator);
    }

    private <T> void mergeSort(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
        if (toIndex <= fromIndex) {
            return;
        }

        int mid = fromIndex + (toIndex - fromIndex) / 2;
        mergeSort(array, fromIndex, mid, comparator); // sort left half
        mergeSort(array, mid + 1, toIndex, comparator); // sort right half
        merge(array, fromIndex, mid, toIndex, comparator); //merge the two parts
    }

    private <T> void merge(T[] array, int start, int mid, int end, Comparator<T> comparator) {
        int firstHalfIndex = start;
        int secondHalfIndex = mid + 1;
        int resultIndex = start;

        while (firstHalfIndex <= mid && secondHalfIndex <= end) {
            if (comparator.compare(array[firstHalfIndex], array[secondHalfIndex]) < 0) { //first smaller
                auxArray[resultIndex++] = array[firstHalfIndex++];
            } else { //second smaller
                auxArray[resultIndex++] = array[secondHalfIndex++];
            }
        }

        while (firstHalfIndex <= mid) { //add remaining elements from left side
            auxArray[resultIndex++] = array[firstHalfIndex++];
        }

        while (secondHalfIndex <= end) { // add remaining elements from right side
            auxArray[resultIndex++] = array[secondHalfIndex++];
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(auxArray, start, array, start, end - start + 1);
    }

    @SuppressWarnings("unchecked")
    private Object[] growToNewSizeIfNeeded(Object[] array, int newSize) {
        if (newSize > array.length) {
            array = ARRAY_GROWER.growArrayTo(array, newSize);
        }
        return array;
    }
}
