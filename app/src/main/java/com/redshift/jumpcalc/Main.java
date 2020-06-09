package com.redshift.jumpcalc;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {


    public static void main(String[] args) {

        Ship ship1 = new Ship();
        Ship ship2 = new Ship();

        float distance;
        int jumpscount;

        Input inputManager = new Input();

        System.out.println("Enter first ship params");
        inputManager.readShipParams(ship1);

        System.out.println("Enter second ship params");
        inputManager.readShipParams(ship2);

        distance = inputManager.readDistance();
        jumpscount = inputManager.readJumpsCount();

        Logic logic = new Logic();
        logic.calc(distance, jumpscount, ship1, ship2);

        System.out.printf("%s route time: %s%n", ship1.name, Util.timeFormatter(ship1.routeTime));
        System.out.printf("%s route time: %s%n", ship2.name, Util.timeFormatter(ship2.routeTime));


    }

}
