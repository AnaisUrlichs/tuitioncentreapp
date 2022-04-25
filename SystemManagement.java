import java.util.Arrays;

public class SystemManagement
{
    protected StudentData[] studentArray;
    protected Lessons[] lessonArray;
    protected int currentSize;
    private int maximumSize;
    protected int lessonListSize;
    protected int bookReportLength;
    protected int ratingReportLength;
    protected int totalRevenue;
    
    public SystemManagement(int maximumSize, int currentSize) {
        studentArray = new StudentData[maximumSize]; 
        this.maximumSize = maximumSize;
        this.currentSize = currentSize;
        this.lessonListSize = 0;
        this.lessonArray = createLessons();
        this.bookReportLength = 0;
        this.ratingReportLength = 0;
        this.totalRevenue = 0;
    }
    
    // the main class
    public static void main(String args[]) { 
       SystemManagement sm = new SystemManagement(1000, 0);
       SystemManagementTest smt = new SystemManagementTest(sm);
       smt.test(sm);
    }
    
    public Lessons[] createLessons() 
    {
        lessonArray = new Lessons[6];
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
        if (currentSize < maximumSize) { 
            try {
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
            
            if (newStudentMax == 3){
                lessonArray[lessonID].setAvailable(false);
            }else {
                System.out.println("More students can join this lesson.");
            };
            
        } else {
            System.out.println("Sorry, this lesson is fully booked.");
        }
    }
    
    public void addBook(String toFind, String newBook) {
        try {
            int studentPosition = findStudent(toFind); 
            studentArray[studentPosition].setBookList(newBook);
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
            int indexToDelete = findStudent(toFind);
            deleteItem(indexToDelete);
        } catch (Exception e) {
            System.out.println("Could not delete item from the list. Something went wrong.");
        }
    }

    public int findStudent(String toFind) {
    
        for (int i = 0; i < currentSize; i += 1) {
            String title = studentArray[i].getName();
            if (toFind == title) { 
                return i;
            }
        }
    
        return -1;
    }
    
    public void deleteItem(int index) {
        if (index < 0 || index >= currentSize) {
            System.out.println("Error in delete: index is out of bounds");
            return;
        }

        for (int i=index; i<currentSize; i=i+1) { 
            studentArray[i] = studentArray[i+1];
        }
        currentSize = currentSize - 1; 
    }
    
    public int findLesson(String toFind) {
    
        for (int i = 0; i < currentSize; i += 1) {
            String title = lessonArray[i].getLessonName();
            if (toFind == title) {
                return i;
            }
        }
    
        return -1;
    }
    
    public void rateLesson(int lessonID, int rating) {
        if (rating > 0 && rating < 6) {
            try {
                lessonArray[lessonID].setRatings(rating);
            } catch (Exception e) {
                System.out.println("Could not add a rating to the lesson. Something went wrong.");
            }
        } else {
            System.out.println("Could not add the rating, the rating is outside the accepted range.");
        }
    }
    
    public String printLessonRatings() {
        String report = "\n These are the lesson ratings: \n"; 
                        
        for (int i=0; i<6; i=i+1) { 
            
            int numberOfLessonRatings = lessonArray[i].getNumberOfRatings();
            
            if (numberOfLessonRatings > 0) {
                Lessons currentLesson = lessonArray[i]; 
                String lessonName = currentLesson.getLessonName();
                String lessonTime = currentLesson.getTime();
                String ratings = currentLesson.getRatings();
                
                this.ratingReportLength += 1;
          
                report = report + "Ratings for Lesson " + lessonName +", in the " + lessonTime + ", are " + ratings + "\n"; 
            }
        }    
        
        System.out.println(report); 

        return report; 
    }
    
    public void addComment(String comment, String toFind) {
        try {
            int studentPosition = findStudent(toFind); 
            studentArray[studentPosition].setComment(comment);
        } catch (Exception e) {
            System.out.println("Could not add the book to the student record. Something went wrong.");
        }
    }
    
    public String printPriceReport(){
        String report = "\n This is the total amount made from the lessons: \n"; 
        
        for (int i=0; i<6; i=i+1) { 
            
            int numberOfStudentsInClass = lessonArray[i].getNumberOfStudentsInClass();
            int classPrice = lessonArray[i].getPrice();
            String lessonName = lessonArray[i].getLessonName();
            
            if (numberOfStudentsInClass > 0) {
                int totalMoney = numberOfStudentsInClass * classPrice;
                report = report + "Funds collected for lesson " + lessonName + ", is: " + totalMoney + "\n"; 
                
                this.totalRevenue = totalRevenue + totalMoney;
            }            
        }    
        
        report = report + "The total revenue collected for all classes is: " + totalRevenue; 

        System.out.println(report); 

        return report; 
    }
    
    public String printBookReport() {
        String report = "\n These are the required books: \n"; 
        
        if ( currentSize <= 0) { 
            report = report + "No students registered";
            return report;
        }
        
        for (int i=0; i<currentSize; i=i+1) { 
            
            int numberOfBooksForStudent = studentArray[i].getNumberOfBooks();
            
            if (numberOfBooksForStudent > 0) {
                StudentData currentStudent = studentArray[i]; 
                String name = currentStudent.getName();
                String books = currentStudent.getBooksString();
          
                report = report + "Books for " + name + ", are:" + books + "\n"; 
                this.bookReportLength += 1;
            }
        }    
        
        System.out.println(report); 

        return report; 
    }
}
