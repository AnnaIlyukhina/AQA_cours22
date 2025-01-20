import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TestFactorialCalculator {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite: Выполняется перед всеми тестами в наборе.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test: Выполняется перед запуском всех тестов в <test>.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class: Выполняется перед первым тестом в классе.");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method: Выполняется перед каждым тестовым методом.");
    }

    @Test
    public void testCalculateFactorialOfZero() {
        assertEquals(FactorialCalculator.calculateFactorial(0), 1);
        System.out.println("Тест факториала 0 выполнен.");
    }

    @Test
    public void testCalculateFactorialOfOne() {
        assertEquals(FactorialCalculator.calculateFactorial(1), 1);
        System.out.println("Тест факториала 1 выполнен.");
    }

    @Test
    public void testCalculateFactorialOfFive() {
        assertEquals(FactorialCalculator.calculateFactorial(5), 120);
        System.out.println("Тест факториала 5 выполнен.");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method: Выполняется после каждого тестового метода.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class: Выполняется после выполнения всех тестов в классе.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test: Выполняется после завершения всех тестов в <test>.");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite: Выполняется после завершения всех тестов в наборе.");
    }
}