import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BookController {
    private Book[] model;
    private BookView view;
    private Scanner scanner = new Scanner(System.in);

    public BookController(Book[] model, BookView view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        int choice;
        do {
            view.printMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> view.printBooks(model);
                case 2 -> findByAuthor();
                case 3 -> findByPublisher();
                case 4 -> findAfterYear();
                case 5 -> sortByPublisher();
                case 0 -> System.out.println("Завершення роботи.");
                default -> System.out.println("Невірний вибір!");
            }
        } while (choice != 0);
    }

    private void findByAuthor() {
        String author = "Robert Galbraith"; 
        view.printMessage("Пошук книг автора: " + author);
        Book[] result = Arrays.stream(model)
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .toArray(Book[]::new);
        view.printBooks(result);
    }

    private void findByPublisher() {
        String pub = "Lifera";
        view.printMessage("Книги видавництва: " + pub);
        Book[] result = Arrays.stream(model)
                .filter(b -> b.getPublisher().equalsIgnoreCase(pub))
                .toArray(Book[]::new);
        view.printBooks(result);
    }

    private void findAfterYear() {
        int year = 2010;
        view.printMessage("Книги після " + year + " року");
        Book[] result = Arrays.stream(model)
                .filter(b -> b.getYear() > year)
                .toArray(Book[]::new);
        view.printBooks(result);
    }

    private void sortByPublisher() {
        view.printMessage("Сортування за видавництвом");
        Arrays.sort(model, Comparator.comparing(Book::getPublisher));
        view.printBooks(model);
    }
}