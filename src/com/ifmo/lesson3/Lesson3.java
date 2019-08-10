package com.ifmo.lesson3;

public class Lesson3 {
    public static void main(String[] args) {

        Books book1 = new Books(413, "Game of Thron");
        Books book2 = new Books(1096, "Thinking in java");

        // задаем кол-во страниц
//        book1.setPageCount(123);
//        // и название
//        book1.setTitle("To be birds means to eat worms");
//
//        book2.setPageCount(-2);
//    }
        System.out.println(book1);

        System.out.println(book1.getTitle());

        Author author = new Author("Martin", 34);
        book1.setAuthor(author);

        Library library1 = new Library();

        library1.addBook(book2);
        library1.addBook(book1);
        Books game = library1.getBook("Game of Thron");

        System.out.println(library1);
        System.out.println(game);
    }


}