package task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyThreadsTest {

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
        MyThreads.t1.start();
        MyThreads.t2.start();
    }

    @Test
    void whenStart_t2_and_t1() {
        MyThreads.t2.start();
        MyThreads.t1.start();
    }

}