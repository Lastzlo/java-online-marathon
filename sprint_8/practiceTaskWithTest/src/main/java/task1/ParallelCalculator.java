package task1;

import java.util.function.BinaryOperator;

/**Task 1
 * Create ParallelCalculator class that will be able to execute an operation in parallel thread.
 *
 * Use the implementation of Runnable interface for this.
 *
 * Constructor of ParallelCalculator should take 3 parameters:
 * 1) The BinaryOperator<Integer> to define an operation that will be executed,
 * 2) The operand1 of type int and operand2 of type int.
 *
 * The ParallelCalculator class should have not  private result field of type int where the result of the operation will be written when it's executed.
 * */
public class ParallelCalculator implements Runnable {
    int result = 0;

    private BinaryOperator<Integer> binaryOp;
    private int operand1, operand2;


    public ParallelCalculator(BinaryOperator<Integer> binaryOp, int operand1, int operand2) {
        this.binaryOp = binaryOp;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public void run() {
        synchronized (this) {
            result = binaryOp.apply(operand1, operand2);
        }
    }
}

class ParallelCalculator2 implements Runnable {
    final int result;

    public ParallelCalculator2(BinaryOperator<Integer> binaryOp, int operand1, int operand2) {
        result = binaryOp.apply(operand1, operand2);
    }

    @Override
    public void run() {
    }
}
