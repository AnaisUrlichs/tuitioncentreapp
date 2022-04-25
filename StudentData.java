import java.util.Arrays;

/**
 * Abstract class StudentData - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public class StudentData
{
    private int sid;
    private String name;
    private String gender;
    private int dob;
    private String address;
    private String number;
    private String comments; 
    private boolean present; 
    protected String booklist;
    protected int numberOfBooks;
    
    public StudentData(int sid, String name, String gender, int dob, String address, String number, String comments, boolean present ) {
        this.sid = sid;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.number = number;
        this.present = present;
        this.comments = comments;
        this.booklist = "";
        this.numberOfBooks = 0;
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
        try {
            this.booklist = this.booklist + ", " + newBook;
            this.numberOfBooks += 1;
        } catch (Exception e) { 
            System.out.println("Could not add another book to " + getName() + ". Something went wrong.");
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
        return booklist;
    }
}
