import java.util.Arrays;

/**
 * Abstract class StudentData - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public class StudentData
{
    private int sid; // <1>
    private String name;
    private String gender;
    private int dob;
    private String address;
    private String number;
    private String comments; 
    private boolean present; 
    protected String[] booklist;
    protected int numberOfBooks;
    
    // Constructor of class LoanItems
    public StudentData(int sid, String name, String gender, int dob, String address, String number, String comments, boolean present ) {
        this.sid = sid;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.number = number;
        this.comments = comments;
        this.present = present;
        this.numberOfBooks = 0;
        this.booklist = new String[15];
    }
    
    public void setSID(int newSID)
    {
        this.sid = newSID;
    }
    
    public int getSID()
    {
        return this.sid;
    }
    
    public void setName(String newName)
    {
        this.name = newName;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setGender(String newGender)
    {
        this.name = newGender;
    }
    
    public String getGender()
    {
        return this.gender;
    }
    
    public void setDoB(int newDoB)
    {
        this.dob = newDoB;
    }
    
    public int getDoB()
    {
        return this.dob;
    }
    
    public void setAddress(String newAddress)
    {
        this.address = newAddress;
    }
    
    public String getAddress()
    {
        return this.address;
    }
    
    public void setNumber(String newNumber)
    {
        this.number = newNumber;
    }
    
    public String getNumber()
    {
        return this.number;
    }
    
    public void setComment(String newComment)
    {
        this.comments = newComment;
    }
    
    public String getComment()
    {
        return this.comments;
    }
    
    public void setPresent(boolean newPresent)
    {
        this.present = newPresent;
    }
    
    public boolean getPresent()
    {
        return this.present;
    }
    
    public void setBookList(String newBook)
    {
        String[] newBookList = this.booklist;
        try { //<2>
            newBookList[numberOfBooks] = newBook; //<3>
            this.numberOfBooks += 1; //<4>
            this.booklist = newBookList;
        } catch (Exception e) { //<5>
            System.out.println("Could not add another book. Something went wrong."); //<6>
        }
        
    }
    
    public void setNumberofBooks(int newNumberOfBooks)
    {
         this.numberOfBooks = newNumberOfBooks;
    }
    
    public int getNumberOfBooks()
    {
        return this.numberOfBooks;
    }
    
    public String getBooksString() {
        String books = Arrays.toString(booklist);
        return books;
    }
}
