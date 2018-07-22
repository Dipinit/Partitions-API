package com.adneom.lib;

/**
 * This class contains utility functions to manipulate partitions.
 * Is compatible with older Java versions (Tested from 1.3)
 *
 * @author Boris B.
 */
public class Partitions {

    /**
     * Splits an int array into an array of int arrays whose length is defined
     * by the given size and returns it.
     *
     * @param partition Array to split
     * @param size Defines the size of the inner array(s)
     * @throws IllegalArgumentException If partition is null or size < 1
     * @return Array of sub arrays
     */
    public static int[][] getSplitPartition(int[] partition, int size) {
        if (partition == null) {
            throw new IllegalArgumentException("Cannot split partition if input partition is null");
        } else if (size < 1) {
            throw new IllegalArgumentException("Cannot split partition if size < 1");
        } else if (size >= partition.length) {
            return new int[][]{partition};
        }

        final int resultArraySize = partition.length / size + (partition.length % size != 0 ? 1 : 0);
        int[][] result = new int[resultArraySize][];

        for (int i = 0; i < resultArraySize; i++) {
            int innerArraySize = partition.length - i * size;
            if (innerArraySize >= size) {
                innerArraySize = size;
            }

            int[] innerArray = new int[innerArraySize];

            for (int j = 0; j < innerArraySize; j++) {
                innerArray[j] = partition[j + (i * size)];
            }
            result[i] = innerArray;
        }

        return result;
    }
}
