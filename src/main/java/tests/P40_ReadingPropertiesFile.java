package tests;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class P40_ReadingPropertiesFile {
    
    @Test
    public void testReadingProperties() throws IOException {
        FileInputStream in = new FileInputStream("config.properties");
        Properties properties = new Properties();
        properties.load(in);
        in.close();
        
        //catch io and file exception---> throws IOException add
        /*
        or we can use try catch block

        try{
        FileInpitStream in = new }
         */
        
        String helloValue=properties.getProperty("hello");
        System.out.println("helloValue = " + helloValue);

        System.out.println("properties.getProperty(\"weborder_url\") = " + properties.getProperty("weborder_url"));
        System.out.println(" properties.getProperty(\"blabla\") = " +  properties.getProperty("blabla"));

        
        
        
        
    }
}
