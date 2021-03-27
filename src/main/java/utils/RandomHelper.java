package utils;

import com.github.javafaker.Faker;

public class RandomHelper {

    public static Faker faker = new Faker();

    public static String generateRandomName() {
        return faker.funnyName().name();
    }

    public static String generateRandomEmail() {
        return String.format("%s@ryanairmadrid.espana", faker.name().lastName());
    }
}
