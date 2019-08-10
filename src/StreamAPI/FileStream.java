package StreamAPI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.*;

public class FileStream  {
    public static void main(String[] args) throws IOException {
        File file = new File("wp.txt");

        // посчитать топ 10
        Map<String, Long> map =
                // получаем стрим из файла
                Files.lines(file.toPath())
                // указываем что стрим должен быть параллельным
                .parallel().map(line -> line.toLowerCase().replaceAll("\\pP", " "))
                .flatMap(line -> Arrays.stream(line.split(" ")))
                        // обрезаем пробелы
                .map(String::trim)
                .filter(word -> !"".equals(word))
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet().parallelStream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10).collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}

// посмотреть промежуточные и интернальные методы
// посмотреть как работают коллекторы
// мапы
// как работают методы у мапы и группинг бай
// посмотреть что методы принимают на вход

