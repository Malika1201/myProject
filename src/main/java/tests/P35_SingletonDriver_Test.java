package tests;

import org.junit.jupiter.api.Test;
import utility.Driver;

public class P35_SingletonDriver_Test {

    @Test
    public void testDriverUtility(){
        Driver.getDriver();
        Driver.getDriver();
        Driver.getDriver();

        }
    }