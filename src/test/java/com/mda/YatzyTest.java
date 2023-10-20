package com.mda;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class YatzyTest {

    @Test
    public void given_2_3_4_5_1_when_chance_then_result_is_sum_of_all_faces_15(){
        Yatzy game = Yatzy.of(2,3,4,5,1);
        int result = game.chance();
        int expected = 15;
        assertEquals(expected, result, "The result should be 15");
    }

    @Test
    public void given_3_3_4_5_1_when_chance_then_result_is_sum_of_all_faces_30(){
        Yatzy game = Yatzy.of(3,3,4,5,1);
        int result = game.chance();
        int expected = 16;
        assertEquals(expected, result, "The result should be 16");
    }

    @Test
    public void given_only_6_when_chance_then_result_is_sum_of_all_faces_30(){
        Yatzy game = Yatzy.of(6,6,6,6,6);
        int result = game.chance();
        int expected = 30;
        assertEquals(expected, result, "The result should be 30");
    }

    @CsvSource(value = {"1,1,1,1,1", "2,2,2,2,2", "3,3,3,3,3", "4,4,4,4,4", "5,5,5,5,5", "6,6,6,6,6"},
            delimiter = ',')
    @ParameterizedTest
    public void given_all_same_when_yatzy_then_return_50(int d1, int d2, int d3, int d4, int d5) {
        Yatzy game = Yatzy.of(d1, d2, d3, d4, d5);
        int result = game.yatzy();
        int expected = 50;
        assertEquals(expected, result, "The result should be 50");
    }

    @CsvSource(value = {"6,1,1,1,1", "2,1,2,2,2", "3,3,1,3,3", "4,4,4,1,4", "5,5,5,1,5"},
            delimiter = ',')
    @ParameterizedTest
    public void given_5_identical_and_1_diff_when_yatzy_then_return_0(int d1, int d2, int d3, int d4, int d5) {
        Yatzy game = Yatzy.of(d1, d2, d3, d4, d5);
        int result = game.yatzy();
        int expected = 0;
        assertEquals(expected, result, "The result should be 50");
    }

    @Test
    void given_1_2_3_4_5_when_ones_then_return_sum_all_ones_1(){
        Yatzy game = Yatzy.of(1,2,3,4,5);
        int result = game.ones();
        int expected = 1;
        assertEquals(expected, result, "The result should be 1");
    }
    @Test
    void given_1_2_1_4_1_when_ones_then_return_sum_all_ones_3(){
        Yatzy game = Yatzy.of(1,2,1,4,1);
        int result = game.ones();
        int expected = 3;
        assertEquals(expected, result, "The result should be 3");
    }
    @Test
    void given_none_1_when_ones_then_return_0(){
        Yatzy game = Yatzy.of(2,2,3,4,5);
        int result = game.ones();
        int expected = 0;
        assertEquals(expected, result, "The result should be 0");
    }

    @Test
    void given_1_2_3_4_5_when_twos_then_return_sum_all_twos_2(){
        Yatzy game = Yatzy.of(1,2,3,4,5);
        int result = game.twos();
        int expected = 2;
        assertEquals(expected, result, "The result should be 2");
    }
    @Test
    void given_1_2_2_2_1_when_twos_then_return_sum_all_twos_6(){
        Yatzy game = Yatzy.of(1,2,2,2,5);
        int result = game.twos();
        int expected = 6;
        assertEquals(expected, result, "The result should be 6");
    }
    @Test
    void given_none_2_when_twos_then_return_0(){
        Yatzy game = Yatzy.of(1,1,3,4,5);
        int result = game.twos();
        int expected = 0;
        assertEquals(expected, result, "The result should be 0");
    }

    @Test
    void given_1_2_3_4_5_when_threes_then_return_sum_all_threes_3(){
        Yatzy game = Yatzy.of(1,2,3,4,5);
        int result = game.threes();
        int expected = 3;
        assertEquals(expected, result, "The result should be 3");
    }
    @Test
    void given_1_3_3_3_1_when_threes_then_return_sum_all_threes_9(){
        Yatzy game = Yatzy.of(1,3,3,3,5);
        int result = game.threes();
        int expected = 9;
        assertEquals(expected, result, "The result should be 9");
    }
    @Test
    void given_none_3_when_threes_then_return_0(){
        Yatzy game = Yatzy.of(1,1,2,4,5);
        int result = game.threes();
        int expected = 0;
        assertEquals(expected, result, "The result should be 0");
    }

    @Test
    void given_1_2_3_4_5_when_fours_then_return_sum_all_fours_4(){
        Yatzy game = Yatzy.of(1,2,3,4,5);
        int result = game.fours();
        int expected = 4;
        assertEquals(expected, result, "The result should be 4");
    }
    @Test
    void given_1_3_3_4_4_when_fours_then_return_sum_all_fours_8(){
        Yatzy game = Yatzy.of(1,3,3,4,4);
        int result = game.fours();
        int expected = 8;
        assertEquals(expected, result, "The result should be 8");
    }
    @Test
    void given_none_8_when_fours_then_return_0(){
        Yatzy game = Yatzy.of(1,1,2,3,5);
        int result = game.fours();
        int expected = 0;
        assertEquals(expected, result, "The result should be 0");
    }

    @Test
    void given_1_2_3_4_5_when_fives_then_return_sum_all_fives_5(){
        Yatzy game = Yatzy.of(1,2,3,4,5);
        int result = game.fives();
        int expected = 5;
        assertEquals(expected, result, "The result should be 5");
    }
    @Test
    void given_5_5_3_4_4_when_fives_then_return_sum_all_fives_10(){
        Yatzy game = Yatzy.of(5,5,3,4,4);
        int result = game.fives();
        int expected = 10;
        assertEquals(expected, result, "The result should be 10");
    }
    @Test
    void given_none_5_when_fives_then_return_0(){
        Yatzy game = Yatzy.of(1,1,2,3,6);
        int result = game.fives();
        int expected = 0;
        assertEquals(expected, result, "The result should be 0");
    }

    @Test
    void given_1_2_3_4_6_when_sixes_then_return_sum_all_sixes_6(){
        Yatzy game = Yatzy.of(1,2,3,4,6);
        int result = game.sixes();
        int expected = 6;
        assertEquals(expected, result, "The result should be 6");
    }
    @Test
    void given_1_3_6_6_6_when_sixes_then_return_sum_all_sixes_18(){
        Yatzy game = Yatzy.of(1,3,6,6,6);
        int result = game.sixes();
        int expected = 18;
        assertEquals(expected, result, "The result should be 18");
    }
    @Test
    void given_none_6_when_sixes_then_return_0(){
        Yatzy game = Yatzy.of(1,1,2,3,5);
        int result = game.sixes();
        int expected = 0;
        assertEquals(expected, result, "The result should be 0");
    }

    @Test
    public void given_one_pair_when_scorePair_then_sum_the_pair() {
        Yatzy game = Yatzy.of(3,4,3,5,6);
        int result = game.scorePair();
        int expected = 6;
        assertEquals(expected, result, "The result should be 6");
    }

    @Test
    public void given_none_pair_when_scorePair_then_return_O() {
        Yatzy game = Yatzy.of(1,4,3,5,6);
        int result = game.scorePair();
        int expected = 0;
        assertEquals(expected, result, "The result should be " + expected);
    }
    @ParameterizedTest
    @CsvSource(value = {"5,3,3,3,5,10", "5,3,6,6,5,12"})
    public void given_two_pairs_when_scorePair_then_return_the_sum_of_the_larger_pair(int d1, int d2, int d3, int d4, int d5, int expected) {
        Yatzy game = Yatzy.of(d1, d2, d3, d4, d5);
        int result = game.scorePair();
        assertEquals(expected, result, "The result should be " + expected);
    }

    @Test
    public void given_two_pairs_when_twoPairs_then_sum_pairs_values() {
        Yatzy game = Yatzy.of(3,3,5,4,5);
        int result = game.twoPairs();
        int expected = 16;
        assertEquals(expected, result, "The result should be " + expected);
    }

    @Test
    public void given_no_pair_when_twoPairs_then_zero() {
        Yatzy game = Yatzy.of(3,4,1,5,6);
        int result = game.twoPairs();
        int expected = 0;
        assertEquals(expected, result, "The result should be " + expected);
    }

    @Test
    public void given_only_one_pair_when_twoPairs_then_0() {
        Yatzy game = Yatzy.of(3,3,1,5,6);
        int result = game.twoPairs();
        int expected = 0;
        assertEquals(expected, result, "The result should be " + expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3,3,4,5,9", "5,3,5,4,5,15", "3,3,3,3,5,9"})
    public void given_one_triplet_when_threeOfAKind_then_sum_all_die_of_the_triplet(int d1, int d2, int d3, int d4, int d5, int expected)
    {
        Yatzy game = Yatzy.of(d1, d2, d3, d4, d5);
        int result = game.threeOfAKind();
        assertEquals(expected, result, "The result should be " + expected);
    }
    @Test
    public void given_five_different_dice_when_threeOfAKind_then_0()
    {
        Yatzy game = Yatzy.of(1,2,3,4,5);
        int result = game.threeOfAKind();
        int expected = 0;
        assertEquals(expected, result, "The result should be " + expected);
    }

    @Test
    public void given_five_different_dice_when_fourOfAKind_then_0() {
        Yatzy game = Yatzy.of(1,2,3,4,5);
        int result = game.fourOfAKind();
        int expected = 0;
        assertEquals(expected, result, "The result should be " + expected);
    }

    @Test
    public void given_1_2_3_4_5_when_smallStraight_then_15() {
        Yatzy game = Yatzy.of(1,2,3,4,5);
        int result = game.smallStraight();
        int expected = 15;
        assertEquals(expected, result, "The result should be " + expected);
    }
    @Test
    public void given_2_3_4_5_1_when_smallStraight_then_15() {
        Yatzy game = Yatzy.of(2,3,4,5,1);
        int result = game.smallStraight();
        int expected = 15;
        assertEquals(expected, result, "The result should be " + expected);
    }
    @Test
    public void given_2_3_4_5_6_when_smallStraight_then_0() {
        Yatzy game = Yatzy.of(2,3,4,5,6);
        int result = game.smallStraight();
        int expected = 0;
        assertEquals(expected, result, "The result should be " + expected);
    }

    @Test
    public void given_2_3_4_5_6_when_largeStraight_then_20() {
        Yatzy game = Yatzy.of(2,3,4,5,6);
        int result = game.largeStraight();
        int expected = 20;
        assertEquals(expected, result, "The result should be " + expected);
    }
    @Test
    public void given_6_2_3_4_5_when_largeStraight_then_20() {
        Yatzy game = Yatzy.of(6,2,3,4,5);
        int result = game.largeStraight();
        int expected = 20;
        assertEquals(expected, result, "The result should be " + expected);
    }

    @Test
    public void given_1_2_3_4_5_when_largeStraight_then_0() {
        Yatzy game = Yatzy.of(1,2,3,4,5);
        int result = game.largeStraight();
        int expected = 0;
        assertEquals(expected, result, "The result should be " + expected);
    }

    @Test
    public void given_one_pair_and_one_triplet_when_fullHouse_then_sum_all() {
        Yatzy game = Yatzy.of(6,2,2,2,6);
        int result = game.fullHouse();
        int expected = 18;
        assertEquals(expected, result, "The result should be " + expected);
    }

    @Test
    public void given_none_pair_and_a_triplet_when_fullHouse_then_0() {
        Yatzy game = Yatzy.of(1,2,2,2,6);
        int result = game.fullHouse();
        int expected = 0;
        assertEquals(expected, result, "The result should be " + expected);
    }
    @Test
    public void given_one_pair_and_no_three_different_when_fullHouse_then_0() {
        Yatzy game = Yatzy.of(6,2,1,2,6);
        int result = game.fullHouse();
        int expected = 0;
        assertEquals(expected, result, "The result should be " + expected);
    }
    @Test
    public void given_five_different_dice_when_fullHouse_then_0() {
        Yatzy game = Yatzy.of(1,2,3,4,6);
        int result = game.fullHouse();
        int expected = 0;
        assertEquals(expected, result, "The result should be " + expected);
    }

    @Test
    void given_value_smaller_than_1_when_of_then_throws_an_exception(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Yatzy.of(1, 0, 3, 4, 5));
        String expectedMsg = "All the dice must be between 1 and 6; your dice: 1, 0, 3, 4, 5.";
        assertEquals(expectedMsg, exception.getMessage());
    }
    @Test
    void given_value_larger_than_6_when_of_then_throws_an_exception(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Yatzy.of(1, 1, 31, 4, 5));
        String expectedMsg = "All the dice must be between 1 and 6; your dice: 1, 1, 31, 4, 5.";
        assertEquals(expectedMsg, exception.getMessage());
    }

}
