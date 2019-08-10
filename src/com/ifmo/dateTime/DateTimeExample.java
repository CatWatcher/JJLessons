package com.ifmo.dateTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DateTimeExample {
    public static void main(String[] args) {
        ////////////////////////////// класс Date до 8 java //////////////////////////////////
        // хранит дату в милисекундах
        Date date = new Date();
        System.out.println(date);
        Date date1 = new Date();

        // если содержит дату больше чем в дата, то вернет тру
        date.after(date1);
        //то же сакмое, только наоборот
        date.before(date1);

        // сравнение, если меньше, то -1, если больше то 1
        date.compareTo(date1);


        // форматирование даты
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH.mm");
        System.out.println(format.format(date));

        Calendar calendar = new GregorianCalendar(2019, Calendar.APRIL, 24);
        Calendar calendar1 = new GregorianCalendar(2019, Calendar.APRIL, 12);
        // увеличение и уменьшение даты
        calendar1.add(Calendar.DAY_OF_MONTH, 2);
        calendar.add(Calendar.MONTH, -3);

        //////////////////////////// java 8 - Date Time API ///////////////////////////////////
        // только для даты
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        LocalDate someDate = LocalDate.of(2019, Month.JULY, 21);

        // форматирование
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd - MM - yyyy");
        String strDate = "14/10/2013";

        LocalDate parseDate = LocalDate.parse(strDate, dateTimeFormatter);
        System.out.println(parseDate);

        // уменьшить или увеличить месяцы дни и т.д
        LocalDate tomorrow = localDate.plus(1, ChronoUnit.DAYS);

        // метод возвращает день недели из скобок в текстовом виде
        DayOfWeek dayOfWeek = LocalDate.parse("2012 - 07 - 12").getDayOfWeek();

        // вернет число месяца
        int dayOfMonth = LocalDate.parse("2012 - 07 - 12").getDayOfMonth();

        // високосный или не високосный год
        LocalDate.now().isLeapYear();

        // получить все даты между датами из списка


        // только для времени
        LocalTime time = LocalTime.now();

        LocalTime setTime = LocalTime.of(12, 34);

        LocalTime setParseTime = LocalTime.parse("12:10");


        // дата и время
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.CANADA));


        // при работе с датой (промежутки)
        LocalDate start = LocalDate.parse("2006 - 04 - 12");
        LocalDate end = start.plus(Period.ofDays(67));

        // сколько дней между датами
        int between = Period.between(start, end).getDays();
        long between2 = ChronoUnit.DAYS.between(start,end);

        // промежутки времени
//        Duration;
        LocalTime localTime = LocalTime.of(7, 12);
        LocalTime localTime1 = localTime.plus(Duration.ofMinutes(23));

        long timeB = Duration.between(localDate, localTime1).getSeconds();

        ////////////////////////// временные зоны ///////////////////////////
        Set<String> allZoneSet = ZoneId.getAvailableZoneIds();
        System.out.println(allZoneSet);

        ZoneId zoneId = ZoneId.of("America/Cuiaba");
    }
}
