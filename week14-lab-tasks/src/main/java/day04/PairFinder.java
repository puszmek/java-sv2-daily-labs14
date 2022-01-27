package day04;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class PairFinder {

    public static int findPairs(int[] arr) {
        Map<Integer, Integer> pairs = new TreeMap<>();
        for (Integer actual : arr) {
            if (!pairs.containsKey(actual)) {
                pairs.put(actual, 1);
            } else {
                pairs.put(actual, pairs.get(actual) + 1);
            }
        }
        return pairs.values().stream()
                .mapToInt(i -> i / 2)
                .sum();
    }

    public static int findPairsB(int[] arr) {
        int[] result = Arrays.copyOf(arr, arr.length);
        Arrays.sort(result);
        int count = 0;
        for (int i = 1; i < result.length; i++) {
            if (result[i] == result[i - 1]) {
                count++;
                i++;
            }
        }
        return count;
    }
}
