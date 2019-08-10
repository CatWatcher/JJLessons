package lesson13;

// тут все настройки для основного кдласса


// создаем аннотацию для класса
@Config
public class SomeClassConfig {
    String name;
    int version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}

// если есть аннотация у класса, то инициализируем поля через конфиг файл (пропертис)
// создаем объекты через рефлексию
// имена поля передаем в гет пропертис
// поля отмеченые конфигом должны инициализироваться автоматически
// в пропертис можно задавать префикс, чтобы избежать конфликт имен
// тогда в аннотацию добавляем префикс @Config(prefix = "other")