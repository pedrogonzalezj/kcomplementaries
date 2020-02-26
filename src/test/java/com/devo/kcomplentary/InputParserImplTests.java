package com.devo.kcomplentary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class InputParserImplTests {

    private InputParser parser;

    @BeforeEach
    public void setup() {
        parser = new InputParserImpl();
    }

    @Test
    @DisplayName("valid input must be parsed")
    public void assertThatCanParseValidInput() {
        Integer[] values = {12, 54, 65, 7};
        assertArrayEquals(values, parser.parse("12 54 65 7 "));
        assertArrayEquals(values, parser.parse("12 54 65 7"));
        assertArrayEquals(values, parser.parse("12 54 65 7\\n"));
    }

    @Test
    @DisplayName("invalid input causes empty results")
    public void assertThatInvalidInputCausesEmptyArray() {
        Integer[] values = {};
        assertArrayEquals(values, parser.parse("some word"));
    }

    @Test
    @DisplayName("invalid data is ignored")
    public void assertThatInvalidDataIsIgnored() {
        Integer[] values = {12,65,7};
        assertArrayEquals(values, parser.parse("12 h 65 7"));
    }
}
