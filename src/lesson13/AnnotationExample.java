package lesson13;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationExample {
    String name;

    @Override
    // заполняем поля аннотации
    @MethodInfo(date = "12.02.2019", author = "Felix", version = 2)
    public String toString() {
        return "AnnotationExample{" +
                "name='" + name + '\'' +
                '}';
    }

    // отмечает метод как устаревший
    @Deprecated
    public void someVoid () {}

    public static void main(String[] args) {
        // получение аннотаций
        AnnotationExample example = new AnnotationExample();
        Method[] methods = example.getClass().getDeclaredMethods();

        // для каждого метода смотрим аннотацию
        for (Method method: methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            System.out.println(Arrays.toString(annotations));
        }
    }
}
