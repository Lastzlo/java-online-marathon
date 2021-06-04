package task4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void setFirstName_whenCorrect() {
        Person person = new Person();
        person.setFirstName("Vladimir");
        Assertions.assertEquals("Vladimir", person.getFirstName());
    }

    @Test
    void setFirstName_whenIllegalFirstName_thenNameException_thenFirstNameNull() {
        Person person = new Person();

        Assertions.assertThrows(NameException.class, ()-> {
            person.setFirstName("123Vladimir");

        });

        Assertions.assertNull(person.getFirstName());
    }

    @Test
    void setIdCode_whenCorrect() {
        Person person = new Person();
        person.setIdCode("9234567890");
        Assertions.assertEquals(9_234_567_890L, person.getIdCode());
    }

    @Test
    void setIdCode_whenIdCodeLengthNot10_thenCodeException_thenIdCode0() {
        Person person = new Person();

        CodeException exception = assertThrows(CodeException.class, () -> {
            person.setIdCode("1234567");
        });
        String message = exception.getMessage();

        Assertions.assertEquals("Incorrect value 1234567 for code (should contains exactly 10 digits)", message);
        Assertions.assertEquals(0, person.getIdCode());
    }

    @Test
    void setIdCode_whenIdCodeNotANumber_thenCodeException_thenIdCode0() {
        Person person = new Person();

        CodeException exception = assertThrows(CodeException.class, () -> {
            person.setIdCode("123_4567");
        });
        String message = exception.getMessage();

        Assertions.assertEquals("Incorrect value 123_4567 for code (should contains exactly 10 digits)", message);
        Assertions.assertEquals(0, person.getIdCode());
    }

    @Test
    void buildPerson_whenCorrect() {

        Person person = Person.buildPerson("Johnny", "Depp", "1231231234");

        Assertions.assertEquals("Johnny", person.getFirstName());
        Assertions.assertEquals("Depp", person.getLastname());
        Assertions.assertEquals(1231231234, person.getIdCode());
    }

    @Test
    void buildPerson_whenIdCodeNotANumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Person.buildPerson("Johnny", "Depp", "123dssdsdd");
        });

        String message = exception.getMessage();

        Assertions.assertEquals("Incorrect value 123dssdsdd for code (should contains exactly 10 digits)", message);
    }

}