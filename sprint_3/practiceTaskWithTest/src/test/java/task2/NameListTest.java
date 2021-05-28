package task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameListTest {
    @Test
    public void printAllNames() {
        NameList.Iterator iterator = new NameList().getIterator();
        
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }
    }
}