package com.rishi.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortedList<T> {
    ArrayList<T> sortedList = new ArrayList<T>();
    Comparator<T> comparator;

    public SortedList(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public T[] getArray(T[] a) {
        return sortedList.toArray(a);
    }

    public void add(T value) {
        int index = Collections.binarySearch(sortedList, value, comparator);

        if (index < 0) {
            index = -(index + 1);
        }
        sortedList.add(index, value);
    }
}
