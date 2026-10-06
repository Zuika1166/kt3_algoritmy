package com.example.kt3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public final class Task6MeetingRooms {
    private Task6MeetingRooms() {
    }

    public static int minRooms(long[][] meetings) {
        if (meetings.length == 0) {
            return 0;
        }

        long[][] sorted = Arrays.stream(meetings)
            .map(long[]::clone)
            .toArray(long[][]::new);

        Arrays.sort(sorted, Comparator
            .comparingLong((long[] meeting) -> meeting[0])
            .thenComparingLong(meeting -> meeting[1]));

        PriorityQueue<Long> endTimes = new PriorityQueue<>();
        int maxRooms = 0;

        for (long[] meeting : sorted) {
            while (!endTimes.isEmpty() && endTimes.peek() <= meeting[0]) {
                endTimes.poll();
            }

            endTimes.add(meeting[1]);
            maxRooms = Math.max(maxRooms, endTimes.size());
        }

        return maxRooms;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[][] meetings = new long[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = scanner.nextLong();
            meetings[i][1] = scanner.nextLong();
        }

        System.out.println(minRooms(meetings));
    }
}
