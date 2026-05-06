package homework_two;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    public static List<Student> readStudentsFromFile(String filename) {
        List<Student> students = new ArrayList<>();
        List<Book> currentBooks = new ArrayList<>();
        String currentStudentName = null;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("Студент: ")) {
                    if (currentStudentName != null && !currentBooks.isEmpty()) {
                        students.add(new Student(currentStudentName, currentBooks));
                        currentBooks = new ArrayList<>();
                    }
                    currentStudentName = line.substring(8).trim();

                } else if (line.startsWith("Книга: ")) {
                    String bookInfo = line.substring(7).trim();
                    Book book = parseBook(bookInfo);
                    if (book != null) {
                        currentBooks.add(book);
                    }

                } else if (line.isEmpty() && currentStudentName != null) {
                    students.add(new Student(currentStudentName, currentBooks));
                    currentStudentName = null;
                    currentBooks = new ArrayList<>();
                }
            }

            if (currentStudentName != null && !currentBooks.isEmpty()) {
                students.add(new Student(currentStudentName, currentBooks));
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return students;
    }

    private static Book parseBook(String bookInfo) {
        try {
            int firstQuote = bookInfo.indexOf('"');
            int secondQuote = bookInfo.indexOf('"', firstQuote + 1);
            String title = bookInfo.substring(firstQuote + 1, secondQuote);
            String remaining = bookInfo.substring(secondQuote + 2).trim();


            // Разделяем оставшуюся часть на компоненты: автор, год, страницы
            String[] parts = remaining.split(",\\s*");
            if (parts.length < 3) {
                throw new IllegalArgumentException("Неверный формат информации о книге — недостаточно данных");
            }

            String author = parts[0].trim();
            int year = Integer.parseInt(parts[1].trim());
            int pages = Integer.parseInt(parts[2].trim());

            return new Book(title, author, year, pages);

        } catch (Exception e) {
            System.err.println("Ошибка парсинга книги: " + bookInfo);
            return null;
        }


    }
}
