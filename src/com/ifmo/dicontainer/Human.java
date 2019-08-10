package com.ifmo.dicontainer;

import com.ifmo.dicontainer.pakety.Component;
import com.ifmo.dicontainer.pakety.AutoField;
import com.ifmo.dicontainer.pakety.AutoRun;

// объекты таких классов должны создаваться автоматически
@Component
public class Human {
    // такие свойства создаются автоматически
    @AutoField
    Cat cat;
    Dog dog;

    public Human() {
        System.out.println("human init");
    }

    @AutoRun
    public void walkWithCat() {
        System.out.println("walk with " + cat.getCatName());
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

}

// этот паттерн показывает как инициализировать свойства
// инъекция зависимостей
// весь код должен быть в одном пакете
// фреймворк сканирует пакет и собирает классы в коллекцию