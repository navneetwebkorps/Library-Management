package Users;

import java.util.Date;

public class Book {
    private int bid;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }
    
    private String bname;
    private String author;
    private int edition;
    private int quantity;
    private Date IssueDate;
    private Date ReturnDate;
    private String Sname;
    private boolean Already_Issued;

    public boolean isAlready_Issued() {
        return Already_Issued;
    }

    public void setAlready_Issued(boolean Already_Issued) {
        this.Already_Issued = Already_Issued;
    }

    public Date getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(Date IssueDate) {
        this.IssueDate = IssueDate;
    }

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date ReturnDate) {
        this.ReturnDate = ReturnDate;
    }

    public Book(int bid, String bname, Date IssueDate, Date ReturnDate) {
        this.bid = bid;
        this.bname = bname;
       
       
        this.IssueDate = IssueDate;
        this.ReturnDate = ReturnDate;
    }
     public Book(int bid, String bname,String Sname ,Date IssueDate, Date ReturnDate) {
        this.bid = bid;
        this.bname = bname;
       this.Sname=Sname;
       
        this.IssueDate = IssueDate;
        this.ReturnDate = ReturnDate;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String Sname) {
        this.Sname = Sname;
    }


    // Default constructor
    public Book() {
    }

    // Parameterized constructor
    public Book(int bid,String bname, String author, int edition, int quantity) {
        this.bid=bid;
        this.bname = bname;
        this.author = author;
        this.edition = edition;
        this.quantity = quantity;
    }
 public Book(int bid,String bname, String author, int edition, int quantity ,boolean Already_Issued) {
        this.bid=bid;
        this.bname = bname;
        this.author = author;
        this.edition = edition;
        this.quantity = quantity;
        this.Already_Issued=Already_Issued;
    }
    // Getters and Setters
    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Optional: Override toString() for better readability
    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", edition=" + edition +
                ", quantity=" + quantity +
                '}';
    }


}
