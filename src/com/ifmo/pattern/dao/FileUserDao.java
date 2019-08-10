package com.ifmo.pattern.dao;


import java.util.List;

// класс который работает с файлом
// можно так же сделать для бахз данных и тп
// сколько вариантов работы с пользователем, столько и классов
public class FileUserDao implements UserDao {


    @Override
    public void addUser(User user) {
        System.out.println("add new user" + user);
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
