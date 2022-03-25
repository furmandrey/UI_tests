package com.geekbrains.lesson4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.geekbrains.lesson4.AreaTriangle.squareMeters;

public class AreaTriangleTest {
    private static Logger logger = LoggerFactory.getLogger("AreaTriangleTest");


    @BeforeAll
    static void beforeAll() {
        System.out.println("before all");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("before each");
    }

    @ParameterizedTest
    @CsvSource({"6, 3, 4, 5", "7.81, 4, 4, 5"})
    void commonAreaTriangleTest(double expectedResult, double a, double b, double c) throws NotExistingException, SideMustHaveSizeException {
        double result = squareMeters(a, b, c);
        Assertions.assertEquals(expectedResult, result);
        logger.info("info log");
        logger.trace("trace log");
    }


    @Test
    @DisplayName("проверка вычисления площади триугольника по трем сторонам")
    void givenTriangleSidesWhenCallIsSquareMetersThenIntResult() throws SideMustHaveSizeException, NotExistingException {
        double result = squareMeters(4, 4, 5);
        //Assertions.assertEquals(6, result);
        Assertions.assertEquals(7.81, result);
    }
    @Test
    void exceptionWhenTryZeroSize(){
        Assertions.assertThrows(SideMustHaveSizeException.class, () -> squareMeters(0, 1.2, 5.0));
    }

    @Test
    void exceptionWhenTriangleNotExist(){
        Assertions.assertThrows(NotExistingException.class, () -> squareMeters(1, 1, 5));
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }

    @AfterEach
    void afterEach() {
        System.out.println("after each");
    }

}
