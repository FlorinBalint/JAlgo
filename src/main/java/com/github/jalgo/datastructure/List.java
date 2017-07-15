package com.github.jalgo.datastructure;

import java.util.Collection;

public interface List<T> extends Collection<T> { //todo add different implementations

    T get(int index);

    T set(int index, T newValue);

    void add(int index, T value);

    T remove(int var1);

    int indexOf(Object var1);

    int lastIndexOf(Object var1);

}
