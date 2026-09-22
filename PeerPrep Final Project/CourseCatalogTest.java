package peerprep;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests the CourseCatalog class.
 */
public class CourseCatalogTest {
    /** Tests that a valid course can be found. */
    @Test
    
    public void findCourseReturnsValidCourse() {
        CourseCatalog catalog = new CourseCatalog();
        
        Course course = catalog.findCourse("CS 2114");
        

        
        assertNotNull(course);
        assertEquals("CS 2114", course.getCourseCode());
    }

    
    /** Tests that an invalid course is rejected. */
    @Test
    public void findCourseRejectsInvalidCourse() {
        CourseCatalog catalog = new CourseCatalog();
        
        assertNull(catalog.findCourse("FAKE 9999"));
    }
}
