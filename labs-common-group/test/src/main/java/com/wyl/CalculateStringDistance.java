package com.wyl;

/**
 * Created by wangyunlong on 17/5/20.
 */
public class CalculateStringDistance {
    public static void main(String[] args) {
        System.out.println(calculateStringDistance("cafe", "coffee"));

    }

    public static int calculateStringDistance(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return 0;
        }
        if (s1.isEmpty()) {
            return s2.length();
        }
        if (s2.isEmpty()) {
            return s1.length();
        }
        int[][] distance = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            distance[i][0] = i;
        }
        for (int i = 0; i <= s2.length(); i++) {
            distance[0][i] = i;
        }

        for (int i = 1; i <= s1.length(); i++) {
            char ci = s1.charAt(i - 1);
            for (int j = 1; j <= s2.length(); j++) {
                char cj = s2.charAt(j - 1);
                int cost = 0;
                if (ci == cj) {
                    cost = 0;
                } else {
                    cost = 1;
                }
                distance[i][j] = Math.min(distance[i - 1][j - 1] + cost, Math.min(distance[i - 1][j] + 1, distance[i][j - 1] + 1));
            }

        }
        return distance[s1.length()][s2.length()];
    }
}
