package task6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {


    /* Sorting records inside the address book by ASC */
    // String[] expected = { "First name: John, Last name: Brown, Address: Address #1",
    //         "First name: John, Last name: Taylor, Address: Address #1",
    //         "First name: Karen, Last name: Davis, Address: Address #2",
    //         "First name: Susan, Last name: Brown, Address: Address #4" };
    // String[] actual = new String[4];
    // AddressBook addressBook = new AddressBook(4);
    // addressBook.create("John", "Brown", "Address #1");
    // addressBook.create("Susan", "Brown", "Address #4");
    // addressBook.create("Karen", "Davis", "Address #2");
    // addressBook.create("John", "Taylor", "Address #1");
    // addressBook.sortedBy(SortOrder.ASC);
    // int counter = 0;
    // for (Object record : addressBook)
    //     actual[counter++] = record.toString();
    // return Arrays.equals(expected, actual);
    @Test
    void sortedByTest_1() {
        String[] expected = { "First name: John, Last name: Brown, Address: Address #1",
                "First name: John, Last name: Taylor, Address: Address #1",
                "First name: Karen, Last name: Davis, Address: Address #2",
                "First name: Susan, Last name: Brown, Address: Address #4" };

        String[] actual = new String[4];
        AddressBook addressBook = new AddressBook(4);
        addressBook.create("John", "Brown", "Address #1");
        addressBook.create("Susan", "Brown", "Address #4");
        addressBook.create("Karen", "Davis", "Address #2");
        addressBook.create("John", "Taylor", "Address #1");
        addressBook.sortedBy(SortOrder.ASC);
        int counter = 0;

        for (Object record : addressBook) {
            actual[counter++] = record.toString();
        }

        /*without syntax sugar*/
//        for (Iterator<String> iterator = addressBook.iterator(); iterator.hasNext(); ) {
//            Object record = iterator.next();
//            actual[counter++] = record.toString();
//        }

        assertTrue(Arrays.equals(expected, actual));

    }

    @Test
    void create_whenPersonDontDuplicate() {
        AddressBook addressBook = new AddressBook(5);
        addressBook.create("Taras", "Shevchenko", "Ukraine");
        addressBook.create("Lesya", "Ukrainka", "Ukraine");

        Iterator<String> iterator = addressBook.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }

        final int size = addressBook.size();
        assertEquals(2, size);

    }

    @Test
    void create_whenPersonDuplicate() {
        AddressBook addressBook = new AddressBook(5);
        addressBook.create("Taras", "Shevchenko", "Ukraine");

        assertFalse(addressBook.create("Taras", "Shevchenko", "Russian"));
        assertFalse(addressBook.create("Taras", "Shevchenko", "Ukraine"));

        final int size = addressBook.size();
        assertEquals(1, size);

    }

    @Test
    void contain_whenItContains() {
        AddressBook addressBook = new AddressBook(5);
        addressBook.create("Taras", "Shevchenko", "Ukraine");

        assertTrue(addressBook.contain("Taras", "Shevchenko"));
    }

    @Test
    void contain_whenItDoesntContains() {
        AddressBook addressBook = new AddressBook(5);
        addressBook.create("Taras", "Shevchenko", "Ukraine");

        assertFalse(addressBook.contain("Pavlo", "Tuchuna"));
    }

    @Test
    void update_whenItContains() {
        //if
        AddressBook addressBook = new AddressBook(5);
        addressBook.create("Taras", "Shevchenko", "Ukraine");
        addressBook.create("Lesya", "Ukrainka", "Ukraine");
        addressBook.create("Dante", "Olivieri", "Italy");

        //when
        boolean contain = addressBook.contain("Taras", "Shevchenko");
        boolean result = addressBook.update("Taras", "Shevchenko", "Ukraine Ukraine");


        //then
        assertTrue(contain);
        assertTrue(result);
        assertEquals("Ukraine Ukraine",
                addressBook.read("Taras", "Shevchenko"));
    }

    @Test
    void update_whenItDoesntContains() {
        //if
        AddressBook addressBook = new AddressBook(5);
        addressBook.create("Taras", "Shevchenko", "Ukraine");
        addressBook.create("Lesya", "Ukrainka", "Ukraine");

        //when
        boolean contain = addressBook.contain("Dante", "Olivieri");
        boolean result = addressBook.update("Dante", "Olivieri", "Ukraine Ukraine");


        //then
        assertFalse(contain);
        assertFalse(result);
        assertEquals(null, addressBook.read("Dante", "Olivieri"));
    }

    @Test
    void delete() {
        //if
        AddressBook addressBook = new AddressBook(5);
        addressBook.create("Taras", "Shevchenko", "Ukraine");
        addressBook.create("Lesya", "Ukrainka", "Ukraine");
        addressBook.create("Dante", "Olivieri", "Italy");

        //when
        boolean delete = addressBook.delete("Lesya", "Ukrainka");

        //then
        assertTrue(delete, "it should be true");
        assertFalse(addressBook.contain("Lesya", "Ukrainka"));
        assertEquals(2, addressBook.size());

    }

    @Test
    void read() {
        AddressBook addressBook = new AddressBook(2);

        addressBook.create("Pavlo", "Tuchuna", "Ukraine");
        addressBook.create("Ivan", "Franko", "Ukraine");

        assertEquals("Ukraine",
                addressBook.read("Pavlo", "Tuchuna"));


    }

    @Test
    void size_whenNothingDo() {
        AddressBook addressBook = new AddressBook(5);
        assertEquals(0, addressBook.size());
    }

    @Test
    void size_whenAddMoreThenStartSize() {
        AddressBook addressBook = new AddressBook(2);

        assertTrue(addressBook.create("Pavlo", "Tuchuna", "Ukraine"));
        assertTrue(addressBook.create("Ivan", "Franko", "Ukraine"));
        assertTrue(addressBook.create("Ivan", "Nechuy-Levytsky", "Ukraine"));
        addressBook.create("Taras", "Shevchenko", "Ukraine");
        assertEquals(4, addressBook.size());
    }

    @Test
    void sortedBy_ASC_withNullsValues() {
        //if
        AddressBook addressBook = new AddressBook(10);

        addressBook.create("Taras", "Shevchenko", "Ukraine");
        addressBook.create("Ivan", "Nechuy-Levytsky", "Ukraine");
        addressBook.create("Lesya", "Ukrainka", "Ukraine");
        addressBook.create("Ivan", "Franko", "Ukraine");
        addressBook.create("Dante", "Olivieri", "Italy");

        //when
        addressBook.sortedBy(SortOrder.ASC);

        //then
        Iterator iterator = addressBook.iterator();

        while (iterator.hasNext()) {
            String next = (String) iterator.next();

            System.out.println("iterator.next() = " + next);
        }
    }

    @Test
    void sortedBy_ASC_withoutValues() {
        //if
        AddressBook addressBook = new AddressBook(5);

        addressBook.create("Taras", "Shevchenko", "Ukraine");
        addressBook.create("Ivan", "Nechuy-Levytsky", "Ukraine");
        addressBook.create("Lesya", "Ukrainka", "Ukraine");
        addressBook.create("Ivan", "Franko", "Ukraine");
        addressBook.create("Dante", "Olivieri", "Italy");

        //when
        addressBook.sortedBy(SortOrder.ASC);

        //then
        Iterator iterator = addressBook.iterator();

        while (iterator.hasNext()) {
            String next = (String) iterator.next();

            System.out.println("iterator.next() = " + next);
        }
    }

    @Test
    void sortedBy_DESC() {
        //if
        AddressBook addressBook = new AddressBook(10);

        addressBook.create("Taras", "Shevchenko", "Ukraine");
        addressBook.create("Ivan", "Nechuy-Levytsky", "Ukraine");
        addressBook.create("Lesya", "Ukrainka", "Ukraine");
        addressBook.create("Ivan", "Franko", "Ukraine");
        addressBook.create("Dante", "Olivieri", "Italy");

        //when
        addressBook.sortedBy(SortOrder.DESC);

        //then
        Iterator iterator = addressBook.iterator();

        while (iterator.hasNext()) {
            String next = (String) iterator.next();

            System.out.println("iterator.next() = " + next);
        }
    }

    @Test
    void iterator() {
        AddressBook addressBook = new AddressBook(10);

        addressBook.create("Pavlo", "Tuchuna", "Ukraine");
        addressBook.create("Ivan", "Franko", "Ukraine");

        Iterator iterator = addressBook.iterator();

        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }
    }
}