package task2;

public class NameList {
    private String[] names = {"Mike", "Emily", "Nick", "Patric", "Sara"};

    public Iterator getIterator() {
        return new Iterator();
    }

    // Write your code here
    public class Iterator {
        private int counter = 0;

        private Iterator() {}

        public boolean hasNext() {
            return !(names.length == counter);
        }

        public String next() {
            counter++;
            return names[counter - 1];
        }
    }

}
