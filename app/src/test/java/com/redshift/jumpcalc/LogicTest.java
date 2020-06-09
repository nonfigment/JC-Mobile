package com.redshift.jumpcalc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicTest extends Logic {

    private void makeTest(String s1Name, float s1Range, String s2Name, float s2Range, float dist) {
        Ship ship1 = new Ship();
        ship1.name = s1Name;
        ship1.range = s1Range;
        Ship ship2 = new Ship();
        ship2.name = s2Name;
        ship2.range = s2Range;

        Logic logic = new Logic();
        logic.calc(dist, ship1, ship2);
        System.out.printf("%s route time: %s%n", ship1.name, Util.timeFormatter(ship1.routeTime));
        System.out.printf("%s route time: %s%n", ship2.name, Util.timeFormatter(ship2.routeTime));
    }

    @Test
    void testCalc() {
        makeTest("Dwarf 10", 10, "Carrier 500", 500, 350);
    }

    @Test
    void testBigValueCalc() {
        makeTest("Alpha", 30, "Carrier 200", 200, 5400);
    }

    @Test
    void testExtremeRoute() {
        makeTest("DBE", 17, "Carrier 100", 100, 16700);
    }

}
