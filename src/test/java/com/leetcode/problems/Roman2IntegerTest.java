package com.leetcode.problems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Roman2IntegerTest {

    @Test
    void romanToInt() {
        Roman2Integer r2i = new Roman2Integer();

        assertEquals(r2i.romanToInt("I"), 1);
        assertEquals(r2i.romanToInt("III"), 3);
        assertEquals(r2i.romanToInt("XII"), 12);
        assertEquals(r2i.romanToInt("LVIII"), 58);
        assertEquals(r2i.romanToInt("XXVII"), 27);
        assertEquals(r2i.romanToInt("MCMXCIV"), 1994);

        assertEquals(r2i.romanToInt("XLIX"), 49);
        assertEquals(r2i.romanToInt("XLV"), 45);
        assertEquals(r2i.romanToInt("XCIX"), 99);

    }
}