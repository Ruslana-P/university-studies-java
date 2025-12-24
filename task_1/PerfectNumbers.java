import java.util.Scanner;

public class PerfectNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введіть верхню межу діапазону (n): ");
        int n = scanner.nextInt();
        
        System.out.println("Результат пошуку:");
        
        boolean found = false;
        
        for (int number = 1; number <= n; number++) {
            if (isPerfect(number)) {
                System.out.println(number);
                found = true; 
            }
        }
        
        if (!found) {
            System.out.println("У діапазоні від 1 до " + n + " досконалих чисел не знайдено.");
        }
    }

    public static boolean isPerfect(int num) {
        if (num < 2) return false;
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }
}