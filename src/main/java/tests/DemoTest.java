package tests;

import org.junit.jupiter.api.*;

import java.sql.SQLOutput;

public class DemoTest {




    @BeforeEach
    public void setup(){
        System.out.println("@BeforeEach runs before each test");
    }

    @AfterEach
    public void teardown(){
        System.out.println("@AfterEach runs after each test");
    }

    @Test
    public void test1(){
        System.out.println("test 1 is running");
    }

    @Test
    public void test2(){
        System.out.println("test2 is running");
    }
    //i want to run smth before test

}
