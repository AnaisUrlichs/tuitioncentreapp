

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SystemManagementTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SystemManagementTest
{
    /**
     * Default constructor for test class SystemManagementTest
     */
    public SystemManagementTest(SystemManagement sm)
    {
        StudentData sd15 = new StudentData(0, "Kiara Bishof", "female", 01012001, "Flower Lane", "93838376263", "", false);
        sm.addStudent(sd15);
        StudentData sd1 = new StudentData(1, "Holly Berry", "female", 23052000, "Hollywood Lane", "2635273443", "", false);
        sm.addStudent(sd1);
        StudentData sd2 = new StudentData(2, "Andrew Jones", "male", 20082002, "Apple Lane", "37483623455", "", false);
        sm.addStudent(sd2);
        StudentData sd3 = new StudentData(3, "Matilde Holland", "female", 01072000, "Cherry Lane", "47364775554", "", false);
        sm.addStudent(sd3);
        StudentData sd4 = new StudentData(4, "Margaux Paris", "female", 14122001, "Woodland Lane", "1233344567", "", false);
        sm.addStudent(sd4);
        StudentData sd5 = new StudentData(5, "Jonny John", "male", 22012000, "Long Lane", "88874636732", "", false);
        sm.addStudent(sd5);
        StudentData sd6 = new StudentData(6, "William Wills", "male", 04042001, "Short Lane", "363737844473", "", false);
        sm.addStudent(sd6);
        StudentData sd7 = new StudentData(7, "Rupert Rut", "male", 30052000, "Banana Avenue", "36352637463", "", false);
        sm.addStudent(sd7);
        StudentData sd8 = new StudentData(8, "Hannah Riggins", "female", 11102002, "Upside Lane", "64747463253", "", false);
        sm.addStudent(sd8);
        StudentData sd9 = new StudentData(9, "Chris Short", "male", 15032001, "Sunrise Lane", "1234345567", "", false);
        sm.addStudent(sd9);
        StudentData sd10 = new StudentData(10, "David Strtton", "male", 21062000, "Sunset Avenue", "9938473632", "", false);
        sm.addStudent(sd10);
        StudentData sd11 = new StudentData(11, "Anna Flanagan", "female", 02102002, "Hollywood Lane", "3363737362", "", false);
        sm.addStudent(sd11);
        StudentData sd12 = new StudentData(12, "Kunal Menahem", "male", 23052000, "Slow Lane", "26383894635", "", false);
        sm.addStudent(sd12);
        StudentData sd13 = new StudentData(13, "Alex Diri", "male", 01022002, "Fast Lane", "26263839444", "", false);
        sm.addStudent(sd13);
        StudentData sd14 = new StudentData(14, "Arthur Hofesh", "male", 17082000, "Riverside Lane", "123444934567", "", false);
        sm.addStudent(sd14);
    }

    public void testBookLessons(SystemManagement sm) {
        sm.bookLesson(7, 3);
        sm.bookLesson(2, 3);
        sm.bookLesson(5, 3);
        sm.bookLesson(6, 3);
        sm.bookLesson(9, 1);
        
        boolean isLessonAvailable = sm.lessonArray[3].getAvailable();
        
        boolean expectedAvailable = false;
        
        assertEquals( expectedAvailable, isLessonAvailable );
        System.out.println("\n Test 1: After filling lesson Non Verbal Reasoning with 4 students, it is no longer available. The expected value " + expectedAvailable + " and the returnvalue " + isLessonAvailable);
    }
    
    public void testAddBook(SystemManagement sm) {
        sm.addBook(4, "");
        sm.addBook(4, "");
        sm.addBook(8, "");
        sm.addBook(10, "");
        sm.addBook(11, "");
        sm.addBook(14, "");
    }
    
    public void testMarkPresent(SystemManagement sm) {
        sm.markStudentPresent("Rupert Rut");
        sm.markStudentPresent("Andrew Jones");
        
        int studentPosition = sm.findStudent("Andrew Jones");
        boolean isPresent = sm.studentArray[studentPosition].getPresent();
        boolean expectedPresent = true;
        
        assertEquals( expectedPresent, isPresent);
        
        System.out.println("\n Test 3: Student Andrew Jones has been marked present. This is the value in their student record: " + isPresent + " This was the expected value " + expectedPresent);
    }

    public void testPrintReport(SystemManagement sm) {
        sm.printReport();
        int actualReportSize = sm.reportList;
        int expectedReportSize = 5;
        System.out.println("\n Test 4: The report has in totel this many books " + actualReportSize + " and the expected value is " + expectedReportSize);
    }
    
    @Test
    public void test(SystemManagement sm) {
        testBookLessons(sm);
        testAddBook(sm);
        testMarkPresent(sm);
        //testPrintReport(sm);
        System.out.println("Tests are done");
    }
}
