package temporalcoupling;


import temporalcoupling.model.Course;
import temporalcoupling.model.Level;
import temporalcoupling.model.Student;
import temporalcoupling.model.Test;

/**
 * Here we need to make student pass test.
 * But we need to get the test first...
 * But to get the test we need to get the student level...
 * What can we change in methods
 * evaluate, fetchStudentLevel, fetchMatchingTest and passingTest to explicit this temporal coupling ?
 */
public class CourseAssessment {

    private Level level;
    private Test test;

    public String evaluate(Student student, Course course) {
        fetchStudentLevel(student);
        fetchMatchingTest(course);
        return passingTest(student);
    }

    private String passingTest(Student student) {
        return student.passes(test);
    }

    private void fetchMatchingTest(Course course) {
        test = new Test(course.name() + "_" + level.name());
    }

    private void fetchStudentLevel(Student student) {
        level = switch (student.exp()) {
            case 1 -> Level.BEG;
            case 2 -> Level.INTER;
            default -> Level.MASTER;
        };
    }
}