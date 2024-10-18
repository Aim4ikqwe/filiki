import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    // Метод для поиска самой длинной цепочки 'X' с использованием регулярных выражений
    public static int findLongestXChain(String line) {
        Pattern pattern = Pattern.compile("X+");
        Matcher matcher = pattern.matcher(line);
        int maxLength = 0;

        // Поиск всех последовательностей 'X'
        while (matcher.find()) {
            int length = matcher.end() - matcher.start(); // Длина текущей последовательности 'X'
            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String fileName = "24_demo.txt"; // Имя файла
        int globalMax = 0; // Глобальный максимум для всех строк файла

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Чтение файла построчно
            while ((line = reader.readLine()) != null) {
                int localMax = findLongestXChain(line); // Поиск максимальной цепочки в текущей строке
                if (localMax > globalMax) {
                    globalMax = localMax; // Обновляем глобальный максимум, если текущая строка длиннее
                }
            }

            // Вывод результата
            System.out.println("Самая длинная последовательность X: " + globalMax);

        } catch (IOException e) {
            // Обработка ошибок
            System.out.println("Ошибка в чтении файла: " + e.getMessage());
        }
    }
}
