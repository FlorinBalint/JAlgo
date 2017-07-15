package com.github.jalgo.algorithm.sort;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SorterTest {

    private static final int LARGE_ARRAY_SIZE = 10_000;

    @Parameterized.Parameters
    public static Collection<Object> sorters() {
        return Arrays.asList(
                new BubbleSorter(),
                new SelectionSorter(),
                new InsertionSorter(),
                new MergeSorter(),
                new HeapSorter(),
                new QuickSorter(),
                new JDKSorter()
        );
    }

    private Sorter sorter;

    public SorterTest(Sorter sorter) {
        this.sorter = sorter;
    }

    @Test
    public void sortedArrayRemainsTheSame() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Map<Integer, Integer> expectedCountMap = toCountMap(array);
        sorter.sort(array);
        assertOrdered(array);
        assertContainsSameElements(expectedCountMap, array);
    }

    @Test
    public void inverseSorted_SortsThemCorrectly() {
        Integer[] array = new Integer[]{7, 6, 5, 4, 3, 2, 1};
        Map<Integer, Integer> expectedCountMap = toCountMap(array);
        sorter.sort(array);
        assertOrdered(array);
        assertContainsSameElements(expectedCountMap, array);
    }

    @Test
    public void randomlyPositioned_SortsThemCorrectly() {
        Integer[] array = new Integer[]{4, 7, 3, 6, 2, 5, 1};
        Map<Integer, Integer> expectedCountMap = toCountMap(array);
        sorter.sort(array);
        assertOrdered(array);
        assertContainsSameElements(expectedCountMap, array);
    }


    @Test
    public void onlyOneValuesMultipleTimes_RemainsTheSame() {
        Integer[] array = new Integer[]{2, 2, 2, 2, 2, 2, 2};
        Map<Integer, Integer> expectedCountMap = toCountMap(array);
        sorter.sort(array);
        assertOrdered(array);
        assertContainsSameElements(expectedCountMap, array);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void nullArray_ExpectedNull() {
        Integer[] array = null;
        sorter.sort(array);
        assertNull(array);
    }

    @Test
    public void duplicatedValues_SortsThemCorrectly() {
        Integer[] array = new Integer[]{7, 6, 7, 6, 6, 5, 4, 5, 3, 3, 2, 1, 1};
        Map<Integer, Integer> expectedCountMap = toCountMap(array);
        sorter.sort(array);
        assertOrdered(array);
        assertContainsSameElements(expectedCountMap, array);
    }

    @Test
    public void largerArray_SortsThemCorrectly() {
        Integer[] array = new Integer[LARGE_ARRAY_SIZE];
        Random randomizer = new Random();
        for (int i = 0; i < LARGE_ARRAY_SIZE; i++) {
            array[i] = randomizer.nextInt();
        }
        Map<Integer, Integer> expectedCountMap = toCountMap(array);
        sorter.sort(array);
        assertOrdered(array);
        assertContainsSameElements(expectedCountMap, array);
    }

    private void assertOrdered(Integer[] actualValues) {
        for (int i = 0; i < actualValues.length - 1; i++) {
            assertTrue("Faulty sort !! " + actualValues[i] + " appears before " + actualValues[i + 1] + " in the resulting array !!",
                    actualValues[i] <= actualValues[i + 1]);
        }
    }

    private static void assertContainsSameElements(Map<Integer, Integer> expectedCountMap, Integer[] actualArray) {
        Map<Integer, Integer> actualCountMap = toCountMap(actualArray);
        assertEquals("The resulting array does not have the same elements as the input !", expectedCountMap, actualCountMap);
    }

    private static Map<Integer, Integer> toCountMap(Integer[] array) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Integer val : array) {
            Integer currentCount = countMap.get(val);
            if (currentCount != null) {
                countMap.put(val, currentCount + 1);
            } else {
                countMap.put(val, 1);
            }
        }

        return countMap;
    }

}
