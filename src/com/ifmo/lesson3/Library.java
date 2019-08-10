package com.ifmo.lesson3;

import java.util.Arrays;

public class Library {
    // массив книг
    Books[] books = new Books[10];


    // метод для добавления книги в библиотеку
    public void addBook (Books book) {
        for (int i = 0; i < this.books.length; i++){
            if (this.books[i] == null) {
                this.books[i] = book;
                break;
            }
        }
    }

    public  Books getBook (String bookTitle) {
        Books result = null;
        for (int i = 0; i < this.books.length; i++){
            if (bookTitle.equals(this.books[i].getTitle())){
                result = books[i];
                break;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "Library(" +
                "books=" + Arrays.toString(books) +
                ')';
    }
}
