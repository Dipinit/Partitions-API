package com.adneom.lib;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class PartitionsTests {
    private static final int[] TEST_ARRAY = new int[]{1,2,3,4,5,6,7,8,9};

    @Test
    public void size_greater_or_equal_than_array() {
        int[][] result = Partitions.getSplitPartition(TEST_ARRAY, TEST_ARRAY.length + 1);
        int[][] expected = new int[][]{TEST_ARRAY};

        assertTrue("Returned array should be the same as the one input. However result is "
                        + Arrays.deepToString(result) + " but should be " + Arrays.deepToString(expected)
                        , Arrays.deepEquals(expected, result));
    }

    @Test
    public void even_size_lower_than_array() {
        int[][] result = Partitions.getSplitPartition(TEST_ARRAY, 2);
        int[][] expected = new int[][]{
                {1,2},{3,4},{5,6},{7,8},{9}
        };

        assertTrue("Result is "
                        + Arrays.deepToString(result) + " but should be " + Arrays.deepToString(expected)
                        , Arrays.deepEquals(expected, result));
    }

    @Test
    public void odd_size_lower_than_array() {
        int[][] result = Partitions.getSplitPartition(TEST_ARRAY, 5);
        int[][] expected = new int[][]{
                {1,2,3,4,5},{6,7,8,9}
        };

        assertTrue("Result is "
                        + Arrays.deepToString(result) + " but should be " + Arrays.deepToString(expected)
                        , Arrays.deepEquals(expected, result));
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
