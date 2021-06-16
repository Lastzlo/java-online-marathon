package task4;

import org.junit.jupiter.api.Test;

class FixMyThreadsTest {

    @Test
    void whenStart_t1() {
        MyThreads.t1.start();
    }

    @Test
    void whenStart_t2() {
        MyThreads.t2.start();
    }

    @Test
    void whenStart_t1_and_t2() {
        FixMyThread1.t1.start();
        FixMyThread1.t2.start();
    }

}