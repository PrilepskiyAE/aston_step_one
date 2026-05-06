import homework_one.ImmutablePerson;
import homework_one.Person;
import homework_two.Book;
import homework_two.Student;
import homework_two.StudentManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //  homeworkOne();
        homeworkTwo();
    }

    static void homeworkOne() {
        //Homework one
        // Реализовать свой иммутабельный класс, который будет внутри себя содержать поле с изменяемым классом.
        // для удобства я создал два класса ImmutablePerson Person
        Person originalPerson = new Person("Alex", 33);
        ImmutablePerson immutablePerson = new ImmutablePerson(originalPerson);
        System.out.println("Исходное состояние: " + immutablePerson);

        originalPerson.setAge(34);
        originalPerson.setName("Prilepskiy Alex");

        System.out.println("После изменения исходного Person: " + immutablePerson);
        System.out.println("Исходный Person теперь: " + originalPerson);

        Person personFromImmutable = immutablePerson.getPerson();
        personFromImmutable.setAge(-100);
        personFromImmutable.setName("Hacker");

        System.out.println("После попытки изменения через геттер: " + immutablePerson);
        System.out.println("Копия из геттера: " + personFromImmutable);
        /*
        Вывод:

         Исходное состояние: ImmutablePerson{person=Person{name='Alex', age=33}}
         После изменения исходного Person: ImmutablePerson{person=Person{name='Prilepskiy Alex', age=34}}
         Исходный Person теперь: Person{name='Prilepskiy Alex', age=34}
         После попытки изменения через геттер: ImmutablePerson{person=Person{name='Prilepskiy Alex', age=34}}
         Копия из геттера: Person{name='Hacker', age=-100}
        */
    }

    static void homeworkTwo() {
        List<Student> students = StudentManager.readStudentsFromFile("students.txt");
       // System.out.println("Загруженные студенты:\n");
       // students.forEach(System.out::println);
        System.out.println("-----------------------\n");

        students
                .stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooks().stream())
                .sorted()
                .distinct()
                .filter(book -> book.getYear() > 2000).limit(3).map(Book::getYear).findFirst()
                .ifPresentOrElse(
                        year -> System.out.println("Год выпуска найденной книги: " + year),
                        () -> System.out.println("Книга не найдена")
                );
    }
}