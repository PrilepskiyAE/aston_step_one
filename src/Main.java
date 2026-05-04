import homework_one.ImmutablePerson;
import homework_one.Person;

public class Main {
    public static void main(String[] args) {
        //Homework one
        // Реализовать свой иммутабельный класс, который будет внутри себя содержать поле с изменяемым классом.
        // для удобства я создал два класса ImmutablePerson Person
        Person originalPerson = new Person("Alex", 33);
        ImmutablePerson immutablePerson = new ImmutablePerson(originalPerson);
        System.out.println("Исходное состояние: " + immutablePerson );

        originalPerson.setAge(34);
        originalPerson.setName("Prilepskiy Alex");

        System.out.println("После изменения исходного Person: " + immutablePerson);
        System.out.println("Исходный Person теперь: " + originalPerson);

        Person personFromImmutable= immutablePerson.getPerson();
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
}