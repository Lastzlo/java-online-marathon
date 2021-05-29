package task6;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class AddressBook implements Iterable<String> {
    private int counter = 0;
    private NameAddressPair[] addressBook;

    public AddressBook (int capacity) {
        this.addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {
        if(contain(firstName, lastName)) return false;

        NameAddressPair.Person newPerson = new NameAddressPair.Person(firstName, lastName);
        NameAddressPair newNameAddressPair = new NameAddressPair(newPerson, address);
        int posForNewPair = 0;

        if(!(addressBook[addressBook.length - 1] == null)) {
            posForNewPair = addressBook.length;
            addressBook = Arrays.copyOf(addressBook, addressBook.length * 2);
        } else {
            Iterator iterator = iterator();
            while (iterator.hasNext()) {
                iterator.next();
                posForNewPair++;
            }
        }

        addressBook[posForNewPair] = newNameAddressPair;
        return true;
    }

    public boolean contain(String firstName, String lastName) {
        NameAddressPair.Person newPerson = new NameAddressPair.Person(firstName, lastName);
        for (NameAddressPair pair : addressBook) {
            if(pair == null) return false;
            if(pair.person.equals(newPerson)) return true;
        }
        return false;
    }

    public boolean update(String firstName, String lastName, String address) {
        NameAddressPair.Person updatePerson = new NameAddressPair.Person(firstName, lastName);
        for (NameAddressPair pair : addressBook) {
            if(pair == null) return false;
            if(pair.person.equals(updatePerson)) {
                pair.address = address;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        if(!contain(firstName, lastName)) return false;

        NameAddressPair.Person deletePerson = new NameAddressPair.Person(firstName, lastName);

        // Create a proxy array of size one less than original array
        NameAddressPair[] proxyArray = new NameAddressPair[addressBook.length - 1];

        // copy all the elements in the original to proxy array except the one at index
        for (int i = 0, k = 0; i < addressBook.length; i++) {

            // check if element not null and element of index is equals, continue without copying
            if((addressBook[i] != null) && (addressBook[i].person.equals(deletePerson))) {
                continue;
            }
            // else copy the element
            proxyArray[k++] = addressBook[i];
        }

        addressBook = proxyArray;
        return true;
    }

    public String read(String firstName, String lastName) {
        NameAddressPair.Person foundPerson = new NameAddressPair.Person(firstName, lastName);
        for (NameAddressPair pair : addressBook) {
            if(pair == null) continue;
            if(pair.person.equals(foundPerson)) {
                return pair.address;
            }
        }
        return null;
    }

    public int size() {
        int numOfPairs = 0;
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            iterator.next();
            numOfPairs++;
        }

        return numOfPairs;
    }

    public void sortedBy(SortOrder order) {
        //delete null variables
        int indexOfFirstNullValue = 0;

        for (int i = 0; i < addressBook.length; i++) {
            indexOfFirstNullValue = i + 1;

            if(addressBook[i] == null) {
                indexOfFirstNullValue--;
                break;
            }
        }

        addressBook = Arrays.copyOfRange(addressBook, 0, indexOfFirstNullValue);

        Comparator<NameAddressPair> comparator =
                new Comparator<NameAddressPair>() {
                    @Override
                    public int compare(NameAddressPair o1, NameAddressPair o2) {
                        if(o1 == null && o2 == null) return 0;
                        if(o1 == null) return -1;
                        if(o2 == null) return 1;

                        String o1FirstName = o1.person.firstName;
                        String o2FirstName = o2.person.firstName;

                        if(o1FirstName.equals(o2FirstName)) {
                            return o1.person.lastName.compareTo(o2.person.lastName);
                        } else {
                            return o1FirstName.compareTo(o2FirstName);
                        }
                    }
                };

        if(SortOrder.DESC.equals(order)) {
            Arrays.sort(addressBook, comparator.reversed());
        } else {
            Arrays.sort(addressBook, comparator);
        }

    }

    @Override
    public Iterator<String> iterator() {
        return new AddressBookIterator();
    }


    private class AddressBookIterator implements Iterator<String>{
        private int counter = 0;

        @Override
        public boolean hasNext() {
            if(addressBook.length == counter) return false;
            return !(addressBook[counter] == null);
        }

        @Override
        public String next() {
            NameAddressPair nameAddressPair = addressBook[counter];

            StringBuilder result = new StringBuilder()
                    .append("First name: ")
                    .append(nameAddressPair.person.firstName)
                    .append(", Last name: ")
                    .append(nameAddressPair.person.lastName)
                    .append(", Address: ")
                    .append(nameAddressPair.address);

            counter++;
            return result.toString();
        }
    }

    private static class NameAddressPair {
        final private Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        private static class Person {
            private String firstName;
            private String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
            }

            @Override
            public int hashCode() {
                return Objects.hash(firstName, lastName);
            }

        }



    }

}



enum SortOrder {
    ASC, DESC
}