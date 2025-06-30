package temporalcoupling.model;

import java.util.Random;

public record Student(int exp) {

    public String passes(Test test) {
        TestResult testResult = new Random().nextInt() % 2 == 0 ? TestResult.SUCCESS : TestResult.FAILURE;
        return "Test " + test.id() + ": " + testResult;
    }
}
