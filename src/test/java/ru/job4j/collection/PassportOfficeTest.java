package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethodIsPassed() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddMethodIsFailed() {
        Citizen citizenIvanov = new Citizen("123asd", "Ivan Ivanov");
        Citizen citizenPetrov = new Citizen("123asd", "Petr Petrov");
        PassportOffice passportOffice = new PassportOffice();
        passportOffice.add(citizenIvanov);
        assertThat(passportOffice.add(citizenPetrov)).isFalse();
    }
}