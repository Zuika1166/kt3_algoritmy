package com.example.kt3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AlgorithmsTest {
    @Test
    void lowerBoundWorksWithDuplicatesAndEmptyArray() {
        assertEquals(1, Task1LowerBound.lowerBound(new int[]{1, 2, 2, 2, 5}, 2));
        assertEquals(4, Task1LowerBound.lowerBound(new int[]{1, 2, 2, 2, 5}, 4));
        assertEquals(0, Task1LowerBound.lowerBound(new int[]{}, 10));
    }

    @Test
    void rangeSumsHandleNegativeValues() {
        long[] result = Task2RangeSum.rangeSums(
            new long[]{5, -2, 7, 3},
            new int[][]{{0, 1}, {1, 3}, {2, 2}}
        );

        assertArrayEquals(new long[]{3, 8, 7}, result);
    }

    @Test
    void mergeIntervalsMergesOverlapsAndSharedBorders() {
        List<Task3MergeIntervals.Interval> result = Task3MergeIntervals.merge(
            new long[][]{{1, 3}, {3, 5}, {8, 10}, {9, 12}, {20, 20}}
        );

        assertEquals(
            List.of(
                new Task3MergeIntervals.Interval(1, 5),
                new Task3MergeIntervals.Interval(8, 12),
                new Task3MergeIntervals.Interval(20, 20)
            ),
            result
        );
    }

    @Test
    void shipCapacityFindsMinimum() {
        assertEquals(
            15,
            Task4ShipCapacity.minCapacity(
                new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                5
            )
        );

        assertEquals(
            6,
            Task4ShipCapacity.minCapacity(
                new long[]{3, 2, 2, 4, 1, 4},
                3
            )
        );
    }

    @Test
    void subarraySumHandlesNegativeValuesAndZero() {
        assertEquals(
            2,
            Task5SubarraySum.countSubarrays(new long[]{1, 1, 1}, 2)
        );

        assertEquals(
            3,
            Task5SubarraySum.countSubarrays(new long[]{1, -1, 0}, 0)
        );
    }

    @Test
    void meetingRoomsRespectHalfOpenIntervals() {
        assertEquals(
            2,
            Task6MeetingRooms.minRooms(
                new long[][]{{0, 30}, {5, 10}, {15, 20}}
            )
        );

        assertEquals(
            1,
            Task6MeetingRooms.minRooms(
                new long[][]{{7, 10}, {10, 12}}
            )
        );

        assertEquals(0, Task6MeetingRooms.minRooms(new long[][]{}));
    }
}
