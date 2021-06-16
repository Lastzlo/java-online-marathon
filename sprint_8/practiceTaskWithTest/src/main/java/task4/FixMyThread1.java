package task4;

public class FixMyThread1 {
    public final static Object den = new Object();
    public final static Object ada = new Object();

    public final static Object lock = new Object();

    public static int n;
    public static int m;

    public static Thread t1 = new Thread() {
        public void run() {
            synchronized (den) {
                synchronized (lock) {
                    for(int i = 0; i < 5; i++, n++)
                        System.out.println("Thread1 n = " + n);
                }
            }

            synchronized (ada) {
                for(int i = 0; i < 5; i++, m++)
                    System.out.println("Thread1 m = " + m);
                System.out.println( "Thread1 success!");
            }
        }
    };

    public static Thread t2 = new Thread() {
        public void run() {
            synchronized (ada) {
                synchronized (lock) {
                    for(int i = 0; i < 5; i++, m++)
                        System.out.println("Thread2 m = " + m);
                    synchronized (den) {
                        for(int i = 0; i < 5; i++, n++)
                            System.out.println("Thread2 n = " + n);
                        System.out.println("Thread2 success!");
                    }
                }
            }
        }
    };
}
