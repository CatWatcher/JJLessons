package com.ifmo.pattern.dao;


import java.util.List;

// предполагается что все классы будут работать с объектами класса юзер
public interface UserDao {

    void addUser(User user);

    // получение пользователя по ключу
    User getUserById (int id);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(User user);

}
