import m1p1.CustomHashSet;
import m1p1.CustomLinkedList;
import m1p2.Book;
import m1p2.Student;

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

        ll.Print();

        ll.addAll(List.of("one", "two", "three"), 1);

        ll.Print();

        System.out.println("\nМодуль 1 задание 2");

        List<Student> students = new ArrayList<>();
        Student s = new Student("Иванов", "Дмитрий", "Сергеевич");
            s.AddBook("Серебряный горизонт", "Кузнецов Павел Андреевич", 312, 1986);
            s.AddBook("Песнь ветров", "Фёдоров Николай Олегович", 254, 1918);
            s.AddBook("Туманный архив", "Смирнова Анна Игоревна", 401, 1909);
            s.AddBook("Порог грозы", "Морозов Евгений Петрович", 378, 1991);
            s.AddBook("Каменные зеркала", "Горбунова Елена Викторовна", 295, 1923);
        students.add(s);

        s = new Student("Соколова", "Мария", "Андреевна");
            s.AddBook("Осколки времени", "Захаров Виктор Львович", 276, 2005);
            s.AddBook("Крылья за стеной", "Тарасова Ольга Сергеевна", 333, 1977);
            s.AddBook("Чёрный маяк", "Орлов Артём Максимович", 418, 2009);
            s.AddBook("След в пыли", "Васильев Степан Алексеевич", 362, 2020);
            s.AddBook("Нить рассвета", "Полякова Дарья Михайловна", 289, 1982);
        students.add(s);

        s = new Student("Васильева", "Ольга", "Игоревна");
            s.AddBook("Театр теней", "Макаров Константин Юрьевич", 299, 1995);
            s.AddBook("Алый дождь", "Филатова Анастасия Романовна", 361, 2000);
            s.AddBook("Дворцы пепла", "Шестаков Роман Валерьевич", 412, 2019);
            s.AddBook("Зелёные огни", "Сидоров Аркадий Викторович", 280, 2022);
            s.AddBook("Последний компас", "Чернова Ксения Владиславовна", 355, 1969);
        students.add(s);

        s = new Student("Петров", "Алексей", "Викторович");
            s.AddBook("Город без дверей", "Сафонов Илья Дмитриевич", 344, 2014);
            s.AddBook("Песок и стекло", "Калинина Татьяна Борисовна", 287, 1956);
            s.AddBook("Забытый шифр", "Романов Кирилл Владиславович", 390, 1988);
            s.AddBook("Эхо расселин", "Кравцова Светлана Павловна", 273, 2001);
            s.AddBook("Холодная станция", "Никитин Андрей Семёнович", 425, 2024);
        students.add(s);

        s = new Student("Кузнецов", "Сергей", "Николаевич");
            s.AddBook("Вечный путь", "Данилова Виктория Андреевна", 376, 2016);
            s.AddBook("Башня из праха", "Котов Михаил Евгеньевич", 298, 1998);
            s.AddBook("Лабиринт отражений", "Жукова Наталья Олеговна", 431, 1971);
            s.AddBook("Сердце бурь", "Григорьев Дмитрий Станиславович", 389, 2021);
            s.AddBook("Мост через облака", "Ефимова Алина Артёмовна", 310, 2006);
        students.add(s);


        students.stream()
                .peek(System.out::println)
                .map(Student::GetBooks)
                .forEach(e->e.stream()
                    .sorted()
                    .distinct()
                    .filter(b->b.GetPublicationYear()>=2000)
                    .limit(3)
                    .map(Book::GetPublicationYear)
                    .findFirst()
                    .ifPresentOrElse(System.out::println, ()-> System.out.println("Книг не обнаружено"))
                );
    }
}