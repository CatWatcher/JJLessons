package com.ifmo.lesson10;

import java.lang.ref.WeakReference;
import java.util.*;

public class MapEx {
    public static void main(String[] args) {
        // не содержит одинаковых значений
        // если ключи совпадают, то запишется новое значение вместо старого
        // храниться могут по-разному
        // в качестве ключей лучше использовать строки или другие объекты

        // указываем тип данных ключа и тип даных поиска
        // значения располагаются по хёш коду ключа
        HashMap<String, User> userHashMap = new HashMap<>();

        User user = new User("Felix", "qwerty");
        User user2 = new User("Feliadvx", "qvawerty");
        User user3 = new User("Feliaevx", "qwaeverty");
        User nullUser = new User();

        // первый элемент всегда с ключом null
        // добавление в мапу
        //сначала ключ, потом значение
        userHashMap.put(user.getLogin(), user);
        userHashMap.put(user2.getLogin(), user2);

        // можно указать значение null
        userHashMap.put(null, nullUser);

        // получение значений
        System.out.println(userHashMap.get("Felix"));

        //перебор
        for (Map.Entry entry: userHashMap.entrySet()) {
            //получаем ключи и значение
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        // получение отдельно ключей
        userHashMap.keySet();
        // получение значений
        userHashMap.values();

        // хранит элементы в порядке добавления
        //LinkedHashMap

        //  энумы в качестве ключей. Считается производительной
        // null  в качестве ключа использовать нельзя
        // EnumMap
        EnumMap<State, String> enumMap = new EnumMap<>(State.class);
        enumMap.put(State.ERROR, "Error");
        enumMap.put(State.START, "Start");
        System.out.println(enumMap.get(State.START));

        // древесная мапа
        // с отсортированными ключами
        // с прмитивами не работает, поэтому указываем оболочки
        // порядок сортировки основан на красно-черном бинарном дереве
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "3");
        treeMap.put(1, "1");
        treeMap.put(5, "5");
        System.out.println(treeMap);

        // ссылки могут быть сильными, могут быть слабыми
        // если ссылки слабые, то объект удалится сборщиком мусора
        Object obj = new Object();

        WeakReference weakReference = new WeakReference(obj);
        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();

        HashMap<Object, String> hashMap1 = new HashMap<>();

        // keys and values
        Object hashKey = new Object();
        String hashValue = "Syaski masyaski";

        Object weakMapKey = new Object();
        String weakMapValue = "Ahalai makalai";

        hashMap1.put(hashKey, hashValue);
        weakHashMap.put(weakMapKey, weakMapValue);

        System.out.println("hashMap" + hashMap1);
        System.out.println("weak" + weakHashMap);

        hashKey = null;
        weakMapKey = null;
        // вызываем сборщик мусора
        System.gc();


        // ключи сравниваются не иквел, а через ==
        // когда используется логика клонирования и сериализации
        IdentityHashMap<Integer, String> integerStringIdentityHashMap = new IdentityHashMap<>();

        HashMap<String, Integer> hashMap2 = new HashMap<>();
        hashMap2.put("qewf", 23);
        hashMap2.put("qwf", 21);
        hashMap2.put("QFV", 19);

        // удаление объектов из мапы
        // указываем тип для итератора и для энттри
        Iterator<Map.Entry<String, Integer>> iterator = hashMap2.entrySet().iterator();

        while (iterator.hasNext()) {
            // получаем значение
            Map.Entry<String, Integer> entry = iterator.next();
            // ключ
            String key = entry.getKey();
            // значение
            int val = entry.getValue();
            // удаляем все что меньше 20
            if (val < 20)
                iterator.remove();
        }

        // посмотреть методы у трисета
        // слабые и сильные ссылки
        // методы коллекций и вообще коллекции


     }
}

enum State {

    START, STOP, ERROR

}

class User {

    String login;
    String pwd;

    public User() {}

    public User(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }

    public String getLogin() {
        return login;
    }

    // если в качестве ключей хотим использовать объекты
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(pwd, user.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, pwd);
    }
}
