package StreamAPI;

import java.nio.file.Files;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// любую коллекцию можно превратить в стрим
// не забывать про переопределение иквелс и хэш при работе сос тсримами!!!
public class StreamExamples {
    public static void main(String[] args) {
        // методы получения стрим объекта
        // у коллекции вызываем метод стрим
        Stream<String> stringStream = collection.stream();

        // из массива
        Arrays.stream(someArr);

        //  из файла
        // вернет объект стрима
        // каждая строка будет элементом стрима
        Files.lines(filePath);

        // из строки
        "String".chars();
        // обязательно на конце билд
        Stream.builder().add(object).add(object2).build();
        Stream.of(data);

        ///////////////// methods ////////////////////

        Stream<Integer> integerStream = Stream.of(1, 3, 4, 23, -1, 3, -25);

        // фильтр - промежуточный метод, в качестве аргумента предикатор
        // мап принимает функцию и применяет функцию к каждому элементу (в данном случае после фильтра)
        // выбирает указанное кол-во элементов
        // фор ич - делает действие на все элементы - интернальный метод
        integerStream.filter(num -> num < 0)
        .map(num -> num * 100)
        .limit(2)
        .forEach(System.out::println);

        // distinct выбирает уникальные значения через иквелс
        // повторяющиеся исчезнут
        // сорт - сортировка по возрастанию либо через компаратор
        integerStream = Stream.of(1, 3, 4, 23, -1, 3, -25);
        integerStream.distinct()
                .sorted()
                .forEach(System.out::println);

        // anyMatch | noneMatch | allMatch - возвращают тру или фолс
        // эни - тру если хотя бы один подходит к условию
        // если ниодин не подходит
        // и если все подходят
        integerStream = Stream.of(1, 3, 4, 23, -1, 3, -25);
        System.out.format("anyMatch: %b", integerStream.anyMatch(num -> num == 0));

        // мап может использоваться для преобразования типов
        integerStream = Stream.of(1, 3, 4, 23, -1, 3, -25);
        integerStream.filter(num -> num > 0)
                .map(num -> num + "$")
                .forEach(System.out::println);

        //orElse - вернет либо элемент лдибо надпись, если коллекция пуста
        String[] strings = {"awef", "ad", "aewf43", "aerf42", "adwf", "dbtbt"};
        System.out.format("Первый элемент: %s \n", Arrays.stream(strings).findFirst().orElse("Коллекция пуста"));

        // skip - пропускает первые n элементов
        System.out.format("last element: %s \n", Arrays.stream(strings)
                .skip(strings.length - 1).findAny().orElse("Collection is empty"));

        // get - если не найдет элемент, либо эксепшн
        System.out.format("Element awef: %s \n", Arrays.stream(strings)
                .filter("awef"::equals).findFirst().get());

        // collect - создание коллекции из стрима
        System.out.format("Elements with 56: %s \n", Arrays.stream(strings)
                .filter(s -> s.contains("56")).collect(Collectors.toList()));

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("dasdaf", 13));
        users.add(new User("rtv", 43));
        users.add(new User("asdcmlm", 25));
        users.add(new User("a';lrm", 98));
        users.add(new User("aecaef", 45));
        users.add(new User("dasdaf", 13));

        // массив пользователей старше 30 лет
        User[] usersArr = users.stream().filter(user -> user.getAge() > 30)
                // чтобы получить массив пользователей а не обжект
                // кидаем в метод ссылку на конструктор
                .toArray(User[]::new);
        System.out.println(Arrays.toString(usersArr));

        // peek - чтобы менять свой ства объектов
        // принимает на вход
        List<User> list = users.stream()
                .peek(user -> user.setActive(true))
                .collect(Collectors.toList());

        //
        users.stream().distinct().forEach(System.out::println);

        users.stream().sorted(Comparator.comparing(User::getAge).thenComparing(User::getLogin)).forEach(System.out::println);

        // в таком виде пользователя не получим
        // нужен метод гет или орэлс
        System.out.println(users.stream().min(Comparator.comparing(User::getAge)).get());

        ///////////////// method collect ////////////////

        // анонимный массив
        strings = new String[] {"adfv", "awef3", "srtb", "fyum", "yoi"};

        // метод коллект для того чтобы сделать из стрима коллекцию или мапу
        List<String> stringList = Arrays.stream(strings).collect(Collectors.toList());
        Set<String> stringSet = Arrays.stream(strings).collect(Collectors.toSet());

        // если хотим в определенную коллекцию
        ArrayList<String> stringArrayList = Arrays.stream(strings)
                .collect(Collectors.toCollection(ArrayList::new));

        // map
        // toMap - третий аргумент для эксепшенов
        // item - текщий ключ
        // item2 - второй ключ
        // после стрелки тот ключ, который нужно выбрать
        Map<String, Integer> integerMap = Arrays.stream(strings)
                .collect(Collectors.toMap(Function.identity(), String::length, ((item, item2) -> item)));

        // joining - объединение данных между данными будет :
        // Before - начадло и энд - конец
        // в результате все элементы стрима соединятся в строчку
        String string = Arrays.stream(strings)
                .collect(Collectors.joining(" : ", "Before: ", " -End"));


    }
}


class User {
    private String login;
    private int age;

    private boolean active;

    public User(String login, int age) {
        this.login = login;
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                active == user.active &&
                Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, age, active);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                ", active=" + active +
                '}';
    }
}