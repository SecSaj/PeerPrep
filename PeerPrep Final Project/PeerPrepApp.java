package peerprep;

/**
 * Starts the PeerPrep application.
 */
public class PeerPrepApp {
    /**
     * Creates the application components and starts the console interface.
     *
     * @param args command-line arguments; they are not used
     */
    public static void main(String[] args) {
        
        AuthService authService = new AuthService();
        
        CourseCatalog courseCatalog = new CourseCatalog();
        
        StudyGroupService studyGroupService = new StudyGroupService(courseCatalog);
        
        ConsoleUI consoleUI = new ConsoleUI(authService, courseCatalog, studyGroupService);

        consoleUI.run();
        
    }
}
