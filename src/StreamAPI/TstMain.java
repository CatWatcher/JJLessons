package StreamAPI;

import java.util.*;
import java.util.stream.Collectors;

public class TstMain {
    public static void main(String[] args) {

        Author mike = new Author("Mike", 34);
        Author jhon = new Author("Jhon", 45);
        Author max = new Author("Max", 23);
        Author alice = new Author("Alice", 25);
        Author liza = new Author("Liza", 13);
        Author jane = new Author("Jane", 19);

        Article article = new Article("Java 12", mike, Article.Category.JAVA);
        Article article1 = new Article("Python", liza, Article.Category.PYTHON);
        Article article2 = new Article("Thinking in Java", alice, Article.Category.JAVA);
        Article article3 = new Article("PHP for nubs", mike, Article.Category.PHP);
        Article article4 = new Article("Working with DB", jane, Article.Category.PHP);
        Article article5 = new Article("Flask", jhon, Article.Category.PYTHON);
        Article article6 = new Article("Lambda", jhon, Article.Category.JAVA);
        Article article7 = new Article("new GC", max, Article.Category.JAVA);
        Article article8 = new Article("PyGame", liza, Article.Category.PYTHON);
        Article article9 = new Article("Parsing", mike, Article.Category.PYTHON);
        Article article10 = new Article("Java utils", alice, Article.Category.JAVA);

        ArrayList<Article> articles = new ArrayList<>();
        articles.add(article);
        articles.add(article1);
        articles.add(article2);
        articles.add(article3);
        articles.add(article4);
        articles.add(article5);
        articles.add(article6);
        articles.add(article7);
        articles.add(article8);
        articles.add(article9);
        articles.add(article10);

        // сгрупировать статьи по автору
        // groupingBy - передаем сюда условие группировки
        // в выводе будет автор и все его статьи
        articles.stream().collect(Collectors.groupingBy(a -> a.getAuthor()
                .getName())).entrySet().forEach(System.out::println);

        // вывести имена авторов по алфавиту
        articles.stream()
                .map(a -> a.getAuthor().getName())
                .distinct().sorted();

        // количество статей у каждого автора
        // метод каунтинг вернет сколько объектов относится к ключу
        articles.stream().collect(Collectors.groupingBy(a -> a.getAuthor().getName(), Collectors.counting()))
                .forEach((a, count) -> System.out.println(a + " : " + count));

        //
        Map<Article.Category, Map<String, List<Article>>> mapMap = articles.stream()
                // сортируем по категории энума
                .sorted(Comparator.comparing(Article::getCategory, Comparator.comparing(Enum::name))
                        // сортируем по автору
                .thenComparing(a -> a.getAuthor().getName()))
                // группируем по категории и собираем вторую мапу по авору
                .collect(Collectors.groupingBy(Article::getCategory, LinkedHashMap::new, Collectors.groupingBy(
                        a -> a.getAuthor().getName())));

        System.out.println(mapMap);

        ArrayList<Author> authors = new ArrayList<>();
        authors.add(mike);
        authors.add(jhon);
        authors.add(liza);
        authors.add(alice);
        authors.add(jane);
        authors.add(max);

        // объект для сбора статистики
        IntSummaryStatistics statistics = authors.stream()
                .collect(Collectors.summarizingInt(Author::getAge));
        System.out.println(statistics);

        //
        ArrayList<Developer> developers = new ArrayList<>();
        // группировка по должности - position
        Map<String, List<Developer>> posMap = developers.stream()
        .collect(Collectors.groupingBy(Developer::getPosition));

        // количество по должности
        Map<String, Long> posCountMap = developers.stream()
                // метод каунтиг посчитает сколько объектов привязано к этой строчке
                .collect(Collectors.groupingBy(Developer::getPosition, Collectors.counting()));

        // группировка имен по должности
        Map<String, Set<String>> posNameSet = developers.stream()
                // метод мапинг - что нам надо собрать в результат
                // одно какое-то свойство
                .collect(Collectors.groupingBy(Developer::getPosition,
                        Collectors.mapping(Developer::getName, Collectors.toSet())));

        // средняя зп по должности
        Map<String, Double> averageSalary = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPosition,
                        // averageDouble - берет среднее от указанного параметра
                        Collectors.averagingDouble(Developer::getSalary)));

        // сначала правила для ключа, а уж потом для значений
        Map<String, Map<Integer, List<Developer>>> agePos = developers.stream()
                .collect(Collectors.groupingBy(Developer::getPosition,
                        Collectors.groupingBy(Developer::getAge)));


    }
}


class Author {
    private String name;
    private int age;

    public Author(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}


class Article {
    enum Category {
        JAVA, PHP, PYTHON
    }

    private String title;
    private Author author;
    private Category category;

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", category=" + category +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) &&
                Objects.equals(author, article.author) &&
                category == article.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, category);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Article(String title, Author author, Category category) {
        this.title = title;
        this.author = author;
        this.category = category;
    }
}


class Developer {
    private String name;
    private  int age;
    private int salary;
    private String position;

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return age == developer.age &&
                salary == developer.salary &&
                Objects.equals(name, developer.name) &&
                Objects.equals(position, developer.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary, position);
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Developer(String name, int age, int salary, String position) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.position = position;
    }
}