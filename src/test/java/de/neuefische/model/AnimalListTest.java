package de.neuefische.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class AnimalListTest {

    @ParameterizedTest(name= "{0} should be equal to {1}")
    @MethodSource("provideTestAddAndToStringArguments")
    public void testAddAndToString(AnimalList animalList, String expected){
        // When
        String actual = animalList.toString();

        // Then
        assertEquals(expected, actual);

    }

    private static Arguments[] provideTestAddAndToStringArguments(){
        return new Arguments[]{
                Arguments.of(
                        new AnimalList().add(new Animal("a")).add(new Animal("b")).add(new Animal("c")),
                        "a -> b -> c"
                ),
                Arguments.of(
                        new AnimalList(),
                        ""
                ),
                Arguments.of(
                        new AnimalList().add(new Animal("a")),
                        "a"

                )
        };
    }


    @ParameterizedTest(name= "{1} removed from {0} should be equal to {2}")
    @MethodSource("provideTestRemoveArguments")
    public void testRemove(AnimalList animalList, Animal animalToRemove, String expected){
        // When
        animalList.remove(animalToRemove);
        String actual = animalList.toString();

        // Then
        assertEquals(expected, actual);
    }

    private static Arguments[] provideTestRemoveArguments(){
        return new Arguments[]{
                Arguments.of(
                        new AnimalList(),
                        new Animal("a"),
                        ""
                ),
                Arguments.of(
                        new AnimalList().add(new Animal("a")),
                        new Animal("a"),
                        ""

                ),
                Arguments.of(
                        new AnimalList().add(new Animal("a")).add(new Animal("a")).add(new Animal("a")),
                        new Animal("a"),
                        ""
                ),
                Arguments.of(
                        new AnimalList().add(new Animal("a")).add(new Animal("a")).add(new Animal("b")).add(new Animal("c")),
                        new Animal("a"),
                        "b -> c"
                ),
                Arguments.of(
                        new AnimalList().add(new Animal("a")).add(new Animal("b")).add(new Animal("c")),
                        new Animal("b"),
                        "a -> c"
                ),
                Arguments.of(
                        new AnimalList().add(new Animal("a")).add(new Animal("b")).add(new Animal("b")).add(new Animal("a")),
                        new Animal("b"),
                        "a -> a"
                )
        };
    }

}