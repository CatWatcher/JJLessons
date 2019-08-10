package multithreading.concur;

import java.util.*;

public class SomeClass {
    public static void main(String[] args) {
        //однопоточные коллекции
        //в таких случаях коллекции становятся синхронизированными
        // но в таком случае блокируется вся коллекция
        // что затрудняет рабоу с ней
        // а так же требует много памяти
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
    }
}


