package com.ifmo.lesson8;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Book tails = new Book("tails", 102);
        Book flowers = new Book("Flowers", 34);

        Car car = new Car("Red");

        LinkedList bookStorage = new LinkedList();
        bookStorage.add(tails);
        bookStorage.add(flowers);

        bookStorage.add(car);

        Book bookFromStorage = (Book) bookStorage.get(0);
        // тут лежит машина, на моменте работы программы будет ошибка
        Book bookFS2 = (Book) bookStorage.get(2);

        // <T> - собираемся работать с неизвестным типом (дженерик) (в классе нодэ)
        // T value;

        LinkedList<Book> booksStorage = new LinkedList<>();
        booksStorage.add(tails);
        booksStorage.add(flowers); // ошибку видно во время компиляции
        // вместо Т везде поставился тип Book

        LinkedList<Car> carStorage = new LinkedList<>();
        // тут теперь хранилище для машин
        // если сюда попробовать книги, то будет ошибка

        Book bookFromStorage3 = booksStorage.get(1);
        System.out.println(bookFromStorage3.getTitle());

        LinkedList<ChildBook> chBook = new LinkedList<>();
        ChildBook coloring = new ChildBook("coloring", 32);
        chBook.add(coloring);

        Book book1 = getFirstBook(chBook);

    }

    // чтобы могли работать с потомками в аргументе  используем такую запись:
    public  static Book getFirstBook (LinkedList<? extends Book> storage) {
        // так делать нельзя
//        ChildBook book2 = new ChildBook("book", 12);
//        storage.add(book2);
        return storage.get(0);
    }
    // хранилище работает с классом бук и со всеми его предками
    public void addToStorage (LinkedList<? super Book> storage) {
        Book book = new Book("book", 21);
        storage.add(book);
        // так делать нельзя, будет ошибкау
        //Book book1 = storage.get(0);

        // чтобы получить объект
        Object o = storage.get(0);

    }

    public void  someVoid (LinkedList<String> storage) {

    }
    //  так нельзя, тк все приведется к одному типу
    // это не перегруз методов, сигнатура должна быть разной
//    public void  someVoid (LinkedList<Integer> storage) {
//
//    }
    // такое хранилище может работать с чем угодно
    // мы не знаем тип данных
    // можем добавить только null
    // получить можно только объект
    public static void storage (LinkedList<?> storage) {
        ChildBook book = new ChildBook("book", 32);
        //storage.add(book);
        storage.add(null);

        //Book book1 = storage.get(0);
        Object o = storage.get(0);
    }



}
