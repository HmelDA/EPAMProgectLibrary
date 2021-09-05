package Service.Order;

import java.util.Objects;

public class Book {
    private int id;
    private String name;
    private String author;
    private String genre;
    private boolean presence;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String first_name) {
        this.name = first_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String last_name) {
        this.author = last_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && presence == book.presence && name.equals(book.name)
                && author.equals(book.author) && genre.equals(book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, genre, presence);
    }

    @Override
    public String toString() {
        return "Book" +
                ", name " + name + ' ' +
                ", author " + author + ' ' +
                ", genre " + genre + ' ' +
                '\n';
    }
}
