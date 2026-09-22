package peerprep;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests the Course class.
 * 
 */

public class CourseTest {
    /** Tests that a valid study group can be added. */
    @Test
    public void addStudyGroupAddsValidGroup() {
        
        Course course = new Course("CS 2114");
        Student creator = new Student("Alexander", "secret");
        
        StudyGroup group = new StudyGroup("Exam Review", "Inheritance", "discord", creator);

        course.addStudyGroup(group);

        assertEquals(1, course.getStudyGroupCount());
        
        assertEquals(group, course.getStudyGroups().get(0));
    }

    /** Tests that a null group is not added. */
    @Test
    public void addStudyGroupIgnoresNull() {
        Course course = new Course("CS 2114");
        
        course.addStudyGroup(null);
        
        assertEquals(0, course.getStudyGroupCount());
    }
}
