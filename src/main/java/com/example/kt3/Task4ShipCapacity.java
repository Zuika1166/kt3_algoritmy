package com.example.kt3;

public final class Task4ShipCapacity {
    private Task4ShipCapacity() {
    }

    public static long minCapacity(long[] weights, int days) {
        long left = 0;
        long right = 0;

        for (long weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        while (left < right) {
            long middle = left + (right - left) / 2;

            if (canShip(weights, days, middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private static boolean canShip(long[] weights, int days, long capacity) {
        int usedDays = 1;
        long current = 0;

        for (long weight : weights) {
            if (current + weight > capacity) {
                usedDays++;
                current = 0;
            }

            current += weight;

            if (usedDays > days) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int days = scanner.nextInt();
        long[] weights = new long[n];

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextLong();
        }

        System.out.println(minCapacity(weights, days));
    }
}
