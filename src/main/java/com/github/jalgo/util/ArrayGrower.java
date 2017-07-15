package com.github.jalgo.util;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.Array;

@RequiredArgsConstructor
public class ArrayGrower<T> {

    private static final double DEFAULT_GROWTH_RATE = 2.0d;

    private final Class<T> tClass;

    public T[] growArrayTo(T[] array, int newSize) {
        int oldSize = array.length;

        if (oldSize > newSize) {
            throw new IllegalArgumentException("Cannot grow an array to a smaller size !!");
        } else if (oldSize < newSize) {
            @SuppressWarnings("unchecked") T[] newArray = (T[]) Array.newInstance(tClass, newSize);
            System.arraycopy(array, 0, newArray, 0, oldSize);
            array = newArray;
        }

        return array;
    }

    public T[] growArrayByFactor(T[] array, double growthFactor) {
        int newSize = (int) Math.round(array.length * growthFactor);
        return growArrayTo(array, newSize);
    }

    public T[] growArray(T[] array) {
        return growArrayByFactor(array, DEFAULT_GROWTH_RATE);
    }
}
