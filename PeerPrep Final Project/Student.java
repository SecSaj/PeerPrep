package peerprep;

/**
 * Represents a registered PeerPrep student.
 */

public class Student {
    
    /** The student's username. */
    private String username;
    

    
    /** The student's password. */
    private String password;
    

    /**
     * 
     * Creates a student with a username and password.
     *
     *
     * @param username the student's username
     * @param password the student's password
     */
    public Student(String username, String password) {
        
        this.username = username;
        
        this.password = password;
        
    }

    /**
     * Returns the student's username.
     *
     * @return the username
     */
    public String getUsername() {
        
        return username;
    }

    /**
     * Checks whether a password matches the stored password.
     *
     * @param enteredPassword the password to check
     * @return true if the password matches, false otherwise
     */
    public boolean checkPassword(String enteredPassword) {
        
        if (enteredPassword == null) {
            
            return false;
            
        }
        return this.password.equals(enteredPassword);
    }
}
