package peerprep;

import java.util.ArrayList;

/**
 * Handles study group creation, listing, selection, and joining.
 */
public class StudyGroupService {
    
    /** The course catalog used to find courses. */
    private CourseCatalog courseCatalog;
    

    /**
     * Creates a study group service using the given course catalog.
     * 
     *
     * @param courseCatalog the course catalog to use
     */
    public StudyGroupService(CourseCatalog courseCatalog) {
        
        this.courseCatalog = courseCatalog;
    }

    /**
     * Creates a study group when all required information is valid.
     *
     * @param courseCode the course code
     * @param groupName the group name
     * @param topic the study topic
     * @param communicationLink the communication link
     * @param creator the student creating the group
     * @return true if the group is created, false otherwise
     */
    public boolean createStudyGroup(String courseCode, String groupName, String topic,
                                    String communicationLink, Student creator) {
        Course course = courseCatalog.findCourse(courseCode);

        if (course == null || creator == null) {
            return false;
            
        }
        if (isBlank(groupName) || isBlank(topic) || isBlank(communicationLink)) {
            return false;
        }

        
        
        StudyGroup group = new StudyGroup(groupName.trim(), topic.trim(),
                communicationLink.trim(), creator);
        course.addStudyGroup(group);
        
        return true;
    }

    /**
     * Returns the study groups for a course.
     *
     * @param courseCode the course code
     * 
     * @return the course's study groups, or an empty list for an invalid course
     */
    
    public ArrayList<StudyGroup> listGroups(String courseCode) {
        Course course = courseCatalog.findCourse(courseCode);

        if (course == null) {
            
            return new ArrayList<StudyGroup>();
        }
        
        return course.getStudyGroups();
    }

    /**
     * Selects a study group using the number shown to the user.
     *
     * @param courseCode the course code
     * 
     * @param groupNumber the displayed group number
     * 
     * @return the selected group, or null if the number is invalid
     */
    public StudyGroup selectGroup(String courseCode, int groupNumber) {
        ArrayList<StudyGroup> groups = listGroups(courseCode);
        

        
        if (groupNumber < 1 || groupNumber > groups.size()) {
            return null;
        }
        return groups.get(groupNumber - 1);
    }

    /**
     * Adds a student to a study group.
     *
     * @param group the study group to join
     * 
     * @param student the student joining the group
     * 
     * @return true if the student is added, false otherwise
     */
    public boolean joinGroup(StudyGroup group, Student student) {
        if (group == null || student == null) {
            
            return false;
            
        }
        return group.addMember(student);
    }

    /**
     * Checks whether text is null or empty after trimming.
     * 
     * @param text the text to check
     * @return true if the text is blank, false otherwise
     */
    private boolean isBlank(String text) {
        
        return text == null || text.trim().length() == 0;
    }
}
