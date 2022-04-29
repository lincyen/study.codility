package com.codility.app.exam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrListLenTest {

    @Test
    void solution() {
        assertEquals( new ArrListLen().solution(new int[]{1,4,-1,3,2,}), 4);
    }
}