package io.ao9;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;

    @org.junit.jupiter.api.BeforeAll
    static void beforeAll() {
        System.out.println("Before all tests");
    }

    @org.junit.jupiter.api.BeforeEach
    void setup() {
        System.out.println("Before each test");
        account = new BankAccount("Ao", "Dong", 1000.00, BankAccount.CHECKING);
    }

    @AfterEach
    void teardown() {
        System.out.println("After each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all tests");
    }

    @Test
    void deposit() {
        double balance = account.deposit(200d, true);
        assertEquals(1200d, balance, 0);
    }

    @ParameterizedTest
    @MethodSource("createTestCases")
    void deposit_param(double amount, boolean branch, double expected) {
        double balance = account.deposit(amount, branch);
        assertEquals(expected, balance, 0.1);
    }

    private static Stream<Arguments> createTestCases() {
        return Stream.of(
                Arguments.of(100d, true, 1100d),
                Arguments.of(200, true, 1200d),
                Arguments.of(325.14, true, 1325.14),
                Arguments.of(489.33, true, 1489.33),
                Arguments.of(1000d, true, 2000d));
    }

    @org.junit.jupiter.api.Test
    void withdraw_branch() {
        double balance = account.withdraw(600d, true);
        assertEquals(400d, balance, 0.01);
    }

    @Test
    void withdraw_notBranch() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            double balance = account.withdraw(600d, false);
        });
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        double balance = account.deposit(200d, true);
        assertEquals(1200d, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        double balance = account.withdraw(200d, true);
        assertEquals(800d, account.getBalance(), 0);
    }

    @org.junit.jupiter.api.Test
    void isChecking_true() {
        assertTrue(account.isChecking());
    }
}