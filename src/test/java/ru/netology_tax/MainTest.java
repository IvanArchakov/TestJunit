package ru.netology_tax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MainTest {

    @ParameterizedTest
    @CsvSource(
            {
                    "200, 300",
                    "300, 200",
                    "300, 200"
            }
    )
    public void taxParameterized(int earnings, int spendings){
        int value = Main.taxEarningsMinusSpendings(earnings, spendings);
        assertThat(value, not(0));
    }

    @Test
    void taxEarnings() {
        int[] earnings = {300, 200, 50};
        for (int value : earnings) {
            int tax = Main.taxEarnings(value);
            assertThat(tax, allOf(greaterThan(0), lessThanOrEqualTo(100), not(equalTo(6))));;
        }
    }

    @Test
    void taxEarningsMinusSpendings() {
        //given
        int earnings = 200;
        int spendings = 300;
        //when
        int value = Main.taxEarningsMinusSpendings(earnings, spendings);
        //then
        Assertions.assertEquals(0, value);
    }

    @Test
    void testTaxEarnings() {
        //given
        int earnings = 200;
        //when
        int tax = Main.taxEarnings(earnings);
        //then
        Assertions.assertEquals(0, tax);
    }
}