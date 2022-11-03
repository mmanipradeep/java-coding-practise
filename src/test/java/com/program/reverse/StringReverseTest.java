package com.program.reverse;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(JUnitParamsRunner.class)
public class StringReverseTest {

    private final StringReverse serviceUnderTest
            = new StringReverse();

    @Test
    @Parameters({
            "abc, cba",
            "abcde, edcba" })
    public void whenWithAnnotationProvidedParams_StringReverse(String input, String expectedValue) {
        assertEquals(expectedValue, serviceUnderTest.StringReversal(input));
    }

    @Test
    @Parameters({
            "abc123def456, abc321def654",
            "abc123def456, abc321def654" })
    public void whenWithAnnotationProvidedParams_AlphanumericReverse(String input, String expectedValue) {
        assertEquals(expectedValue, serviceUnderTest.AlphaNumericReverse(input));
    }



}
