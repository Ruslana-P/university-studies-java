public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book("The Cuckoo’s Calling", "Robert Galbraith", "Sphere", 2013, 500, 750.0),
            new Book("The Silkworm", "Robert Galbraith", "Sphere", 2014, 300, 850.0),
            new Book("Witcher: Season of Storms", "Andrzej Sapkowski", "Empik", 2013, 80, 900.0),
            new Book("Witcher: The Last Wish", "Andrzej Sapkowski", "Empik", 1993, 320, 300.0),
            new Book("The Secret Adversary", "Agatha Christie", "Lifera", 1992, 200, 350.0),
            new Book("The Secret of Chimneys", "Agatha Christie", "Lifera", 1995, 330, 280.0),
            new Book("Career of Evil", "Robert Galbraith", "Sphere", 2015, 400, 800.0),
            new Book("Troubled Blood", "Robert Galbraith", "Sphere", 2020, 120, 780.0),
            new Book("The Mystery of the Blue Train", "Agatha Christie", "Lifera", 1928, 150, 200.0),
            new Book("Withcer: Sword of Destiny", "Andrzej Sapkowski", "Empik", 1992, 1100, 600.0)
        };

        BookView view = new BookView();
        BookController controller = new BookController(books, view);
        
        view.printMessage("Вихідний масив даних:");
        view.printBooks(books);
        
        controller.start();
    }
}