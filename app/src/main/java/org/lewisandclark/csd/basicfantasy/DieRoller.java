package org.lewisandclark.csd.basicfantasy;

import java.util.Random;

/**
 * Created by Thorin Schmidt on 3/5/2018.
 * copied mostly from the Mazes and Minotaurs prjoject
 * methods originallyu by Thorin Schmidt and Justin Smith.
 *
 * "statroll" method written by Thorin Schmidt
 */

public class DieRoller {
    private static Random sRandom;

    public static int statRoll(){

        return d6() + d6() + d6();
    }

    /**
     * "Rolls a die" with specified number of sides, once.
     * @param sides number of sides of the die
     * @return the roll
     */
    public static int roll(int sides) {
        if (sRandom == null) {
            sRandom = new Random();
        }

        return sRandom.nextInt(sides) + 1;
    }

    /**
     * "Rolls a die" with specified number of sides, the specified number of rolls
     * @param sides number of sides of the die
     * @param rolls how times to roll the die
     *
     * @return the sum of the rolls
     */
    public static int roll(int sides, int rolls) {
        int sum = 0;
        for (int i = 0; i < rolls; i++) {
            sum += roll(sides);
        }
        return sum;
    }

    /**
     * "Rolls a d20" once.
     *
     * @return the roll
     */
    public static int d20() {
        if (sRandom == null) {
            sRandom = new Random();
        }

        return sRandom.nextInt(20) + 1;
    }

    /**
     * "Rolls a d20" 'rolls' number of times.
     * @param rolls
     * @return the sum of all rolls
     */
    public static int d20(int rolls) {
        int sum = 0;
        for (int i = 0; i < rolls; i++) {
            sum += d20();
        }
        return sum;
    }

    /**
     * "Rolls a d6" once.
     *
     * @return the roll
     */
    public static int d6() {
        if (sRandom == null) {
            sRandom = new Random();
        }

        return sRandom.nextInt(6) + 1;
    }

    /**
     * "Rolls a d6" 'rolls' number of times.
     * @param rolls
     * @return the sum of all rolls
     */
    public static int d6(int rolls) {
        int sum = 0;
        for (int i = 0; i < rolls; i++) {
            sum += d6();
        }
        return sum;
    }
}
