import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int N = 100;

        while (true) {
            int secret = random.nextInt(N) + 1;
            int attempts = 0;

            System.out.println("Игра 'Угадай число'!");
            System.out.println("Я загадал число от 1 до " + N);

            while (true) {
                System.out.print("Введите число: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Ошибка: нужно ввести число!");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess < 1 || guess > N) {
                    System.out.println("Число вне диапазона!");
                    continue;
                }

                if (guess == secret) {
                    System.out.println("Поздравляю! Вы угадали за " + attempts + " попыток!");
                    break;
                } else if (guess < secret) {
                    System.out.println("Больше!");
                } else {
                    System.out.println("Меньше!");
                }
            }

            System.out.print("Сыграть снова? (y/n): ");
            String again = scanner.next();
            if (!again.equalsIgnoreCase("y")) {
                System.out.println("Спасибо за игру!");
                break;
            }
        }
    }
}
