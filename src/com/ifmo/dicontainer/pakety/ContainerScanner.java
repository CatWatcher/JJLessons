package com.ifmo.dicontainer.pakety;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class ContainerScanner {

    private static final char PACKAGE_SEP = '.';
    private static final char DIR_SEP = '.';


    public static ArrayList<Class> scan(String packageName) {
        String scannedPath = packageName.replace(PACKAGE_SEP, DIR_SEP);

        // в данном примере путь к файлу
        URL scannedUrl =
                Thread.currentThread().getContextClassLoader().getResource(scannedPath);

        if (scannedUrl == null) {
            throw new IllegalArgumentException("wrong arguments");
        }

        // определяем пакет с которого начинаем сканировать
        File scannedDir = new File(scannedUrl.getFile());

        ArrayList<Class> classes = new ArrayList<>();
        // метод лист файлс возвращает все в текущей дирректории
        for (File file: scannedDir.listFiles()) {
            classes.addAll(scan(file, packageName));
        }
        return classes;
    }

    private static ArrayList<Class> scan(File file, String packageName){
        ArrayList<Class> classes = new ArrayList<>();
        String resource = packageName + PACKAGE_SEP + file.getName();

        if (file.isDirectory()) {
            for (File file1: file.listFiles()) {
                classes.addAll(scan(file, resource));
            }
        } else if (resource.endsWith(".class")) {
            String className = resource.substring(0, resource.lastIndexOf("."));
            // на основе строки создается класс и передается в лист
            try {
                classes.add(Class.forName(className));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return classes;

    }
}
