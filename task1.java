// Дан Deque состоящий из последовательности цифр.
// Необходимо проверить, что последовательность цифр является палиндромом

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите последовательность цифр через пробел: ");
        String input = scanner.nextLine();

        String[] numbers = input.split(" ");
        Deque<Integer> deque = new ArrayDeque<>();
        for (String number : numbers) {
            deque.add(Integer.parseInt(number));
        }

        if (checkOn(deque)) {
            System.out.println("Последовательность является палиндромом");
        } else {
            System.out.println("Последовательность не является палиндромом");
        }
    }

   
    public static boolean checkOn(Deque<Integer> deque) {
        
        Deque<Integer> copyDeque = new ArrayDeque<>(deque);

        
        while (copyDeque.size() > 1) {
           
            int first = copyDeque.pollFirst();
            int last = copyDeque.pollLast();

           
            if (first != last) {
                return false;
            }
        }

        
        return true;
    }
}