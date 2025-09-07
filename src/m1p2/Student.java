package m1p2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {

    private String _lastName;
    private String _firstName;
    private String _middleName;
    private final List<Book> _books = new ArrayList<>();

    public String GetLastName(){ return this._lastName; }
    public void SetLastName(String lastName){
        this._lastName = lastName;
    }

    public String GetFirstName(){ return this._firstName; }
    public void SetFirstName(String firstName){
        this._firstName = firstName;
    }

    public String GetMiddleName(){ return this._middleName; }
    public void SetMiddleName(String middleName){
        this._middleName = middleName;
    }

    public List<Book> GetBooks(){ return Collections.unmodifiableList(this._books); }

    public Student(String lastName, String firstName, String middleName){
        this._lastName = lastName;
        this._firstName = firstName;
        this._middleName = middleName;
    }

    public void AddBook(String name, String author, int pages, int publicationYear){
        this._books.add(new Book(name, author, pages, publicationYear));
    }

    @Override
    public String toString(){
        return this._lastName + " " + this._firstName + (this._middleName.isEmpty() ? "" : " " + this._middleName);
    }
}
