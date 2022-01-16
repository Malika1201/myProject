package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class P38_JavaFaker {
    @Test
    public void fakerTest(){
        Faker faker = new Faker();
        faker.name().fullName();

        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.address().streetAddress() = " + faker.address().streetAddress());
        System.out.println("faker.address().city() = " + faker.address().city());
        System.out.println("faker.address().state() = " + faker.address().state());
        System.out.println("faker.address().zipCodeByState(\"VA\") = " + faker.address().zipCodeByState("VA"));
        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        System.out.println("faker.number().numberBetween(1000,99999) = " + faker.number().numberBetween(10000, 99999));
        System.out.println("faker.letterify(\"?????\") to uppercase = " + faker.letterify("?????").toUpperCase(Locale.ROOT));
        System.out.println("faker.bothify(\"????-####-???\") = " + faker.bothify("????-####-???"));
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());

        System.out.println("faker.numerify(\"##/##\") = " + faker.numerify("##/##"));



        
    }
}
