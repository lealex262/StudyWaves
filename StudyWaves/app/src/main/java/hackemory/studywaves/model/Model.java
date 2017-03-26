package hackemory.studywaves.model;

import android.support.compat.BuildConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Thien An Le on 3/25/2017.
 */

public class Model {

    /** Singleton instance */
    private static final Model _instance = new Model();
    public static Model getInstance() { return _instance; }

    /** holds the list of all courses */
    private List<Test> tests;

    /** the currently selected Test, defaults to first Test */
    private Test currentTest;



    /**
     * make a new model
     */
    public Model() {
        tests = new ArrayList<>();

        //comment this out after full app developed
        loadData();

    }

    private void loadData() {
        tests.add(new Test("SAT", "Andrew"));
        tests.add(new Test("ACT", "NNNN"));
    }

    /**
     * get the courses
     * @return a list of the courses in the app
     */
    public List<Test> getTests() { return tests; }

    /**
     * add a Test to the app.  checks if the Test is already entered
     *
     * uses O(n) linear search for Test
     *
     * @param Test  the Test to be added
     * @return true if added, false if a duplicate
     */
    public boolean addTest(Test Test) {
        for (Test c : tests ) {
            if (c.equals(Test)) return false;
        }
        tests.add(Test);
        return true;
    }

    /**
     *
     * @return  the currently selected Test
     */
    public Test getCurrentCourse() { return currentTest;}

    public void setCurrentCourse(Test Test) { currentTest = Test; }


    /**
     * add a student to the current Test
     *
     * @return true if student added, false if not added
     */
    public boolean addTrial(Trial trial) {
        return currentTest != null && currentTest.addTrial(trial);
    }

    public List<String> convertTestToString() {
        int index = 0;
        ArrayList<String> display = new ArrayList<>();
        for (Test t: tests) {
            if (t != null) {
                 display.add(t.toString());
            }
        }
        return display;
    }
}
