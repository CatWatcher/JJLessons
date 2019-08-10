package lesson13;


import java.lang.reflect.*;
import java.util.Arrays;

// рефлексия
public class ReflectionExample {

    // можно в момент выполнения программы можем получать данные
    // о классе (поля, методы, интерфейсы и т.д)
    // можем создавать объекты методы и др
    // даже приватные
    public static void main(String[] args) throws
            NoSuchFieldException,
            IllegalAccessException,
            NoSuchMethodException, InvocationTargetException, InstantiationException {


        // получаем ссылку на классы от самого класса
        System.out.println(String.class);
        System.out.println(int.class);

        SomeClass someClass = new SomeClass();
        // возвращает ссылку на класс от объекта class lesson13.SomeClass
        System.out.println(someClass.getClass());
        Class cls = someClass.getClass();

        // приходит полное имя класса
        System.out.println(cls.getName());

        // если нужна инфа по родителю
        cls = cls.getSuperclass();
        System.out.println(cls.getName());

        // доступ к компонентам класса
        Class<SomeClass> someClassClass = SomeClass.class;

        // доступ к полям
        // возвращает все публичные поля свои и родителя
        Field[] fields = someClassClass.getFields();
        System.out.println(Arrays.toString(fields));

        // возвращает поля только данного класса, но зато все
        Field[] declaredFields = someClassClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        // доступ к методам публичным класса и родителя (в том числе обжект)
        Method[] methods = someClassClass.getMethods();
        System.out.println(Arrays.toString(methods));

        // все методы данного класса
        Method[] declaredMethods = someClassClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        // доступ к конструкторам
        Constructor<?>[] declaredConstructors = someClassClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(declaredConstructors));

        // доступ к конкретному полю, методу и тд
        // по имени поля
        Field field = someClassClass.getDeclaredField("version");
        // делает поле либо приватным, либо нет
        // ставим тру и можно пользоваться
        field.setAccessible(true);
        // получить тип поля
        System.out.println(field.getType());
        // задать значение
        // сначала объект, потом значение
        field.set(someClass, 1);

        System.out.println(someClass);

        // доступ к конкретным методам
        Method method = someClassClass.getDeclaredMethod("getInfo");
        method.setAccessible(true);
        // в инвок кидаем нужный нам объект
        String data = (String) method.invoke(someClass);
        System.out.println("data: " + data);

        // конструкторы
        Constructor<SomeClass> someClassConstructor =
                someClassClass.getDeclaredConstructor();
        // если нужен конкретный конструктор
        // указываем принимаемые конструктором типы
        Constructor<SomeClass> someClassConstructor1 =
                someClassClass.getDeclaredConstructor(String.class, int.class);

        // создание объекта на основе полученного конструктора
        SomeClass someClass1 = someClassConstructor1.newInstance("SomeClass", 3);


        // получение модификатора доступа поля
        boolean isPrivate = Modifier.isFinal(field.getModifiers());
        // файнал или нет?
        boolean isFinal = Modifier.isFinal(field.getModifiers());

    }
}

class Parent {
    public String parentField;

    public void parentVoid () {
        System.out.println("parent");
    }
}

class SomeClass extends Parent {
    private String name;
    public int version;

    public SomeClass() {
    }

    public SomeClass(String name) {
        this.name = name;
    }

    public SomeClass(String name, int version) {
        this.name = name;
        this.version = version;
    }

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    private void setVersion(int version) {
        this.version = version;
    }

    private  String getInfo () {
        return "private";
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
}