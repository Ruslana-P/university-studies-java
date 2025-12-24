public class BookView {
    public void printMenu() {
        System.out.println("\n--- МЕНЮ КНИЖКОВОГО МАГАЗИНУ ---");
        System.out.println("1. Вивести весь список книг");
        System.out.println("2. Книги заданого автора");
        System.out.println("3. Книги заданого видавництва");
        System.out.println("4. Книги, видані після вказаного року");
        System.out.println("5. Відсортувати за видавництвом");
        System.out.println("0. Вихід");
        System.out.print("Виберіть дію: ");
    }

    public void printBooks(Book[] books) {
        if (books.length == 0) {
            System.out.println("Результатів не знайдено.");
        } else {
            for (Book b : books) System.out.println(b);
        }
    }

    public void printMessage(String message) {
        System.out.println("\n--- " + message + " ---");
    }
}