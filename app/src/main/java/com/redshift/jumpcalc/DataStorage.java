package com.redshift.jumpcalc;

public class DataStorage {
    private static float distance;
    private static int jumpscount;

    public static float getDistance() {
        return distance;
    }

    public static void setDistance(float distance) {
        DataStorage.distance = distance;
    }

    public static int getJumpscount() {
        return jumpscount;
    }

    public static void setJumpscount(int jumpscount) {
        DataStorage.jumpscount = jumpscount;
    }
}
