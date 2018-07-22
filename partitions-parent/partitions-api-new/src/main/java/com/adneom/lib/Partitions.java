package com.adneom.lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * This class contains utility functions to manipulate partitions.
 * Is compatible with newer Java versions (Starting at 1.8)
 *
 * @author Boris B.
 */
public class Partitions {

    /**
     * Splits a List of Integers into List of Integer Lists whose length is defined
     * by the given size and returns it.
     *
     * @param partition List to split
     * @param size Defines the size of the inner list(s)
     * @throws IllegalArgumentException If partition is null or size < 1
     * @return List of inner Integer Lists
     */
    public static List<List<Integer>> getSplitPartition(List<Integer> partition, int size) {
        if (partition == null) {
            throw new IllegalArgumentException("Cannot split partition if input partition is null");
        } else if (size < 1) {
            throw new IllegalArgumentException("Cannot split partition if size < 1");
        } else if (size >= partition.size()) {
            return Collections.singletonList(partition);
        }

        final AtomicInteger counter = new AtomicInteger(0);
        return new ArrayList<>(partition.stream()
                .collect(Collectors.groupingBy(iterator -> counter.getAndIncrement() / size))
                .values());

    }
}
