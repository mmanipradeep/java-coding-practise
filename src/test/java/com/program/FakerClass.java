package com.program;

import com.github.javafaker.Faker;

public class FakerClass {




    public void getEmployeeDEtails(){
        Faker faker = new Faker();
        faker.name().fullName();
        faker.name().firstName();
        faker.name().lastName();
        faker.job().position();
        faker.phoneNumber().cellPhone();
        faker.internet().emailAddress();
        faker.address().streetAddress();
        faker.address().cityName();
        faker.date().birthday();
        faker.address().country();
    }

}
