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

    public String evaluate(Student student, Course course) {
        Level level = fetchStudentLevel(student); // Student -> Level
        Test test = fetchMatchingTest(course, level); // Course, Level -> Test
        return passingTest(student, test); // Student, Test -> TestResult
    }

    private String passingTest(Student student, Test test) {
        return student.passes(test);
    }

    private Test fetchMatchingTest(Course course, Level level) {
        return new Test(course.name() + "_" + level.name());
    }

    private Level fetchStudentLevel(Student student) {
        return switch (student.exp()) {
            case 1 -> Level.BEG;
            case 2 -> Level.INTER;
            default -> Level.MASTER;
        };
    }
}