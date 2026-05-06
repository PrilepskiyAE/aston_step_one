package homework_two;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Book> books;

    public Student(String name, List<Book> books) {
        if (books == null) {
            throw new IllegalArgumentException("Список книг не может быть null");
        }
        if (books.size() < 5) {
            throw new IllegalArgumentException("У студента должно быть минимум 5 книг");
        }
        this.name = name;
        this.books = new ArrayList<>(books);
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books); // Возвращаем копию списка для защиты
    }
    public void addBook(Book book) {
        if (book != null) {
            books.add(book);
        }
    }

    public boolean removeBook(Book book) {
        return books.remove(book);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Студент: ").append(name).append("\n");
        sb.append("Книги (всего ").append(books.size()).append("):\n");
        for (Book book : books) {
            sb.append("  - ").append(book).append("\n");
        }
        return sb.toString();
    }
}
