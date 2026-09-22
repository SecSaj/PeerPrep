# PeerPrep

PeerPrep is a basic Java console application that allows VT students to create accounts, find study groups for courses, create study groups, and join existing groups.

## Features

* Register a student account
* Sign in with a username and password
* Search for valid Virginia Tech courses
* Create a study group
* View available study groups
* Join a study group
* View other group members after joining
* View the group's external communication link
* Prevent a student from joining the same group more than once
* Handle invalid input without crashing

## How to Run

1. Download the repo as a ZIP
2. Extract the ZIP file
3. Open the `PeerPrep` project in Eclipse.
4. Make sure all Java files are inside the `peerprep` package.
5. Open `PeerPrepApp.java`.
6. Right-click `PeerPrepApp.java`.
7. Select **Run As → Java Application**.
8. The program will run in the Eclipse Console.

## How to Run the JUnit Tests

1. Make sure JUnit 5 is added to the project's build path.
2. Open a JUnit test class.
3. Right-click the test class.
4. Select **Run As → JUnit Test**.
5. The JUnit window should show green when the tests pass.

## Main Classes

* `PeerPrepApp` - Starts the program and creates the main application components.
* `ConsoleUI` - Handles menus, user input, and messages.
* `AuthService` - Handles registration, username validation, and sign in.
* `CourseCatalog` - Stores valid courses and searches for courses by course code.
* `StudyGroupService` - Handles study group creation, listing, selection, and joining.
* `Student` - Represents a registered student.
* `Course` - Represents a course and stores its study groups.
* `StudyGroup` - Represents a study group and stores its members.

## System Design

PeerPrep separates the user interface, application services, and data objects.

* `ConsoleUI` sends registration and sign-in requests to `AuthService`.
* `AuthService` stores registered `Student` objects.
* `ConsoleUI` sends course searches to `CourseCatalog`.
* `CourseCatalog` stores valid `Course` objects.
* `ConsoleUI` sends study-group requests to `StudyGroupService`.
* Each `Course` stores its own `StudyGroup` objects.
* Each `StudyGroup` stores its `Student` members.

## Bad Input Handling

PeerPrep handles:

* Invalid usernames
* Duplicate usernames
* Incorrect login information
* Invalid course codes
* Missing study group information
* Invalid group numbers
* Courses with no study groups
* Duplicate group membership
* Non-numeric menu input

## Tools Used

* Java
* Eclipse
* JUnit 5
