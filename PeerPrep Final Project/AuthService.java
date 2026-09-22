package peerprep;

import java.util.ArrayList;

/**
 * Handles student registration and authentication.
 */
public class AuthService
{
    /**
     * The registered students.
     */
    private ArrayList<Student> students;

    /**
     * Creates an empty authentication service.
     */

    public AuthService()
    {
        students = new ArrayList<Student>();
    }


    /**
     * Registers a student if the username and password are valid.
     *
     * @param username
     *            the requested username
     * @param password
     *            the requested password
     * @return true if registration succeeds, false otherwise
     */
    public boolean register(String username, String password)
    {
        if (!validUsername(username))
        {
            return false;
        }

        if (password == null || password.trim().length() == 0)
        {
            return false;
        }

        if (findStudent(username) != null)
        {
            return false;
        }

        Student newStudent = new Student(username.trim(), password);
        students.add(newStudent);
        return true;

    }


    /**
     * Authenticates a username and password.
     *
     * @param username
     *            the username to check
     * @param password
     *            the password to check
     * @return the matching student, or null if authentication fails
     */
    public Student authenticate(String username, String password)
    {
        Student student = findStudent(username);

        if (student != null && student.checkPassword(password))
        {
            return student;

        }
        return null;
    }


    /**
     * Checks whether a username follows the project rules.
     *
     * @param username
     *            the username to validate
     * @return true if the username is valid, false otherwise
     */
    private boolean validUsername(String username)
    {
        if (username == null)
        {
            return false;

        }

        String name = username.trim();
        if (name.length() < 8 || name.length() > 14)
        {
            return false;
        }

        for (int i = 0; i < name.length(); i++)
        {
            char letter = name.charAt(i);
            if (!Character.isLetter(letter))
            {
                return false;
            }
        }

        return true;
    }


    /**
     * Finds a registered student by username.
     * 
     * @param username
     *            the username to find
     * @return the matching student, or null if no match exists
     */
    private Student findStudent(String username)
    {

        if (username == null)
        {
            return null;

        }

        String name = username.trim();

        for (int i = 0; i < students.size(); i++)
        {
            Student student = students.get(i);

            if (student.getUsername().equalsIgnoreCase(name))
            {
                return student;
            }

        }

        return null;
    }
}
