package com.example.kt3;

import java.util.HashMap;
import java.util.Map;

public final class Task5SubarraySum {
    private Task5SubarraySum() {
    }

    public static long countSubarrays(long[] nums, long k) {
        Map<Long, Long> frequencies = new HashMap<>();
        frequencies.put(0L, 1L);

        long prefix = 0;
        long count = 0;

        for (long num : nums) {
            prefix += num;
            count += frequencies.getOrDefault(prefix - k, 0L);
            frequencies.merge(prefix, 1L, Long::sum);
        }

        return count;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        long[] nums = new long[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }

        System.out.println(countSubarrays(nums, k));
    }
}
