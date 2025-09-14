package m1;

import m1.m1p1.CustomHashSet;
import m1.m1p1.CustomLinkedList;
import m1.m1p2.Book;
import m1.m1p2.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Модуль 1 задание 1");

        System.out.println("\tCustom Hash Set");
        CustomHashSet<String> hs = new CustomHashSet<>();
        hs.add("str1");
        hs.add("str2");
        hs.add(new String("str2"));

        System.out.println(hs);

        hs.remove("str2");

        System.out.println(hs);

        System.out.println("\n\tCustom Linked List");
        CustomLinkedList<String> ll = new CustomLinkedList<>();
        ll.add("str1");
        ll.add("test");
        ll.add("str2");
        ll.add("str3", 2);

        System.out.println(ll.get(1));

        ll.remove("test");

        ll.print();

        ll.addAll(List.of("one", "two", "three"), 1);

        ll.print();

        System.out.println("\nМодуль 1 задание 2");

        List<Student> students = new ArrayList<>();
        Student s = new Student("Иванов", "Дмитрий", "Сергеевич");
            s.addBook("Серебряный горизонт", "Кузнецов Павел Андреевич", 312, 1986);
            s.addBook("Песнь ветров", "Фёдоров Николай Олегович", 254, 1918);
            s.addBook("Туманный архив", "Смирнова Анна Игоревна", 401, 1909);
            s.addBook("Порог грозы", "Морозов Евгений Петрович", 378, 1991);
            s.addBook("Каменные зеркала", "Горбунова Елена Викторовна", 295, 1923);
        students.add(s);

        s = new Student("Соколова", "Мария", "Андреевна");
            s.addBook("Осколки времени", "Захаров Виктор Львович", 276, 2005);
            s.addBook("Крылья за стеной", "Тарасова Ольга Сергеевна", 333, 1977);
            s.addBook("Чёрный маяк", "Орлов Артём Максимович", 418, 2009);
            s.addBook("След в пыли", "Васильев Степан Алексеевич", 362, 2020);
            s.addBook("Нить рассвета", "Полякова Дарья Михайловна", 289, 1982);
        students.add(s);

        s = new Student("Васильева", "Ольга", "Игоревна");
            s.addBook("Театр теней", "Макаров Константин Юрьевич", 299, 1995);
            s.addBook("Алый дождь", "Филатова Анастасия Романовна", 361, 2000);
            s.addBook("Дворцы пепла", "Шестаков Роман Валерьевич", 412, 2019);
            s.addBook("Зелёные огни", "Сидоров Аркадий Викторович", 280, 2022);
            s.addBook("Последний компас", "Чернова Ксения Владиславовна", 355, 1969);
        students.add(s);

        s = new Student("Петров", "Алексей", "Викторович");
            s.addBook("Город без дверей", "Сафонов Илья Дмитриевич", 344, 2014);
            s.addBook("Песок и стекло", "Калинина Татьяна Борисовна", 287, 1956);
            s.addBook("Забытый шифр", "Романов Кирилл Владиславович", 390, 1988);
            s.addBook("Эхо расселин", "Кравцова Светлана Павловна", 273, 2001);
            s.addBook("Холодная станция", "Никитин Андрей Семёнович", 425, 2024);
        students.add(s);

        s = new Student("Кузнецов", "Сергей", "Николаевич");
            s.addBook("Вечный путь", "Данилова Виктория Андреевна", 376, 2016);
            s.addBook("Башня из праха", "Котов Михаил Евгеньевич", 298, 1998);
            s.addBook("Лабиринт отражений", "Жукова Наталья Олеговна", 431, 1971);
            s.addBook("Сердце бурь", "Григорьев Дмитрий Станиславович", 389, 2021);
            s.addBook("Мост через облака", "Ефимова Алина Артёмовна", 310, 2006);
        students.add(s);


        students.stream()
                .peek(System.out::println)
                .map(Student::getBooks)
                .forEach(e->e.stream()
                    .sorted()
                    .distinct()
                    .filter(b->b.getPublicationYear()>=2000)
                    .limit(3)
                    .map(Book::getPublicationYear)
                    .findFirst()
                    .ifPresentOrElse(System.out::println, ()-> System.out.println("Книг не обнаружено"))
                );

    }
}