package m1p2;

public class Book implements Comparable<Book>{

    private String _name;
    private String _author;
    private int _pages;
    private int _publicationYear;

    public String GetName(){ return this._name; }
    public void SetName(String name){
        this._name = name;
    }

    public String GetAuthor(){ return this._author; }
    public void SetAuthor(String author){
        this._author = author;
    }

    public int GetPages(){ return this._pages; }
    public void SetPages(int pages){
        this._pages = pages;
    }

    public int GetPublicationYear(){ return this._publicationYear; }
    public void SetPublicationYear(int publicationYear){
        this._publicationYear = publicationYear;
    }

    public Book(String name, String author, int pages, int publicationYear){
        this._name = name;
        this._author = author;
        this._pages = pages;
        this._publicationYear = publicationYear;

    }


    @Override
    public String toString(){
        return "\"" + this._name + "\" Автор: " + this._author + " " + this._pages + "стр. Год выпуска: " + this._publicationYear;
    }

    @Override
    public int compareTo(Book b) {
        return b._pages-this._pages;
    }
}
