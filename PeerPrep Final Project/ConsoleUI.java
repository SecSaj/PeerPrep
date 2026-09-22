package peerprep;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles console input, menus, and messages for PeerPrep.
 */
public class ConsoleUI {
    /** Reads input from the console. */
    private Scanner scanner;
    

    /** Handles registration and sign in. */
    private AuthService authService;
    

    /** Stores and searches valid courses. */
    private CourseCatalog courseCatalog;
    

    /** Handles study group operations. */
    private StudyGroupService studyGroupService;
    

    
    /** The student who is currently signed in. */
    private Student currentStudent;

    /**
     * Creates the console interface using the application services.
     *
     * @param authService the authentication service
     * 
     * @param courseCatalog the course catalog
     * @param studyGroupService the study group service
     */
    public ConsoleUI(AuthService authService, CourseCatalog courseCatalog,
                     StudyGroupService studyGroupService) {
        scanner = new Scanner(System.in);
        this.authService = authService;
        
        this.courseCatalog = courseCatalog;
        
        this.studyGroupService = studyGroupService;
        
        currentStudent = null;
    }

    /**
     * Starts the main application loop.
     */
    public void run() {
        boolean running = true;
        
        System.out.println("Welcome to PeerPrep!");
        

        while (running) {
            if (currentStudent == null) {
                running = signedOutMenu();
            } else {
                signedInMenu();
            }
        }

        System.out.println("Goodbye.");
    }

    /**
     * Displays the menu used while no student is signed in.
     *
     * @return false when the user chooses to exit, true otherwise
     */
    private boolean signedOutMenu() {
        System.out.println();
        
        System.out.println("1. Register");
        System.out.println("2. Sign in");
        System.out.println("3. Exit");

        int choice = readNumber("Choose an option: ");

        if (choice == 1) {
            register();
            
        } else if (choice == 2) {
            signIn();
            
        } else if (choice == 3) {
            return false;
            
        } else {
            
            System.out.println("Invalid option.");
        }
        return true;
    }

    /**
     * Displays the menu used while a student is signed in.
     */
    
    private void signedInMenu() {
        System.out.println();
        
        System.out.println("Signed in as " + currentStudent.getUsername());
        
        System.out.println("1. Create study group");
        
        System.out.println("2. Find/view study groups");
        
        System.out.println("3. Log out");

        int choice = readNumber("Choose an option: ");

        if (choice == 1) {
            createGroup();
        } 
        else if (choice == 2) {
            findGroups();
        } 
        else if (choice == 3) {
            currentStudent = null;
            System.out.println("Logged out.");
        } 
        else {
            System.out.println("Invalid option.");
        }
    }

    /**
     * Reads registration information and attempts to register a student.
     */
    private void register() {
        System.out.println();
        
        System.out.println("Usernames must be 8-14 letters only.");
        
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        
        String password = scanner.nextLine();

        if (authService.register(username, password)) {
            
            System.out.println("Registration successful.");
        } else {
            System.out.println("Registration failed. Check the username rules or try a different username.");
        }
    }

    /**
     * Reads login information and attempts to sign in a student.
     */
    private void signIn() {
        System.out.println();
        System.out.print("Username: ");
        
        String username = scanner.nextLine();
        
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Student student = authService.authenticate(username, password);
        
        if (student == null) {
            System.out.println("Incorrect username or password.");
        } else {
            currentStudent = student;
            
            System.out.println("Sign in successful.");
        }
    }

    /**
     * Reads group information and attempts to create a study group.
     */
    private void createGroup() {
        System.out.println();
        System.out.print("Course code: ");
        
        String courseCode = scanner.nextLine();

        if (courseCatalog.findCourse(courseCode) == null) {
            
            System.out.println("Invalid course code.");
            return;
        }

        System.out.print("Group name: ");
        String groupName = scanner.nextLine();
        System.out.print("Topic: ");
        
        String topic = scanner.nextLine();
        System.out.print("Communication link: ");
        
        String link = scanner.nextLine();

        boolean created = studyGroupService.createStudyGroup(
                courseCode, groupName, topic, link, currentStudent);

        if (created) {
            System.out.println("Study group created.");
        } else {
            System.out.println("Study group was not created. All fields are required.");
        }
    }

    /**
     * Lists study groups for a course and allows the student to join one.
     */
    private void findGroups() {
        System.out.println();
        System.out.print("Course code: ");
        String courseCode = scanner.nextLine();
        

        if (courseCatalog.findCourse(courseCode) == null) {
            System.out.println("Invalid course code.");
            
            return;
        }

        ArrayList<StudyGroup> groups = studyGroupService.listGroups(courseCode);
        if (groups.size() == 0) {
            System.out.println("No groups are available for this course.");
            
            return;
        }

        System.out.println("Available groups:");
        for (int i = 0; i < groups.size(); i++) {
            StudyGroup group = groups.get(i);
            
            System.out.println((i + 1) + ". " + group.getGroupName()
                    + " - " + group.getTopic());
        }

        int groupNumber = readNumber("Choose a group number: ");
        StudyGroup selected = studyGroupService.selectGroup(courseCode, groupNumber);

        if (selected == null) {
            System.out.println("Invalid group number.");
            
            return;
            
        }

        showGroup(selected);
        
        System.out.print("Join this group? (y/n): ");
        String answer = scanner.nextLine();

        // Join the selected group if the student chooses yes.
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            joinSelectedGroup(selected);
        }    }
    
    /**
     * Allows the current student to join the selected study group.
     * A new member can see the other members and communication link.
     * 
     * An existing member only sees the communication link.
     *
     * @param selectedGroup the study group selected by the student
     */
    private void joinSelectedGroup(StudyGroup selectedGroup) {

        // Check whether the student is already in the group.
        if (selectedGroup.hasMember(currentStudent)) {

            // Existing members only receive the communication link.
            System.out.println("\nCommunication link:");
            System.out.println(selectedGroup.getCommunicationLink());
            return;
        }

        
        // Add the current student to the group.
        if (studyGroupService.joinGroup(selectedGroup, currentStudent)) {

            System.out.println("You joined the group!");
            

            // Display the other members of the group.
            
            System.out.println("\nOther members:");

            boolean foundOtherMember = false;

            for (Student member : selectedGroup.getMembers()) {

                // Do not display the current student's own username.
                if (!member.getUsername().equals(
                        currentStudent.getUsername())) {
                    

                    System.out.println("- " + member.getUsername());
                    foundOtherMember = true;
                    
                }
            }

            // Display this if nobody else is in the group.
            if (!foundOtherMember) {
                System.out.println("No other members yet.");
            }

            // Display the external communication link.
            System.out.println("\nCommunication link:");
            System.out.println(selectedGroup.getCommunicationLink());
            
        }
    }
    
    
    
    /**
     * Displays the basic information for one study group.
     *
     *
     * @param group the study group to display
     */
    private void showGroup(StudyGroup group) {

        // Display basic information before the student joins.
        System.out.println();
        System.out.println("Group: " + group.getGroupName());
        System.out.println("Topic: " + group.getTopic());
        
    }
    
    /**
     * Reads a whole number and keeps asking after invalid numeric input.
     * 
     *
     * @param message the prompt shown to the user
     * @return the whole number entered by the user
     */
    
    private int readNumber(String message) {
        while (true) {
            
            System.out.print(message);
            
            String input = scanner.nextLine();

            try {
                
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }
}
