package peerprep;

import java.util.ArrayList;


/**
 * Stores the valid courses used by PeerPrep.
 * 
 */
public class CourseCatalog

{
    /** The valid courses in the catalog. */
    private ArrayList<Course> courses;
    

    /**
     * Creates the course catalog with a decently large set of valid courses.
     */
    
    public CourseCatalog()
    {
        courses = new ArrayList<Course>();
        
        // AI generated to find example courses from VT departments
        courses.add(new Course("CS 1014"));
        courses.add(new Course("CS 1044"));
        courses.add(new Course("CS 1054"));
        courses.add(new Course("CS 1064"));
        courses.add(new Course("CS 1114"));
        courses.add(new Course("CS 1124"));
        courses.add(new Course("CS 1604"));
        courses.add(new Course("CS 1944"));
        courses.add(new Course("CS 2104"));
        courses.add(new Course("CS 2114"));
        courses.add(new Course("CS 2164"));
        courses.add(new Course("CS 2304"));
        courses.add(new Course("CS 2505"));
        courses.add(new Course("CS 2506"));
        courses.add(new Course("CS 2964"));
        courses.add(new Course("CS 2974"));
        courses.add(new Course("CS 2984"));
        courses.add(new Course("CS 3114"));
        courses.add(new Course("CS 3214"));
        courses.add(new Course("CS 3304"));
        courses.add(new Course("CS 3414"));
        courses.add(new Course("CS 3604"));
        courses.add(new Course("CS 3634"));
        courses.add(new Course("CS 3654"));
        courses.add(new Course("CS 3704"));
        courses.add(new Course("CS 3714"));
        courses.add(new Course("CS 3724"));
        courses.add(new Course("CS 3744"));
        courses.add(new Course("CS 3754"));
        courses.add(new Course("CS 3824"));
        courses.add(new Course("CS 3984"));
        courses.add(new Course("CS 4104"));
        courses.add(new Course("CS 4114"));
        courses.add(new Course("CS 4124"));
        courses.add(new Course("CS 4164"));
        courses.add(new Course("CS 4204"));
        courses.add(new Course("CS 4214"));
        courses.add(new Course("CS 4234"));
        courses.add(new Course("CS 4244"));
        courses.add(new Course("CS 4254"));
        courses.add(new Course("CS 4264"));
        courses.add(new Course("CS 4284"));
        courses.add(new Course("CS 4304"));
        courses.add(new Course("CS 4414"));
        courses.add(new Course("CS 4504"));
        courses.add(new Course("CS 4570"));
        courses.add(new Course("CS 4604"));
        courses.add(new Course("CS 4624"));
        courses.add(new Course("CS 4634"));
        courses.add(new Course("CS 4644"));
        courses.add(new Course("CS 4654"));
        courses.add(new Course("CS 4704"));
        courses.add(new Course("CS 4784"));
        courses.add(new Course("CS 4804"));
        courses.add(new Course("CS 4824"));
        courses.add(new Course("CS 4884"));
        courses.add(new Course("CS 4944"));
        courses.add(new Course("CS 4964"));
        courses.add(new Course("CS 4974"));
        courses.add(new Course("CS 4984"));
        courses.add(new Course("CS 4994"));

        // MASC courses.
        courses.add(new Course("MASC 1024"));
        courses.add(new Course("MASC 1044"));

        // Mathematics courses.
        courses.add(new Course("MATH 1004"));
        courses.add(new Course("MATH 1014"));
        courses.add(new Course("MATH 1025"));
        courses.add(new Course("MATH 1026"));
        courses.add(new Course("MATH 1044"));
        courses.add(new Course("MATH 1114"));
        courses.add(new Course("MATH 1225"));
        courses.add(new Course("MATH 1226"));
        courses.add(new Course("MATH 1454"));
        courses.add(new Course("MATH 1524"));
        courses.add(new Course("MATH 1525"));
        courses.add(new Course("MATH 1526"));
        courses.add(new Course("MATH 1535"));
        courses.add(new Course("MATH 1536"));
        courses.add(new Course("MATH 1614"));
        courses.add(new Course("MATH 1624"));
        courses.add(new Course("MATH 2004"));
        courses.add(new Course("MATH 2024"));
        courses.add(new Course("MATH 2114"));
        courses.add(new Course("MATH 2114H"));
        courses.add(new Course("MATH 2204"));
        courses.add(new Course("MATH 2204H"));
        courses.add(new Course("MATH 2214"));
        courses.add(new Course("MATH 2214H"));
        courses.add(new Course("MATH 2224"));
        courses.add(new Course("MATH 2224H"));
        courses.add(new Course("MATH 2405H"));
        courses.add(new Course("MATH 2406H"));
        courses.add(new Course("MATH 2534"));
        courses.add(new Course("MATH 2644"));
        courses.add(new Course("MATH 2964"));
        courses.add(new Course("MATH 2974"));
        courses.add(new Course("MATH 2974H"));
        courses.add(new Course("MATH 2984"));
        courses.add(new Course("MATH 2984H"));
        courses.add(new Course("MATH 2994"));
        courses.add(new Course("MATH 2994H"));
        courses.add(new Course("MATH 3034"));
        courses.add(new Course("MATH 3054"));
        courses.add(new Course("MATH 3124"));
        courses.add(new Course("MATH 3134"));
        courses.add(new Course("MATH 3144"));
        courses.add(new Course("MATH 3214"));
        courses.add(new Course("MATH 3224"));
        courses.add(new Course("MATH 3414"));
        courses.add(new Course("MATH 3574"));
        courses.add(new Course("MATH 3624"));
        courses.add(new Course("MATH 4044"));
        courses.add(new Course("MATH 4124"));
        courses.add(new Course("MATH 4134"));
        courses.add(new Course("MATH 4144"));
        courses.add(new Course("MATH 4175"));
        courses.add(new Course("MATH 4176"));
        courses.add(new Course("MATH 4225"));
        courses.add(new Course("MATH 4226"));
        courses.add(new Course("MATH 4234"));
        courses.add(new Course("MATH 4245"));
        courses.add(new Course("MATH 4246"));
        courses.add(new Course("MATH 4254"));
        courses.add(new Course("MATH 4324"));
        courses.add(new Course("MATH 4334"));
        courses.add(new Course("MATH 4404"));
        courses.add(new Course("MATH 4414"));
        courses.add(new Course("MATH 4425"));
        courses.add(new Course("MATH 4426"));
        courses.add(new Course("MATH 4445"));
        courses.add(new Course("MATH 4446"));
        courses.add(new Course("MATH 4454"));
        courses.add(new Course("MATH 4564"));
        courses.add(new Course("MATH 4574"));
        courses.add(new Course("MATH 4625"));
        courses.add(new Course("MATH 4626"));
        courses.add(new Course("MATH 4644"));
        courses.add(new Course("MATH 4664"));
        courses.add(new Course("MATH 4754"));
        courses.add(new Course("MATH 4964"));
        courses.add(new Course("MATH 4974"));
        courses.add(new Course("MATH 4974H"));
        courses.add(new Course("MATH 4984"));
        courses.add(new Course("MATH 4994"));
        courses.add(new Course("MATH 4994H"));

        // Physics courses.
        courses.add(new Course("PHYS 1055"));
        courses.add(new Course("PHYS 1056"));
        courses.add(new Course("PHYS 1155"));
        courses.add(new Course("PHYS 1156"));
        courses.add(new Course("PHYS 2074"));
        courses.add(new Course("PHYS 2114"));
        courses.add(new Course("PHYS 2205"));
        courses.add(new Course("PHYS 2206"));
        courses.add(new Course("PHYS 2215"));
        courses.add(new Course("PHYS 2216"));
        courses.add(new Course("PHYS 2305"));
        courses.add(new Course("PHYS 2306"));
        courses.add(new Course("PHYS 2324"));
        courses.add(new Course("PHYS 2325"));
        courses.add(new Course("PHYS 2326"));
        courses.add(new Course("PHYS 2334"));
        courses.add(new Course("PHYS 2344"));
        courses.add(new Course("PHYS 2404"));
        courses.add(new Course("PHYS 2504"));
        courses.add(new Course("PHYS 2964"));
        courses.add(new Course("PHYS 2974"));
        courses.add(new Course("PHYS 2974H"));
        courses.add(new Course("PHYS 2984"));
        courses.add(new Course("PHYS 2994"));
        courses.add(new Course("PHYS 2994H"));
        courses.add(new Course("PHYS 3154"));
        courses.add(new Course("PHYS 3254"));
        courses.add(new Course("PHYS 3314"));
        courses.add(new Course("PHYS 3324"));
        courses.add(new Course("PHYS 3355"));
        courses.add(new Course("PHYS 3356"));
        courses.add(new Course("PHYS 3405"));
        courses.add(new Course("PHYS 3406"));
        courses.add(new Course("PHYS 3655"));
        courses.add(new Course("PHYS 3656"));
        courses.add(new Course("PHYS 3704"));
        courses.add(new Course("PHYS 4224"));
        courses.add(new Course("PHYS 4254"));
        courses.add(new Course("PHYS 4315"));
        courses.add(new Course("PHYS 4316"));
        courses.add(new Course("PHYS 4455"));
        courses.add(new Course("PHYS 4456"));
        courses.add(new Course("PHYS 4504"));
        courses.add(new Course("PHYS 4554"));
        courses.add(new Course("PHYS 4564"));
        courses.add(new Course("PHYS 4574"));
        courses.add(new Course("PHYS 4614"));
        courses.add(new Course("PHYS 4624"));
        courses.add(new Course("PHYS 4654"));
        courses.add(new Course("PHYS 4674"));
        courses.add(new Course("PHYS 4714"));
        courses.add(new Course("PHYS 4755"));
        courses.add(new Course("PHYS 4756"));
        courses.add(new Course("PHYS 4774"));
        courses.add(new Course("PHYS 4964"));
        courses.add(new Course("PHYS 4974"));
        courses.add(new Course("PHYS 4974H"));
        courses.add(new Course("PHYS 4984"));
        courses.add(new Course("PHYS 4994"));
        courses.add(new Course("PHYS 4994H"));

        // Other courses.
        courses.add(new Course("BIT 2164"));
        courses.add(new Course("PSCI 2164"));
        courses.add(new Course("BIT 4164"));
        courses.add(new Course("PSCI 4164"));
        courses.add(new Course("CMDA 3634"));
        courses.add(new Course("CMDA 3654"));
        courses.add(new Course("STAT 3654"));
        courses.add(new Course("CMDA 4654"));
        courses.add(new Course("STAT 4654"));
        courses.add(new Course("ECE 4504"));
        courses.add(new Course("ECE 4570"));
        courses.add(new Course("ECE 4424"));
    }


    /**
     * Finds a course using its course code.
     *
     * @param courseCode
     *            the course code to search for
     * @return the matching course, or null if the course is not found
     */
    
    public Course findCourse(String courseCode)
    
    {
        if (courseCode == null)
            
        {
            return null;
            
        }
        String code = courseCode.trim().toUpperCase();
        

        for (int i = 0; i < courses.size(); i++)
        {
            
            Course course = courses.get(i);
            if (course.getCourseCode().equals(code))
            {
                return course;
            }
            
        }
        return null;
    }
}
