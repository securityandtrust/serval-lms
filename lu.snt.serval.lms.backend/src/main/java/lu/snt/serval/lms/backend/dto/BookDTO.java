package lu.snt.serval.lms.backend.dto;

import javax.persistence.*;

@Entity
@Table(name="books")
public class BookDTO {

	@Id
    @GeneratedValue
    private int id_book;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String state;
    @Column
    private int pages;
    @Column
    private int pub_year;
    @Column
    private int damaged;



    public static final String AVAILABLE_STATE = "AVAILABLE",
                               DAMAGED_STATE = "DAMAGED",
                               ORDERED_STATE = "ORDERED",
                               BORROWED_STATE = "BORROWED";



    public BookDTO() {
        // nothing instancied
    }

    public BookDTO(String titre, String author, int nbPages, int pub_year) {
        this.title = titre;
        this.author = author;
        this.pages = nbPages;
        this.pub_year = pub_year;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPub_year() {
        return pub_year;
    }

    public void setPub_year(int pub_year) {
        this.pub_year = pub_year;
    }

       public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }


    public int getDamaged() {
        return damaged;
    }

    public void setDamaged(int damaged) {
        this.damaged = damaged;
    }

    public String toString() {
        return "Book title : " + title +
                "\nAuthor : " + author +
                "\nYear :  " + pub_year +
                "\nPages :  " + pages +
                "\nState :  " + state; 
    }
}
