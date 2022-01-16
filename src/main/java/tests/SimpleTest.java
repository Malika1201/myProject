package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SimpleTest {
    @Test
    public void testAddition() {
        int num1 = 3;
        int num2 = 2;
        int result = 5;

        assertEquals(result, num1 + num2);
        //can also add static import (to the top) and we will call asserteauls directly
        //same like if statement

    }


    @Test
    public void testString() {
        System.out.println("message from testString");
        String name = "Junit";
        assertEquals("Junit",name);

    }
}

