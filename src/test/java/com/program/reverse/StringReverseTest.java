package com.program.reverse;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(JUnitParamsRunner.class)
public class StringReverseTest {
    private static final String STRING_b = "b";
    private static final String STRING_Baeldung = "Baeldung";

    private final StringReverse serviceUnderTest
            = new StringReverse();

    @Test
    @Parameters({
            "abc, cba",
            "abcde, edcba" })
    public void whenWithAnnotationProvidedParams_StringReverse(String input, String expectedValue) {
        assertEquals(expectedValue, serviceUnderTest.StringReverse(input));
    }

    @Test
    @Parameters({
            "abc123def456, abc321def654",
            "abc123def456, abc321def654" })
    public void whenWithAnnotationProvidedParams_AlphanumericReverse(String input, String expectedValue) {
        assertEquals(expectedValue, serviceUnderTest.AlphaNumericReverse(input));
    }

    @Test
    void givenStringWithMultipleChars_whenCallingGetChars_thenGetExpectedResult() {
        char[] aeld = new char[4];
        STRING_Baeldung.getChars(1, 5, aeld, 0);
        assertArrayEquals(new char[] { 'a', 'e', 'l', 'd' }, aeld);

        char[] anotherArray = new char[] { '#', '#', '#', '#', '#', '#' };
        STRING_Baeldung.getChars(1, 5, anotherArray, 1);
        assertArrayEquals(new char[] { '#', 'a', 'e', 'l', 'd', '#' }, anotherArray);
    }

}
