package peerprep;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests the StudyGroup class.
 */
public class StudyGroupTest {
    /** Tests that a new student can join a group. */
    @Test
    public void addMemberAddsNewStudent() {
        Student creator = new Student("Alexander", "secret");
        
        Student student = new Student("Charlotte", "secret");
        
        StudyGroup group = new StudyGroup("Exam Review", "Inheritance", "discord", creator);

        assertTrue(group.addMember(student));
        
        assertTrue(group.hasMember(student));
        
        assertEquals(2, group.getMemberCount());
    }

    /** Tests that the same student cannot be added twice. */
    @Test
    public void addMemberRejectsDuplicateStudent() {
        
        Student creator = new Student("Alexander", "secret");
        
        StudyGroup group = new StudyGroup("Exam Review", "Inheritance", "discord", creator);

        assertFalse(group.addMember(creator));
        
        assertEquals(1, group.getMemberCount());
    }

    /** Tests that a student outside the group is not reported as a member. */
    @Test
    public void hasMemberReturnsFalseForNonMember() {
        
        Student creator = new Student("Alexander", "secret");
        
        Student other = new Student("Charlotte", "secret");
        
        StudyGroup group = new StudyGroup("Exam Review", "Inheritance", "discord", creator);

        assertFalse(group.hasMember(other));
    }
}
