package peerprep;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 * 
 * Tests the AuthService class.
 */

public class AuthServiceTest {
    /** Tests that a valid student can register. */
    
    @Test
    public void registerAcceptsValidUser() {
        
        AuthService service = new AuthService();
        assertTrue(service.register("Alexander", "secret"));
        
    }

    
    /** Tests that invalid usernames are rejected. */
    @Test
    
    public void registerRejectsBadUsername() {
        
        AuthService service = new AuthService();
        assertFalse(service.register("bob123", "secret"));
        
        assertFalse(service.register("Short", "secret"));
        
    }

    /** Tests that a duplicate username is rejected. */
    @Test
    public void registerRejectsDuplicateUsername() {
        AuthService service = new AuthService();
        assertTrue(service.register("Alexander", "secret"));
        
        assertFalse(service.register("Alexander", "other"));
    }
    

    /** Tests successful authentication. */
    @Test
    
    public void authenticateReturnsStudentForCorrectLogin() {
        AuthService service = new AuthService();
        
        service.register("Alexander", "secret");

        Student student = service.authenticate("Alexander", "secret");
        assertNotNull(student);
        
    }

    /** Tests that an incorrect password is rejected. */
    
    @Test
    
    public void authenticateRejectsWrongPassword() {
        AuthService service = new AuthService();
        
        service.register("Alexander", "secret");
        

        assertNull(service.authenticate("Alexander", "wrong"));
    }
}
