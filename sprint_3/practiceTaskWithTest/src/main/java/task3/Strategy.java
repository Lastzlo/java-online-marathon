package task3;

public interface Strategy {
    double doOperation(int a, int b);
}

class Operations {
    public static double addAtoB(int a, int b) {
        return execute(a, b, new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a + b;
            }
        });
    }

    public static double subtractBfromA(int a, int b) {
        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a - b;
            }
        };
        return execute(a, b, strategy);
    }

    public static double multiplyAbyB(int a, int b) {
        return execute(a, b, new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a * b;
            }
        });
    }

    public static double divideAbyB(int a, int b) {
        Strategy strategy = new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return (double) a / b;
            }
        };
        return execute(a, b, strategy);
    }

    public static double execute(int a, int b, Strategy strategy) {
        double result = strategy.doOperation(a, b);
        System.out.println(result);
        return result;
    }
}
