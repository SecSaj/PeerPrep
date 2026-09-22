package peerprep;

import java.util.ArrayList;

/**
 * Represents one study group in PeerPrep.
 */
public class StudyGroup {
    /** The name of the study group. */
    private String groupName;
    

    /** The main topic of the study group. */
    private String topic;
    

    /** The communication link for the study group. */
    private String communicationLink;
    

    /** The student who created the study group. */
    private Student creator;
    

    /** The students who belong to the study group. */
    private ArrayList<Student> members;

    /**
     * Creates a study group and adds the creator as the first member.
     *
     * @param groupName the study group name
     * @param topic the study topic
     * 
     * @param communicationLink the group's communication link
     * @param creator the student creating the group
     * 
     */
    public StudyGroup(String groupName, String topic, String communicationLink, Student creator) {
        this.groupName = groupName;
        
        this.topic = topic;
        
        this.communicationLink = communicationLink;
        
        this.creator = creator;
        
        members = new ArrayList<Student>();

        if (creator != null) {
            
            members.add(creator);
            
        }
    }

    /**
     * Returns the study group name.
     *
     * @return the group name
     */
    
    public String getGroupName() {
        return groupName;
        
    }

    /**
     * Returns the study group's topic.
     *
     * @return the topic
     */
    public String getTopic() {
        
        return topic;
        
    }

    /**
     * Returns the group's communication link.
     *
     * @return the communication link
     */
    public String getCommunicationLink() {
        return communicationLink;
        
    }
    

    /**
     * Returns the student who created the group.
     *
     * @return the creator
     */
    
    public Student getCreator() {
        return creator;
    }

    /**
     * Returns the students who belong to the group.
     *
     * @return the member list
     */
    
    public ArrayList<Student> getMembers() {
        return members;
    }

    /**
     * Checks whether a student is already a member of the group.
     *
     * @param student the student to look for
     * 
     * @return true if the student is already a member, false otherwise
     */
    public boolean hasMember(Student student) {
        if (student == null) {
            
            return false;
            
            
        }

        for (int i = 0; i < members.size(); i++) {
            
            Student member = members.get(i);
            
            if (member.getUsername().equalsIgnoreCase(student.getUsername())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a student if the student is not already a member.
     *
     * @param student the student to add
     * @return true if the student was added, false otherwise
     */
    public boolean addMember(Student student) {
        if (student == null || hasMember(student)) {
            return false;
        }
        members.add(student);
        return true;
    }

    /**
     * Returns the number of students in the group.
     *
     * @return the number of members
     */
    public int getMemberCount() {
        return members.size();
    }
}
