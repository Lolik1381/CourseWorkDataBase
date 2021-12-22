package ru.stankin.bd.factory;

import java.util.HashMap;
import java.util.Map;

public final class N1MaxFactory {

    private static final Map<Map<Long, Double>, Long> N1_MAX_MAP = new HashMap<>();

    static {
        N1_MAX_MAP.put(Map.of(20L, 12.7), 2780L);
        N1_MAX_MAP.put(Map.of(20L, 15.875), 2000L);
        N1_MAX_MAP.put(Map.of(20L, 19.05), 1520L);
        N1_MAX_MAP.put(Map.of(20L, 25.4), 1000L);
        N1_MAX_MAP.put(Map.of(20L, 31.75), 725L);
        N1_MAX_MAP.put(Map.of(20L, 38.1), 540L);
        N1_MAX_MAP.put(Map.of(20L, 44.45), 430L);
        N1_MAX_MAP.put(Map.of(20L, 50.8), 350L);

        N1_MAX_MAP.put(Map.of(25L, 12.7), 2780L);
        N1_MAX_MAP.put(Map.of(25L, 15.875), 2000L);
        N1_MAX_MAP.put(Map.of(25L, 19.05), 1520L);
        N1_MAX_MAP.put(Map.of(25L, 25.4), 1000L);
        N1_MAX_MAP.put(Map.of(25L, 31.75), 725L);
        N1_MAX_MAP.put(Map.of(25L, 38.1), 540L);
        N1_MAX_MAP.put(Map.of(25L, 44.45), 430L);
        N1_MAX_MAP.put(Map.of(25L, 50.8), 350L);

        N1_MAX_MAP.put(Map.of(30L, 12.7), 2780L);
        N1_MAX_MAP.put(Map.of(30L, 15.875), 2000L);
        N1_MAX_MAP.put(Map.of(30L, 19.05), 1520L);
        N1_MAX_MAP.put(Map.of(30L, 25.4), 1000L);
        N1_MAX_MAP.put(Map.of(30L, 31.75), 725L);
        N1_MAX_MAP.put(Map.of(30L, 38.1), 540L);
        N1_MAX_MAP.put(Map.of(30L, 44.45), 430L);
        N1_MAX_MAP.put(Map.of(30L, 50.8), 350L);
    }

    public static Long getN1Max(Double t, Long z1) {
        double tn = nearest(t, 12.7, 15.875, 19.05, 25.4, 31.75, 38.1, 44.45, 50.8);
        long z1n = nearest(z1, 20, 25, 30).longValue();

        return N1_MAX_MAP.get(Map.of(z1n, tn));
    }

    static Double nearest(double n, double ... args) {
        double nearest = 0;
        double value = 2L * Integer.MAX_VALUE;
        for (double arg : args) {
            if (value > Math.abs(n - arg)){
                value = Math.abs(n - arg);
                nearest = arg;
            }
        }

        return nearest;
    }
}