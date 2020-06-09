package com.redshift.jumpcalc;

public class Logic {

    static final float FSD_CHARGE = 10;
    static final float FSD_SAFECOOLING = 10;
    static final float FSD_JUMPTIME = 15;
    static final float FSD_SUM = FSD_CHARGE + FSD_JUMPTIME + FSD_SAFECOOLING;
    static final float REFUELBASE = 60;
    static final float ESCAPEROUTE = 15;
    //TODO: randomness factor?
    static final float DELAYBASE = FSD_SUM + REFUELBASE + ESCAPEROUTE;

    public void calc(float distance, int jumpscount, Ship ship1, Ship ship2) {

        ship1.routeTime = (int) (jumpscount * DELAYBASE * distance / ship1.range);
        ship2.routeTime = (int) (jumpscount * DELAYBASE * distance / ship2.range);

    }
}


