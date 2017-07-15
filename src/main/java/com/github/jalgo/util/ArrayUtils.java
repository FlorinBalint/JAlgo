package com.github.jalgo.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.function.BiFunction;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ArrayUtils {

    public static <T> void swap(T[] array, int indexFirst, int indexSecond) {
        T aux = array[indexFirst];
        array[indexFirst] = array[indexSecond];
        array[indexSecond] = aux;
    }

    public static <T> boolean contains(T[] array, T value) {
        return containsRange(array, 0, array.length - 1, value);
    }

    public static <T> boolean containsRange(T[] array, int fromIndex, int toIndex, T value) {
        boolean found = false;
        int index = fromIndex;
        toIndex = truncateToArraySize(toIndex, array);

        while (!found && index < toIndex) {
            found = array[index] == null ? value == null : array[index].equals(value);
            index++;
        }

        return found;
    }

    public static <T extends Comparable<T>> T min(T[] array) {
        return minOfRange(array, 0, array.length - 1);
    }

    public static <T extends Comparable<T>> T minOfRange(T[] array, int fromIndex, int toIndex) {
        return minOfRange(array, fromIndex, toIndex, Comparable::compareTo);
    }

    public static <T> T minOfRange(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
        return optimumOfRange(
                array,
                fromIndex, toIndex,
                (first, second) -> Utils.min(first, second, comparator)
        );
    }

    public static <T extends Comparable<T>> T max(T[] array) {
        return maxOfRange(array, 0, array.length - 1);
    }

    public static <T extends Comparable<T>> T maxOfRange(T[] array, int fromIndex, int toIndex) {
        return maxOfRange(array, fromIndex, toIndex, Comparable::compareTo);
    }

    public static <T> T maxOfRange(T[] array, int fromIndex, int toIndex, Comparator<T> comparator) {
        return optimumOfRange(
                array,
                fromIndex, toIndex,
                (first, second) -> Utils.max(first, second, comparator)
        );
    }


    private static <T> T optimumOfRange(T[] array, int fromIndex, int toIndex, BiFunction<T, T, T> compareFunction) {
        T currentOptimum = null;
        toIndex = truncateToArraySize(toIndex, array);

        for (int i = fromIndex; i <= toIndex; i++) {
            currentOptimum = compareFunction.apply(currentOptimum, array[i]);
        }

        return currentOptimum;
    }

    private static <T> int truncateToArraySize(int toIndex, T[] array) {
        return toIndex >= array.length ? (array.length - 1) : toIndex;
    }

}
