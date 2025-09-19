package m1.m1p2;

import java.util.Objects;

public class Book implements Comparable<Book>{

    private String _name;
    private String _author;
    private int _pages;
    private int _publicationYear;

    public String getName(){ return this._name; }
    public void setName(String name){
        this._name = name;
    }

    public String getAuthor(){ return this._author; }
    public void setAuthor(String author){
        this._author = author;
    }

    public int getPages(){ return this._pages; }
    public void setPages(int pages){
        this._pages = pages;
    }

    public int getPublicationYear(){ return this._publicationYear; }
    public void setPublicationYear(int publicationYear){
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
        //return b._pages-this._pages;
        int result = Integer.compare(b._pages, this._pages);
        if (result != 0) return result;
        return this._name.compareTo(b._name);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;

        Book b = (Book) o;

        return Objects.equals(this._name, b._name)
                && Objects.equals(this._author, b._author)
                && this._pages == b._pages
                && this._publicationYear == b._publicationYear;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this._name, this._author, this._pages, this._publicationYear);
    }
}
