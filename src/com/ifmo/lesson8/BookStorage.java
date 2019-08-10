package com.ifmo.lesson8;

public class BookStorage<T extends Book> {
    // такой клас работает с классом бук и со всеми дочерними

    private T book;
    public String getBookTitle() {
        return book.getTitle();
    }
}

//
