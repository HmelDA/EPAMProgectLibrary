package Service.Order;

import java.util.Objects;

public class Order {

    private int id;
    private Client client = null;
    private Book bookOne;
    private Book bookTwo;
    private Book bookThree;
    private boolean isConfirmed;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient() {
        return client.toString();
    }

    public void setClient() {
        this.client.setId();
        this.client.setFirstName();
        this.client.getLastName();
    }

    public String getBookOne() {
        return bookOne.toString();
    }

  /*  public void setBookOne(Book bookOne) {
        this.bookOne = bookOne;
    }*/

    public String getBookTwo() {
        return bookTwo.toString();
    }

/*
    public void setBookTwo(Book bookTwo) {
        this.bookTwo = bookTwo;
    }
*/

    public String getBookThree() {
        return bookThree.toString();
    }

/*
    public void setBookThree(Book bookThree) {
        this.bookThree = bookThree;
    }
*/

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.isConfirmed = confirmed;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && isConfirmed == order.isConfirmed && Objects.equals(client, order.client) && Objects.equals(bookOne, order.bookOne) && Objects.equals(bookTwo, order.bookTwo) && Objects.equals(bookThree, order.bookThree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, bookOne, bookTwo, bookThree, isConfirmed);
    }

    @Override
    public String toString() {
        return "Order " +
                "number : " + id +
                "\n client " + client +
                "\n books : " + bookOne +
                ", " + bookTwo +
                ", " + bookThree +
                "\n status: " + isConfirmed +
                '\n';
    }
}