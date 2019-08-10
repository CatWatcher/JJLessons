package lesson13;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.Arrays;

// шифрующие потоки
// доделать ту стринг для для непримитивных типов
//


public class ToString {

    public static String toString (Test test) {
        Class<Test> testClass = Test.class;
        Field[] fields = testClass.getDeclaredFields();
        if (testClass.isAnnotationPresent(MethodInfo.class)) {

        }
        return Arrays.toString(fields);

    }
}

class Test {

    private String name;
    private int CountOfIceCream;

    @MethodInfo(date = "04.05.2019", author = "Feliks")
    public void someM () {
        System.out.println("some method");
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", CountOfIceCream=" + CountOfIceCream +
                '}';
    }
}
