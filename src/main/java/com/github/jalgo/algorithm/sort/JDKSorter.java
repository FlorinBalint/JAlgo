package com.github.jalgo.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;

public class JDKSorter implements Sorter {
    @Override
    public <T extends Comparable<T>> void sort(T[] values) {
        if (values != null) {
            Arrays.sort(values);
        }
    }

    @Override
    public <T> void sort(T[] values, Comparator<T> comparator) {
        if (values != null) {
            Arrays.sort(values, comparator);
        }
    }
}
