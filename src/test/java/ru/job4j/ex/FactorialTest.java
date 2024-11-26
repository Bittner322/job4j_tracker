package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactorialTest {
    @Test
    void whenException() {
        int number = -1;
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> Factorial.calc(number)
        );
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }
}