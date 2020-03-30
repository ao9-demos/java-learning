package io.ao9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Array;
import java.util.stream.Stream;

class UtilitiesTest {
    private static Utilities utilities;

    @BeforeAll
    static void beforeAll() {
        utilities = new Utilities();
    }

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.out.println("Setup test...");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.out.println("TearDown test...");
    }

    @ParameterizedTest
    @MethodSource("createTestCases_everyNthChar")
    void everyNthChar_parameterized(char[] expected, char[] source, int n) {
        assertArrayEquals(expected, utilities.everyNthChar(source, n));
    }

    private static Stream<Arguments> createTestCases_everyNthChar() {
        return Stream.of(
                Arguments.of(new char[]{'e', 'l'}, new char[]{'h', 'e', 'l', 'l', 'o'}, 2),
                Arguments.of(new char[]{'h', 'e', 'l', 'l', 'o'}, new char[]{'h', 'e', 'l', 'l', 'o'}, 8),
                Arguments.of(null, null, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("createTestCases_removePairs")
    void removePairs_parameterized(String expected, String source) {
        assertEquals(expected, utilities.removePairs(source));
    }

    private static Stream<Arguments> createTestCases_removePairs() {
        return Stream.of(
                Arguments.of("ABCDEF", "AABCDDEFF"),
                Arguments.of("ABCABDEF", "ABCCABDEEF"),
                Arguments.of("ABCDEF", "ABCDEFF"),
                Arguments.of("AB8EFG", "AB88EFFG"),
                Arguments.of("123456", "112233445566"),
                Arguments.of("ZYZQB", "ZYZQQB"),
                Arguments.of("A", "A"),
                Arguments.of("", ""),
                Arguments.of(null, null)
        );
    }

    @org.junit.jupiter.api.Test
    void removePairs_AABCDDEFF() {
        String source = "AABCDDEFF";
        String result = utilities.removePairs(source);
        System.out.println("result = " + result);
        Assertions.assertEquals("ABCDEF", result);
    }

    @org.junit.jupiter.api.Test
    void removePairs_ABCCABDEEF() {
        String source = "ABCCABDEEF";
        String result = utilities.removePairs(source);
        System.out.println("result = " + result);
        Assertions.assertEquals("ABCABDEF", result);
    }

    @Test
    void converter_divide0() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            utilities.converter(10,0);
        });
    }

    @ParameterizedTest
    @MethodSource("createTestCases_converter")
    void converter(int expected, int a, int b) {
        assertEquals(expected, utilities.converter(a,b));
    }

    private static Stream<Arguments> createTestCases_converter() {
        return Stream.of(
                Arguments.of(300, 10, 5)
        );
    }

    @org.junit.jupiter.api.Test
    void nullIfOddLength() {
        assertNull(utilities.nullIfOddLength("odd"));
        assertNull(utilities.nullIfOddLength(null));
        assertNotNull(utilities.nullIfOddLength("even"));
    }
}