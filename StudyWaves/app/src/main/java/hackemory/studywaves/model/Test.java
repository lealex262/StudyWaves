package hackemory.studywaves.model;

import android.support.compat.BuildConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Thien An Le on 3/25/2017.
 */

public class Test {
    private String testName;
    private String tester;
    private List<Trial> trials;

    public Test(String testName, String tester) {
        this.testName = testName;
        this.tester = tester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;

        Test test = (Test) o;

        if (!testName.equals(test.testName)) return false;
        if (!tester.equals(test.tester)) return false;
        return trials != null ? trials.equals(test.trials) : test.trials == null;

    }

    @Override
    public int hashCode() {
        int result = testName.hashCode();
        result = 31 * result + tester.hashCode();
        result = 31 * result + (trials != null ? trials.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testName='" + testName + '\'' +
                ", tester='" + tester + '\'' +
                ", trials=" + trials +
                '}';
    }

    public List<Trial> getTrials() {
        return trials;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }
}
