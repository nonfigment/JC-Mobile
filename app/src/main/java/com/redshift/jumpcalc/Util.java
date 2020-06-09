package com.redshift.jumpcalc;

public class Util {
    public static String timeFormatter(int sec) {
        int minutes = sec / 60;
        sec = sec % 60;
        /*if (minutes < 60){
            return String.format("%02d:%02d", minutes, sec);
        }*/

        int hours = minutes / 60;
        minutes = minutes % 60;
        if (hours < 24) {
            return String.format("%02d:%02d:%02d", hours, minutes, sec);
        }

        int days = hours / 24;
        hours = hours % 24;
        return String.format("%d d %02d:%02d:%02d", days, hours, minutes, sec);
    }
}
