package com.example.kt3;

public final class Task2RangeSum {
    private Task2RangeSum() {
    }

    public static long[] rangeSums(long[] nums, int[][] queries) {
        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        long[] result = new long[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = prefix[right + 1] - prefix[left];
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n];

        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }

        int q = scanner.nextInt();
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            output.append(prefix[right + 1] - prefix[left]).append('\n');
        }

        System.out.print(output);
    }
}
