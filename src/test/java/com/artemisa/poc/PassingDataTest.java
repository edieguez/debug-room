package com.artemisa.poc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassingDataTest {

    @Test
    void objectReferencePassTest() {
        StringBuilder stringBuilder = new StringBuilder("Change me");
        changeState(stringBuilder);

        // Object is passed by value, but we can modify the state of the object
        assertEquals("Changed", stringBuilder.toString());

        reassign(stringBuilder);

        // If we reassign the object, the original object is not changed
        assertEquals("Changed", stringBuilder.toString());
    }

    @Test
    void stringPassTest() {
        String string = "Change me";
        changeByReference(string);

        // The string is passed by value, so the value is not changed
        assertEquals("Change me", string);
    }

    @Test
    void primitivePassTest() {
        int number = 1;
        changePrimitive(number);

        // The primitive is passed by value, so the value is not changed
        assertEquals(1, number);
    }

    void changeState(StringBuilder stringBuilder) {
        stringBuilder.setLength(0);
        stringBuilder.append("Changed");
    }

    void reassign(StringBuilder stringBuilder) {
        stringBuilder = new StringBuilder("Reassigned");
    }

    void changeByReference(String string) {
        string = "Changed";
    }

    private void changePrimitive(int number) {
        number = 2;
    }
}
