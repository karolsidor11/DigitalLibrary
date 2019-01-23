package pl.sidor.utils;

import pl.sidor.model.Book;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Book> list = new ArrayList();
        list.add(new Book(1, "a", "b", 1, "c"));
        list.add(new Book(2, "z", "b", 1, "c"));
        list.add(new Book(3, "a", "b", 1, "c"));
        list.add(new Book(4, "a", "b", 1, "c"));


        Book book = new Book(2, "z", "b", 1, "c");


        if (list.isEmpty()) {

            Book books = new Book(1, "z", "b", 1, "c");
            list.add(books);
        } else {
            for (Book b : list) {

                if (b.getTitle().equals(book.getTitle())) {
                    System.out.println("Zawiera");
                    b.setAuthor("JANEK");
                    System.out.println(b.getAuthor());


                } else {
                    System.out.println(" Nie zawiera");
                }
            }

        }

        if (list.get(0).getTitle().equals(book.getTitle())) {
            System.out.println("Zawiera");

        } else {
            System.out.println(" Nie zawiera");
        }



    }
}
