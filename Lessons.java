import java.util.Arrays;

/**
 * This interface holds all the properties of the lesson types
 * This interface is implemented by XXX
 * 
 * @1.0.0
 */
public class Lessons
{
    private int lid;
    private String day; // <1>
    private String time;
    private String lessonname;
    private float price;
    protected boolean available;
    protected int studentMax;
    protected int[] studentIDInClass;
    protected int numberOfStudentsInClass;
    
    // Constructor of class Lesson
    public Lessons(String day, String time, String lessonname, float price, boolean available ) {
        this.lid = lid;
        this.day = day;
        this.time = time;
        this.lessonname = lessonname;
        this.price = price;
        this.available = available;
        this.numberOfStudentsInClass = 0;
        this.studentIDInClass = new int[3];
    }
    
    public void setLID(int newLID)
    {
        this.lid = newLID;
    }
    
    public int getLID()
    {
        return this.lid;
    }
    
    public void setDay(String newDay)
    {
        this.day = newDay;
    }
    
    public String getDay()
    {
        return this.day;
    }
    
    public void setTime(String newTime)
    {
        this.time = newTime;
    }
    
    public String getTime()
    {
        return this.time;
    }
    
    public void setLessonName(String newLessonName)
    {
        this.lessonname = newLessonName;
    }
    
    public String getLessonName()
    {
        return this.lessonname;
    }
    
    public void setPrice(float newPrice)
    {
        this.price = newPrice;
    }
    
    public float getPrice()
    {
        return this.price;
    }
    
    public void setAvailable(boolean newAvailable)
    {
        this.available = newAvailable;
    }
    
    public boolean getAvailable()
    {
        return this.available;
    }
    
    public void setStudentMax(int newStudentMax)
    {
        this.studentMax = newStudentMax;
    }
    
    public int getStudentMax()
    {
        return this.studentMax;
    }
    
    public void setStudentsInClass(int newSID)
    {
        
        int[] newStudentIDInClass = this.studentIDInClass;
        try { //<2>
            newStudentIDInClass[numberOfStudentsInClass] = newSID; //<3>
            this.numberOfStudentsInClass += 1; //<4>
            this.studentIDInClass = newStudentIDInClass;
            System.out.println("Did it work?");
        } catch (Exception e) { //<5>
            System.out.println("Could not add another book. Something went wrong."); //<6>
        }
        
    }
    
}
