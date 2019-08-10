package com.ifmo.lesson9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class CollectionExample{

    public static void main(String[] args) throws IOException {
        // конструктор
        //ArrayList<Book> bookArrayList = new ArrayList<>(4);

        // по умолчанию массив на 10 элементов
        // сохраняется порядок элементов
        ArrayList<Book> bookArrayList = new ArrayList<>();
        bookArrayList.add(new Book("Book"));
        bookArrayList.add(new Book("Cars"));
        bookArrayList.add(new Book("Far"));
        // вставка по индексу
        bookArrayList.add(2, new Book ("Fate"));

        for (Book book: bookArrayList){
            System.out.println(book.getTitle());
        }
        //создание коллекции на основе другой коллекции
        // ХэшСет расширяет интерфейс сет
        // элементы хранятся на основе хэш кода
        // Только уникальные элементы
        // обязательно переопределять хэшкод и иквелс
        // bookSet на основе листа
        Set<Book> bookSet = new HashSet<>(bookArrayList);

        for (Book book: bookSet) {
            System.out.println(book.getTitle());
        }

        LinkedList<Book> bookLinkedList = new LinkedList<>();
        // каждый добавленный элемент становится узлом
        bookLinkedList.add(new Book("Book"));
        bookLinkedList.add(new Book("Book2"));
        bookLinkedList.add(new Book("Fate"));

        TreeSet<String> strings = new TreeSet<>();
        strings.add("aerg");
        strings.add("adgs;mgr");
        strings.add("argeh");



        for (String str: strings) {
            System.out.println(str);
        }

        TreeSet<Book> bookTreeSet = new TreeSet<>();
        bookTreeSet.add(new Book("Book1"));
        bookTreeSet.add(new Book("akd"));

        for (Book book: bookLinkedList) {
            System.out.println(book.getTitle());
        }

        bookLinkedList.get(2);
        // узнать индекс элемента
        bookLinkedList.indexOf("Book");

        User user1 = new User("ewF", 21);
        User user2 = new User("aef", 8);
        // передаем логику чравнения компоратора
        TreeSet<User> users = new TreeSet<>(new UserComparator());
        users.add(user1);
        users.add(user2);

        for (User user: users) {
            System.out.println(user.getName());
        }
        //сортировка сначала по имени, а потом по возрасту
        Comparator<User> userComparator = new UserNameComparator()
                .thenComparing(new UserAgeComparator());

        TreeSet<User> userTreeSet = new TreeSet<>(userComparator);
        userTreeSet.add(new User("awef", 23));
        userTreeSet.add(new User("adf", 12));
        userTreeSet.add(new User("ewf", 14));

        for (User user: userTreeSet) {
            System.out.println(user.getName() + " - " + user.getAge());
        }

        ClassLoader loader = CollectionExample.class.getClassLoader();
        File file = new File(loader.getResource("Без названия.pages").getFile());
        // читаем строки из файла
        List<String> lines = Files.readAllLines(file.toPath());

        // читаем слова
        List<String> words = new ArrayList<>();
        for (String line: lines) {
            String[] wordSplit = line.toLowerCase()
                    .replaceAll("\\p{Punct}", " ") // знаки препинания на пробелы
                    .trim() // убираем пробелы с двух сторон
                    .split("\\s"); // разбиваем на слова

            for (String s: wordSplit) {
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }
        }

}
// для использования трии сета
// класс должен расширять интерфейс
class Book implements Comparable<Book>{
    String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                '}';
    }

    // 0 - объекты равны
    // отрицательное значение - объект будет стоять раньше Object o
    // положительное - объект будет стоять после о
    @Override
    public int compareTo (Book o) {
        return title.compareTo(o.getTitle());
    }
}

class User
{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class UserComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class UserNameComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
// сравниваем возраст
class UserAgeComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
