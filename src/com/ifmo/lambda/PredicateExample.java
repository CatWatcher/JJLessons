package com.ifmo.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();

        User user1 = new User("login1", 23, "Russia");
        User user2 = new User("login2", 43, "Japan");
        User user3 = new User("login3", 19, "Canada");
        User user4 = new User("login4", 99, "England");
        User user5 = new User("login5", 34, "Japan");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        UsersList usersList = new UsersList(users);

        List<User> japanUsers = usersList.getUserListPredicate(user -> "Japan".equals(user.getCountry()));

        Predicate<User> getJapanPredicate = user -> "Japan".equals(user.getCountry());
        Predicate<User> getMoreTwenty = user -> user.getAge() > 20;
        Predicate<User> getCanadaPredicate = user -> "Canada".equals(user.getCountry());

        System.out.println(usersList.getUserListPredicate(getJapanPredicate));

        System.out.println(usersList.getUserListPredicate(getCanadaPredicate.and(getMoreTwenty)));
    }

}

class UsersList {
    List<User> userList;

    public UsersList(List<User> userList) {
        this.userList = userList;
    }

    // получение только японцев
    public List<User> getJapan () {
       List<User> list = new ArrayList<>();
       for (User user : userList) {
           if ("Japan".equals(user.getCountry())) {
               list.add(user);
           }
       }
       return list;
    }

    public List<User> getMoreTwenty () {
        List<User> list = new ArrayList<>();
        for (User user : userList) {
            if (user.getAge() > 20) {
                list.add(user);
            }
        }
        return list;
    }

    public List<User> getCanadaMore30 () {
        List<User> list = new ArrayList<>();
        for (User user : userList) {
            if ("Canada".equals(user.getCountry()) && user.getAge() > 30) {
                list.add(user);
            }
        }
        return list;
    }

    // с помощью предиката
    // он будет один на все
    // но где-то сохраняем фильтры
    public List<User> getUserListPredicate (Predicate<User> filter) {
        List<User> list = new ArrayList<>();
        for (User user : userList) {
            if (filter.test(user)) {
                list.add(user);
            }
        }
        return list;
    }
}


class User {
    private String login;
    private int age;
    private String country;

    public User(String login, int age, String country) {
        this.login = login;
        this.age = age;
        this.country = country;
    }

    public String getLogin() {
        return login;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(login, user.login) &&
                Objects.equals(country, user.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, age, country);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}
