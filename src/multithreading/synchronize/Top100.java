package multithreading.synchronize;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Top100 {
    public static void main(String[] args) {

        File file = new File("wp.txt");
        List<String> lines = new ArrayList<>();
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            String[] wordSplit = line.toLowerCase().
                    replaceAll("\\p{Punct}", " ").
                    replaceAll("\\p{Digit}", " ").
                    trim().split("\\s");
            for (String s : wordSplit) {
                if (s.length() > 0) {
                    words.add(s.trim());
                }
            }
        }


        HashMap<String, Integer> map = new HashMap<>();
        int threadCount = Runtime.getRuntime().availableProcessors();
        int wordSize = words.size();




    }

}

class  WordCounter implements Runnable {

    HashMap<String, Integer> localMap = new HashMap<>();
    HashMap<String, Integer> map;
    List<String> words;

    public WordCounter(HashMap<String, Integer> map, List<String> words) {
        this.map = map;
        this.words = words;
    }

    @Override
    public void run() {
        for (String word : words) {
            if (localMap.containsKey(word)) {
                localMap.put(word, localMap.get(word) + 1);
            } else {
                localMap.put(word, 1);
            }
        }

        // поток смотрит есть ли слово в общей мапе
        // если есть, то он добавляет кол-во
        // если там этого слова нет, то добовляет слово и кол-во из своей мапы
        synchronized (map) {
            for (Map.Entry<String, Integer> entry : localMap.entrySet()) {
                String key = entry.getKey();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + entry.getValue());
                } else {
                    map.put(key, entry.getValue());
                }
            }
        }
    }
}
