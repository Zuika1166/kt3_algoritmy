package com.example.kt3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class Task3MergeIntervals {
    private Task3MergeIntervals() {
    }

    public record Interval(long start, long end) {
    }

    public static List<Interval> merge(long[][] intervals) {
        if (intervals.length == 0) {
            return List.of();
        }

        long[][] sorted = Arrays.stream(intervals)
            .map(long[]::clone)
            .toArray(long[][]::new);

        Arrays.sort(sorted, Comparator
            .comparingLong((long[] interval) -> interval[0])
            .thenComparingLong(interval -> interval[1]));

        List<Interval> result = new ArrayList<>();
        long currentStart = sorted[0][0];
        long currentEnd = sorted[0][1];

        for (int i = 1; i < sorted.length; i++) {
            long start = sorted[i][0];
            long end = sorted[i][1];

            if (start <= currentEnd) {
                currentEnd = Math.max(currentEnd, end);
            } else {
                result.add(new Interval(currentStart, currentEnd));
                currentStart = start;
                currentEnd = end;
            }
        }

        result.add(new Interval(currentStart, currentEnd));
        return result;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[][] intervals = new long[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextLong();
            intervals[i][1] = scanner.nextLong();
        }

        StringBuilder output = new StringBuilder();

        for (Interval interval : merge(intervals)) {
            output.append(interval.start())
                .append(' ')
                .append(interval.end())
                .append('\n');
        }

        System.out.print(output);
    }
}
