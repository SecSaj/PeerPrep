package peerprep;

import java.util.ArrayList;

/**
 * 
 * Represents a course and its study groups.
 */
public class Course {
    /** The course code. */
    
    private String courseCode;

    /** The study groups that belong to this course. */
    private ArrayList<StudyGroup> studyGroups;
    

    /**
     * Creates a course with the given course code.
     *
     *
     * @param courseCode the course code
     */
    public Course(String courseCode) {
        this.courseCode = courseCode;
        
        studyGroups = new ArrayList<StudyGroup>();
    }
    

    /**
     * Returns the course code.
     *
     * @return the course code
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Adds a study group to this course if the group is not null.
     * 
     *
     * @param group the study group to add
     */
    public void addStudyGroup(StudyGroup group) {
        
        
        if (group != null) {
            studyGroups.add(group);
        }
    }

    /**
     * 
     * Returns the study groups for this course.
     *
     * @return the list of study groups
     * 
     */
    public ArrayList<StudyGroup> getStudyGroups() {
        
        return studyGroups;
    }

    /**
     * Returns the number of study groups for this course.
     * 
     *
     *
     * @return the number of study groups
     */
    public int getStudyGroupCount() {
        return studyGroups.size();
    }
}
