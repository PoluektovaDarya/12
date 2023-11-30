import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^((\\d|1?\\d\\d|2([0-4]\\d|5[0-5]))\\.){3}(\\d|1?\\d\\d|2([0-4]\\d|5[0-5]))$");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ipTxt.txt"))) {
            while (true) {
                System.out.print("Введите IP-адрес (или 'exit' для завершения): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("exit")) break;

                String message = pattern.matcher(input).matches() ? "Корректный" : "Некорректный";
                writer.write(message + " IP-адрес: " + input + "\n");
                System.out.println(message + " IP-адрес: " + input);
            }

            System.out.println("Сведения о IP-адресах записаны в файл ipTxt.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}
