package com.redshift.jumpcalc;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Input {

    private final InputStream inputStream = System.in;
    private final Reader inputStreamReader = new InputStreamReader(inputStream);
    private final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

    public void readShipParams(Ship ship) {

        ship.name = readString("Enter callsign or class: ");
        ship.range = readFloat(" Enter " + ship.name + " current LY range:");
    }

    public int readJumpsCount() {
        return readInt(" Enter the number of jumps according to galaxy map route builder");
    }

    public float readDistance() {
        return readFloat(" Enter the distance between ships according to galaxy map route builder: ");
    }

    private String readString(String description) {
        try {
            System.out.print(description);
            String readLine = bufferedReader.readLine();
            confirm();
            return readLine;
        } catch (Exception e) {
            error();
        }
        return readString(description);
    }

    private int readInt(String description) {
        try {
            System.out.println(description);
            String readLine = bufferedReader.readLine();
            int readInt = Integer.parseInt(readLine);
            confirm();
            return readInt;
        } catch (Exception e) {
            error();
        }
        return readInt(description);
    }

    private float readFloat(String description) {
        try {
            System.out.println(description);
            String readLine = bufferedReader.readLine();
            float readFloat = Float.parseFloat(readLine);
            confirm();
            return readFloat;
        } catch (Exception e) {
            error();
        }
        return readFloat(description);
    }

    public void confirm() {
        String c = ">>Confirmed";
        System.out.println(c);
    }

    public void error() {
        String e = "Error! Please, check the data you've provided";
        System.out.println(e);
    }

}
