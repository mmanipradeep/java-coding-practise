package com.program.fizzBuzz;


import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;

import com.program.customAnnotation.Car;
import com.program.customAnnotation.JsonSerializer;
import org.junit.Test;
import org.hamcrest.Matcher;

public class JsonSerializerTest {
    @Test(expected = NullPointerException.class)
    public void serializeNullObjectEnsureNullPointerExceptionThrown() throws Exception {
        new JsonSerializer().serialize(null);
    }

    @Test
    public void serializeCarObjectEnsureCorrectOutputJson() throws Exception {
        JsonSerializer serializer = new JsonSerializer();
        Car testCar = new Car("maruthi", "F150", "2018");
        String json = serializer.serialize(testCar);
        assertThat(json, isExpectedCarJson(testCar));
    }

    private static Matcher<String> isExpectedCarJson(Car car) {
        return isOneOf(
                "{\"manufacturer\":\"" + car.getMake() + "\",\"model\":\"" + car.getModel() + "\"}",
                "{\"model\":\"" + car.getModel() + "\",\"manufacturer\":\"" + car.getMake() + "\"}"
        );
    }
}
