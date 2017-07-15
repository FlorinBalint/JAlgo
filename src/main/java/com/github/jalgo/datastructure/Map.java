package com.github.jalgo.datastructure;

import java.util.Collection;
import java.util.Set;

public interface Map<K, V> { //todo add multiple hashing techniques & implementations

    int size();

    boolean isEmpty();

    boolean containsKey(Object var1);

    V get(Object var1);

    V put(K var1, V var2);

    V remove(Object var1);

    default void putAll(Map<? extends K, ? extends V> var1) {
        for (Entry<? extends K, ? extends V> entry : var1.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    void clear();

    Set<K> keySet();

    Collection<V> values();

    Set<Map.Entry<K, V>> entrySet();

    boolean equals(Object var1);

    int hashCode();

    interface Entry<K, V> {

        K getKey();

        V getValue();

        V setValue(V var1);

        boolean equals(Object var1);

        int hashCode();
    }
}
