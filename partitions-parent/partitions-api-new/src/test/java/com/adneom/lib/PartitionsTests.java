package com.adneom.lib;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

public class PartitionsTests {
    private static final List<Integer> TEST_ARRAY = Arrays.asList(1,2,3,4,5,6,7,8,9);

    @Test
    public void size_greater_or_equal_than_array() {
        List<List<Integer>> result = Partitions.getSplitPartition(TEST_ARRAY, TEST_ARRAY.size() + 1);
        List<List<Integer>> expected = Collections.singletonList(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));


        assertTrue("Returned array should be the same as the one input. However result is "
                        + Arrays.deepToString(result.toArray()) + " but should be " + Arrays.deepToString(expected.toArray())
                , Objects.equals(expected, result));
    }

    @Test
    public void even_size_lower_than_array() {
        List<List<Integer>> result = Partitions.getSplitPartition(TEST_ARRAY, 2);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(3,4),
                Arrays.asList(5,6),
                Arrays.asList(7,8),
                Collections.singletonList(9));

        assertTrue("Result is "
                        + Arrays.deepToString(result.toArray()) + " but should be " + Arrays.deepToString(expected.toArray())
                , Objects.equals(expected, result));
    }

    @Test
    public void odd_size_lower_than_array() {
        List<List<Integer>> result = Partitions.getSplitPartition(TEST_ARRAY, 5);
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1,2,3,4,5),
                Arrays.asList(6,7,8,9));

        assertTrue("Result is "
                        + Arrays.deepToString(result.toArray()) + " but should be " + Arrays.deepToString(expected.toArray())
                , Objects.equals(expected, result));
    }

    @Test(expected = IllegalArgumentException.class)
    public void bad_arguments_partition_null() {
        Partitions.getSplitPartition(null, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void bad_arguments_size_invalid() {
        Partitions.getSplitPartition(TEST_ARRAY, 0);
    }
}
