package com.ifmo.lesson3;

public class Books {
 // свойства класса (атрибуты или поля)
    private int pageCount;  // число страниц
    private String title;
    private Author author;

    //конструктор по умолчанию
    public Books() {}
    // конструктор для автора

    public Books(Author author) {
        // можно создать объект внутри конструктора
        this.author = author;
    }

    // другой конструктор
    public Books(int pageCount, String title) {
        if (pageCount < 1) {
            System.out.println("Wrong count");
            return;
        }
        this.pageCount = pageCount;
        this.title = title;
    }

    // чтобы можно было вывести объекты в консоль
    // обязательно нужен метод toString чтобы вывести объект
    @Override
    public String toString() {
        return "Book " +
                "pageCount = " + pageCount +
                ", title = '" + title + '\'';
    }

    // чтобы защитить свойства от недопустимых значений закрываем к ним доступ
    // с помощью модификатара доступа private
    // для задания свойств объектам
    // this - ссылка на текущий объект (чтобы присваивались свойства тому объекту, с которым работаем)

    // задаем кол-во страниц
    public void setPageCount(int pageCount) {
        // проверка услович
        if (pageCount < 1) {
            System.out.println("Wrong count");
            return; // прерывает работу метода если нет значения*
        }
        this.pageCount = pageCount;

    }

    // задаем название
    public void setTitle (String title) {
        this.title = title;
    }

    public void setAuthor (Author author) {
        this.author = author;
    }

    //получение значений свойств

    public int getPageCount() {
        return pageCount;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }
}
