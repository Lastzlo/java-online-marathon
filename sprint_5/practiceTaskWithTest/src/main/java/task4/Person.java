package task4;

import java.util.Objects;

/**
 * Task 4
 *
 * Create class Person with private fields firstName,  lastName, idCode.
 * Create two classes inherited from RuntimeException: NameException and CodeException.
 *
 * NameException will be thrown if the first name or last name is invalid
 * (doesn't start from uppercase or contains not only letters and symbols "-" and " ").
 *
 * CodeException will be thrown if idCode is invalid (valid idCode contains exactly 10 digits).
 *
 * In class Person create setters methods that throw NameException or CodeException
 * if appropriate arguments are not valid.
 *
 * Create static method buildPerson(String firstName, String lastName, String idCode)
 * that returns Person if all arguments are valid otherwise it thrown IllegalArgumentException
 * with message about all invalid arguments.
 *
 * Override method toString() for Person class that returns representation of Person in form:
 * firstName lastName: idCode.
 *
 * Override equals and hashCode methods for Person class.
 *
 * For example
 *
 * Person p = new Person();
 * p.setFirstName("joe") throw NameException with message “Incorrect value joe for firstName (should start from upper case and contains only alphabetic characters and -, _)”
 * p.setIdCode("2") throw CodeException with message "Incorrect value 2 for code (should contains exactly 10 digits)"
 * Person.buildPerson("Joe", "KlarK2", "AS-2") throw IllegalArgumentException with message "Incorrect value KlarK2 for lastName (should start from upper case and contains only alphabetic characters and -, _); Incorrect value AS-2 for code (should contains exactly 10 digits)"
 * */
public class Person {
    private long idCode;
    private String firstName;
    private String lastname;

    public Person(){}

    public static Person buildPerson(String firstName, String lastName, String idCode) {
        Person person = new Person();
        StringBuilder sb = new StringBuilder();

        try {
            person.setFirstName(firstName);
        } catch (NameException e) {
            sb.append(e.getMessage()).append("; ");
        }
        try {
            person.setLastName(lastName);
        } catch (NameException e) {
            sb.append(e.getMessage()).append("; ");
        }
        try {
            person.setIdCode(idCode);
        } catch (CodeException e) {
            sb.append(e.getMessage());
        }

        if (! sb.toString().isEmpty()) throw new IllegalArgumentException(sb.toString());

        return person;
    }

    public long getIdCode() {
        return idCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setIdCode(String idCode) {
        Long value;
        try {
            value = Long.valueOf(idCode);
        } catch (NumberFormatException e) {
            throw new CodeException("Incorrect value " + idCode + " for code (should contains exactly 10 digits)");
        }

        if(! isNumberHasTenDigits(value)) throw new CodeException("Incorrect value " + idCode + " for code (should contains exactly 10 digits)");

        this.idCode = value;
    }

    private boolean isNumberHasTenDigits(Long number) {
        if (number < 0) {
            return (String.valueOf(number).length() == 11);
        } else {
            return (String.valueOf(number).length() == 10);
        }
    }

    //word is Correct if doesn't start from uppercase or contains not only letters and symbols "-" and " "
    private boolean isWordCorrect(String word) {
        if(! Character.isUpperCase(word.charAt(0))) return false;
        for (char c : word.toCharArray()) {
            if ((! Character.isAlphabetic(c)) && (c != '-') && (c != ' ')) return false;
        }
        return true;
    }

    public void setFirstName(String firstName) {
        if(! isWordCorrect(firstName)) throw new NameException("Incorrect value " + firstName + " for firstName (should start from upper case and contains only alphabetic characters and symbols -, _)");

        this.firstName = firstName;
    }

    public void setLastName(String lastname) {
        if(! isWordCorrect(lastname)) throw new NameException("Incorrect value " + lastname + " for lastname (should start from upper case and contains only alphabetic characters and symbols -, _)");

        this.lastname = lastname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return idCode == person.idCode && Objects.equals(firstName, person.firstName) && Objects.equals(lastname, person.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCode, firstName, lastname);
    }

    //firstName lastName: idCode
    @Override
    public String toString() {
        return firstName + " " + lastname + ": " + idCode;
    }

}

class NameException extends RuntimeException {
    public NameException(String s){
        super(s);
    }
}

class CodeException extends RuntimeException {
    public CodeException(String s){
        super(s);
    }
}

//IllegalArgumentException with message Incorrect value io for firstName (should start from upper case and contains only alphabetic characters and symbols -, _); Incorrect value 23 for code (should contains exactly 10 digits)
//IllegalArgumentException with message Incorrect value io for firstName (should start from upper case and contains only alphabetic characters and -, _); Incorrect value 23 for code (should contains exactly 10 digits