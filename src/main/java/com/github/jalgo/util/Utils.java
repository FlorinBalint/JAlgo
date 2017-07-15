package com.github.jalgo.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {

    public static <T> T max(T firstVal, T secondVal, Comparator<T> comparator) {
        return comparator.compare(firstVal, secondVal) >= 0 ? firstVal : secondVal;
    }

    public static <T extends Comparable<T>> T max(T firstVal, T secVal) {
        return max(firstVal, secVal, Comparable::compareTo);
    }

    public static <T> T min(T firstVal, T secondVal, Comparator<T> comparator) {
        return comparator.compare(firstVal, secondVal) <= 0 ? firstVal : secondVal;
    }

    public static <T extends Comparable<T>> T min(T firstVal, T secondVal) {
        return min(firstVal, secondVal, Comparable::compareTo);
    }

}
