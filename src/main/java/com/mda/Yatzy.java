package com.mda;

import java.util.Arrays;

/**
 * The class get the score of a yatzy game.
 */
public class Yatzy {

    public static final int DIE_MAX = 6;
    public static final int DIE_MIN = 1;
    /**
     * This table of int represent the game.
     */
    private final int[] dice;

    /**
     * private constructor
     * @param d1 int die 1
     * @param d2 int die 2
     * @param d3 int die 3
     * @param d4 int die 4
     * @param d5 int die 5
     */
    private Yatzy(int d1, int d2, int d3, int d4, int d5) {
        this.dice = new int[]{d1,d2,d3,d4,d5};
    }

    /**
     * Factory method that verify validity of each die before the construction of the game
     * @param d1 int die 1
     * @param d2 int die 2
     * @param d3 int die 3
     * @param d4 int die 4
     * @param d5 int die 5
     * @return Yatzy that represent the game
     */
    public static Yatzy of(int d1, int d2, int d3, int d4, int d5){
        boolean allValid = (d1 <= DIE_MAX && d1 >= DIE_MIN)
                && (d2 <= DIE_MAX && d2 >= DIE_MIN)
                && (d3 <= DIE_MAX && d3 >= DIE_MIN)
                && (d4 <= DIE_MAX && d4 >= DIE_MIN)
                && (d5 <= DIE_MAX && d5 >= DIE_MIN) ;
        if (allValid) {
            return new Yatzy(d1, d2, d3, d4, d5);
        }
        throw new IllegalArgumentException("All the dice must be between "+DIE_MIN+" and "
                +DIE_MAX+"; your dice: " +
                d1 + ", " + d2 + ", " + d3 + ", " + d4 + ", " + d5 + "." );
    }

    /**
     * In the category chance the score is the sum of all die
     * @return the score
     */
    public int chance()
    {
        return Arrays.stream(dice).sum();
    }

    /**
     * In the category yatzy the score is 50 if all dice are equals, 0 otherwise
     * @return the score
     */
    public int yatzy()
    {
        int first = dice[0];
        boolean anyDifference = Arrays.stream(dice).anyMatch(die -> die != first);
        return anyDifference ? 0 : 50;
    }

    /**
     * Return the sum of dice equals to the reference
     * @param ref int the reference
     * @return the score
     */
    private int sumIfValuesEqualsRef(int ref){
        return Arrays.stream(dice).filter(die -> die == ref).sum();
    }

    /**
     * In the ones category the score is the sum of all die equals to 1
     * @return the score
     */
    public int ones() {
        return sumIfValuesEqualsRef(1);
    }

    /**
     * In the twos category the score is the sum of all dice equals to 2
     * @return the score
     */
    public int twos() {
        return sumIfValuesEqualsRef(2);
    }

    /**
     * In the twos category the score is the sum of all dice equals to 3
     * @return the score
     */
    public int threes() {
        return sumIfValuesEqualsRef(3);
    }

    /**
     * In the twos category the score is the sum of all dice equals to 4
     * @return the score
     */
    public int fours()
    {
        return sumIfValuesEqualsRef(4);
    }

    /**
     * In the twos category the score is the sum of all dice equals to 5
     * @return the score
     */
    public int fives()
    {
        return sumIfValuesEqualsRef(5);
    }

    /**
     * In the twos category the score is the sum of all dice equals to 6
     * @return the score
     */
    public int sixes()
    {
        return sumIfValuesEqualsRef(6);
    }

    /**
     * Sum the larger group of equal dice by the number of iteration
     * @param it the number rof iteration
     * @return the score
     */
    private int sumByNumberOfIterations(int it){
        int[] counts = getCounts();
        for (int at = DIE_MAX; at >= DIE_MIN; at--) {
            if (counts[at-1] >= it) {
                return (at) * it;
            }
        }
        return 0;
    }

    /**
     * In pair category, the score is the sum of the larger pair, 0 if no pair
     * @return the score
     */
    public int scorePair()
    {
        return sumByNumberOfIterations(2);
    }

    /**
     * In two pair category, the score is the sum of the two pairs, 0 if there is 1 or no pair
     * @return the score
     */
    public int twoPairs()
    {
        int[] counts = getCounts();
        if (Arrays.stream(counts).filter(count-> count >= 2).count() < 2)
            return 0;
        return Arrays.stream(dice).map(die -> counts[die-1] >= 2 ? die : 0).sum();
    }

    /**
     * This method count iterations of each die
     *
     * @return a table of all iteration
     */
    private int[] getCounts() {
        int[] counts = new int[]{0,0,0,0,0,0};
        for (int die : dice) {
            counts[die - 1]++;
        }
        return counts;
    }

    /**
     * In four of a kind category, the score is the sum of all 4 dice of a kind,
     * 0 there is not 4 dices of a kind
     * @return the score
     */
    public int fourOfAKind()
    {
        return sumByNumberOfIterations( 4);
    }

    /**
     * In three of a kind category, the score is the sum of all 3 dice of a kind,
     * 0 there is not triplet of the same die
     * @return the score
     */
    public int threeOfAKind()
    {
        return sumByNumberOfIterations( 3);
    }

    /**
     * Check if all integers between 2 parameters are presents
     * @param start int the lower limit
     * @param end int the upper limit
     * @return the result
     */
    private boolean checkStraightBetween(int start, int end){
        return Arrays.stream(dice).allMatch(die -> die >= start && die <= end);
    }

    /**
     * In the small straight category the score is 15 is the dice contains 1, 2, 3, 4 and 5, 0 otherwise
     * @return the score
     */
    public int smallStraight()
    {
        return checkStraightBetween(1, 5) ? 15 : 0;
    }

    /**
     * In the large straight category the score is 20 is the dice contains 2, 3, 4, 5 and 6, 0 otherwise
     * @return the score
     */
    public int largeStraight()
    {
        return checkStraightBetween(2, 6) ? 20 : 0;
    }

    /**
     * In the full house category, if the dice are two of a kind and three of a kind,
     * the score the sum of all the dice, otherwise the score is 0
     * @return the score
     */
    public int fullHouse()
    {
        int[] tallies = getCounts();
        if (Arrays.stream(tallies).noneMatch(count -> count == 3)
                || Arrays.stream(tallies).noneMatch(count -> count == 2))
            return 0;

        return Arrays.stream(dice).sum();
    }
}