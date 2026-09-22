package peerprep;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * Tests the StudyGroupService class.
 */
public class StudyGroupServiceTest {
    /** Tests that a valid study group can be created. */
    @Test
    public void createStudyGroupCreatesValidGroup() {
        
        CourseCatalog catalog = new CourseCatalog();
        
        StudyGroupService service = new StudyGroupService(catalog);
        
        Student creator = new Student("Alexander", "secret");
        

        boolean result = service.createStudyGroup(
            
                "CS 2114", "Exam Review", "Inheritance", "discord", creator);

        assertTrue(result);
        
        assertEquals(1, service.listGroups("CS 2114").size());
    }

    /** Tests that a missing group name is rejected. */
    @Test
    public void createStudyGroupRejectsMissingName() {
        
        CourseCatalog catalog = new CourseCatalog();
        
        StudyGroupService service = new StudyGroupService(catalog);
        
        Student creator = new Student("Alexander", "secret");

        assertFalse(service.createStudyGroup(
            
                "CS 2114", "", "Inheritance", "discord", creator));
    }

    /** Tests that a course with no groups returns an empty list. */
    @Test
    
    public void listGroupsReturnsEmptyListWhenNoGroupsExist() {
        CourseCatalog catalog = new CourseCatalog();
        
        StudyGroupService service = new StudyGroupService(catalog);

        ArrayList<StudyGroup> groups = service.listGroups("CS 2114");
        assertEquals(0, groups.size());
    }

    /** Tests that a valid group number selects a group. */
    @Test
    public void selectGroupReturnsCorrectGroup() {
        CourseCatalog catalog = new CourseCatalog();
        
        StudyGroupService service = new StudyGroupService(catalog);
        
        Student creator = new Student("Alexander", "secret");
        
        service.createStudyGroup("CS 2114", "Exam Review", "Inheritance", "discord", creator);

        assertNotNull(service.selectGroup("CS 2114", 1));
    }

    /** Tests that an invalid group number is rejected. */
    @Test
    public void selectGroupRejectsBadNumber() {
        
        CourseCatalog catalog = new CourseCatalog();
        
        StudyGroupService service = new StudyGroupService(catalog);

        assertNull(service.selectGroup("CS 2114", 5));
    }

    /** Tests that a student cannot join the same group twice. */
    @Test
    
    public void joinGroupRejectsDuplicateMember() {
        CourseCatalog catalog = new CourseCatalog();
        
        StudyGroupService service = new StudyGroupService(catalog);
        
        Student creator = new Student("Alexander", "secret");
        
        service.createStudyGroup("CS 2114", "Exam Review", "Inheritance", "discord", creator);
        StudyGroup group = service.selectGroup("CS 2114", 1);
        

        assertFalse(service.joinGroup(group, creator));
        
        assertEquals(1, group.getMemberCount());
    }
}
