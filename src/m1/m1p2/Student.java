package m1.m1p2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {

    private String _lastName;
    private String _firstName;
    private String _middleName;
    private final List<Book> _books = new ArrayList<>();

    public String getLastName(){ return this._lastName; }
    public void setLastName(String lastName){
        this._lastName = lastName;
    }

    public String getFirstName(){ return this._firstName; }
    public void setFirstName(String firstName){
        this._firstName = firstName;
    }

    public String getMiddleName(){ return this._middleName; }
    public void setMiddleName(String middleName){
        this._middleName = middleName;
    }

    public List<Book> getBooks(){ return Collections.unmodifiableList(this._books); }

    public Student(String lastName, String firstName, String middleName){
        this._lastName = lastName;
        this._firstName = firstName;
        this._middleName = middleName;
    }

    public void addBook(String name, String author, int pages, int publicationYear){
        this._books.add(new Book(name, author, pages, publicationYear));
    }

    @Override
    public String toString(){
        return this._lastName + " " + this._firstName + (this._middleName.isEmpty() ? "" : " " + this._middleName);
    }
}
