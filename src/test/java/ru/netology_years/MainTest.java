package ru.netology_years;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void daysInYear() {
        //given
        int years = 2000;
        //when
        int tax = Main.daysInYear(years);
        //then
        Assertions.assertEquals(366, tax);
    }
}