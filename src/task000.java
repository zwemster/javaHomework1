import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.InputMismatchException;

public class task000 {
    public static void main(String[] args){
        Logger logging = Logger.getLogger(task000.class.getName());
        Scanner scanner = new Scanner(System.in);
        byte inputNumber;
        System.out.print("Введите число: ");

        try {
            inputNumber = scanner.nextByte();
            FileWriter fileWriter = new FileWriter("result.txt");
            fileWriter.write(inputNumber);
            fileWriter.close();
            System.out.println("Готово. Запись произведена.");
        } catch (IOException e) {
            logging.severe("Ошибка при записи в файл: " + e.getMessage());
        }
        catch (InputMismatchException e) {
            logging.severe("Ошибка ввода: " + e.getMessage());
        }
    }
}
