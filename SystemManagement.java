
/**
 * Write a description of class Bookings here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SystemManagement
{
    protected StudentData[] studentArray; // <1>
    protected Lessons[] lessonArray;
    protected int currentSize;
    private int maximumSize;
    protected int lessonListSize;
    protected int reportList;
    
    // Constructor of SystemManagement
    public SystemManagement(int maximumSize, int currentSize) {
        studentArray = new StudentData[maximumSize]; // <2>
        this.maximumSize = maximumSize;
        this.currentSize = currentSize;
        this.lessonListSize = 0;
        this.lessonArray = createLessons();
        this.reportList = 0;
    }
    
    // the main class
    public static void main(String args[]) { 
       SystemManagement sm = new SystemManagement(1000, 0);
       SystemManagementTest smt = new SystemManagementTest(sm);
       smt.test(sm);
    }
    
    public Lessons[] createLessons() 
    {
        lessonArray = new Lessons[5];
        Lessons l1 = new Lessons("Saturday", "morning", "English", 20, true);
        addLesson(l1); 
        Lessons l2 = new Lessons("Saturday", "afternoon", "Math", 30, true);
        addLesson(l2); 
        Lessons l3 = new Lessons("Saturday", "evening", "Verbal Reasoning", 20, true);
        addLesson(l3); 
        Lessons l4 = new Lessons("Sunday", "morning", "Non Verbal Reasoning", 25, true);
        addLesson(l4); 
        Lessons l5 = new Lessons("Sunday", "afternoon", "Math", 30, true);
        addLesson(l5); 
        Lessons l6 = new Lessons("Sunday", "evening", "English", 20, true);
        addLesson(l6); 
        return lessonArray;
    }
    
    public void addLesson(Lessons lesson) {
        if (lessonListSize < 7) { 
            try { 
                lessonArray[lessonListSize] = lesson; 
                lessonListSize += 1; 
                System.out.println("Lesson added ");
            } catch (Exception e) { 
                System.out.println("Could not add another lesson. Something went wrong.");
            }
        } else {
            System.out.println("You have reached the maximum number lessons that can be added"); 
        }
    }
    
    public void addStudent(StudentData item) {
        if (currentSize < maximumSize) { //<1>
            try { //<2>
                studentArray[currentSize] = item;
                currentSize += 1;
            } catch (Exception e) {
                System.out.println("Could not add another student. Something went wrong."); 
            }
        } else {
            System.out.println("You have reached the maximum number of students that can be added");
        }
    }
    
    public void bookLesson(int studentID, int lessonID ) {
        boolean isAvailable = lessonArray[lessonID].getAvailable();
        int studentMax = lessonArray[lessonID].getStudentMax();
        
        if (isAvailable == true){
            
            lessonArray[lessonID].setStudentsInClass(studentID);
            
            int newStudentMax = studentMax + 1;
            lessonArray[lessonID].setStudentMax(newStudentMax);
            
            if (newStudentMax == 4){
                lessonArray[lessonID].setAvailable(false);
            }else {
                System.out.println("More students can join this lesson");
            };
            
        } else {
            System.out.println("Sorry, this lesson is fully booked");
        }
    }
    
    public void addBook(int studentID, String newBook) {
        try {
            studentArray[studentID].setBookList(newBook);
        } catch (Exception e) {
            System.out.println("Could not add the book to the student record. Something went wrong.");
        }
    }
    
    public void markStudentPresent(String toFind) {
        try {
            int studentPosition = findStudent(toFind); 
            studentArray[studentPosition].setPresent(true);
        } catch (Exception e) {
            System.out.println("Could not add the book to the student record. Something went wrong.");
        }
    }
    
    public void delete(String toFind) {
        try {
            int indexToDelete = findStudent(toFind); // <1>
            deleteItem(indexToDelete); // <2>
        } catch (Exception e) {
            System.out.println("Could not delete item from the list. Something went wrong.");
        }
    }

    public int findStudent(String toFind) {
    
        for (int i = 0; i < currentSize; i += 1) {
            String title = studentArray[i].getName(); // <1>
            if (toFind == title) {  // <2>
                return i;
            }
        }
    
        return -1;
    }
    
    public void deleteItem(int index) {
        if (index < 0 || index >= currentSize) { // <1>
            System.out.println("Error in delete: index is out of bounds"); // <2>
            return;
        }

        for (int i=index; i<currentSize; i=i+1) { // <3>
            studentArray[i] = studentArray[i+1]; // <4>
        }
        currentSize = currentSize - 1; // <5>
    }
    
    public String printReport() {
        String report = "\n These are the required books: \n"; 
        
        if ( currentSize <= 0) { 
            report = report + "No students registered";
            return report;
        }
        
        for (int i=0; i<currentSize; i=i+1) { 
            
            int numberOfBooksForStudent = studentArray[i].getNumberOfBooks();
            
            if (numberOfBooksForStudent > 0) {
                StudentData currentStudent = studentArray[i]; 
                int id = currentStudent.getSID();
                String name = currentStudent.getName();
                String books = currentStudent.getBooksString();
          
                report = report + "Books for " + id + ", " + name + ", are:" + books; 
                reportList += 1;
            }
            
            if (i+1<currentSize) { // <8>
              report = report + ",\n";
            }
        }    
        
        System.out.println(report); 

        return report; 
    }
}
