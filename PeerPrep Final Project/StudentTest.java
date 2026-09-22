package peerprep;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests the Student class.
 */
public class StudentTest {
    /** Tests that getUsername returns the stored username. */
    
    @Test
    public void getUsernameReturnsUsername() {
        
        Student student = new Student("Alexander", "secret");
        
        assertEquals("Alexander", student.getUsername());
    }

    /** Tests that the correct password is accepted. */
    @Test
    public void checkPasswordAcceptsCorrectPassword() {
        
        Student student = new Student("Alexander", "secret");
        
        assertTrue(student.checkPassword("secret"));
    }

    /** Tests that an incorrect password is rejected. */
    
    @Test
    public void checkPasswordRejectsWrongPassword() {
        Student student = new Student("Alexander", "secret");
        assertFalse(student.checkPassword("wrong"));
    }
}
