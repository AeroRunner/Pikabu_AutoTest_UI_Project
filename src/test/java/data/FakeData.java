package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakeData {
    private final Faker fakeEN = new Faker(new Locale("EN"));
    public String
            login = fakeEN.internet().emailAddress(),
            password = fakeEN.internet().password();
}
