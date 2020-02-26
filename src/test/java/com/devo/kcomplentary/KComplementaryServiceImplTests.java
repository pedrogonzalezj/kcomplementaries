package com.devo.kcomplentary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class KComplementaryServiceImplTests {

    private KComplementaryService service;

    @BeforeEach
    public void setup() {
        service = new KComplementaryServiceImpl();
    }

    @Test
    @DisplayName("complementary should be returned")
    public void assertThatReturnsComplementaryValues() {
        Integer[] numbers = {1,0,2,3,4,-1};
        Set<Pair> pairs = new HashSet<>();
        pairs.add(new Pair(0,2));
        pairs.add(new Pair(1,3));
        pairs.add(new Pair(4,5));
        assertEquals(pairs,service.getKComplementaries(numbers,3));
    }
}
