//Даны два Deque представляющие два неотрицательных целых числа. Цифры хранятся в обратном порядке,
// и каждый из их узлов содержит одну цифру.
// Сложите два числа и верните сумму в виде связанного списка.


 import java.util.ArrayDeque;
 import java.util.Arrays;
 import java.util.Deque;
 import java.util.Scanner;

 public class task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        String s1 = scanner.nextLine();
        System.out.print("Введите второе число: ");
        String s2 = scanner.nextLine();
        Deque<Integer> d1 = parseNumber(s1);
        Deque<Integer> d2 = parseNumber(s2);
        Deque<Integer> result = sum(d1, d2);
        System.out.println("Результат сложения Deque: " + result); 
    }

    public static Deque<Integer> parseNumber(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                deque.addFirst(c - '0');
            } else {
                throw new IllegalArgumentException("Некорректный ввод числа: " + s);
            }
        }
        return deque;
    }

    public static Deque<Integer> sum(Deque<Integer> d1, Deque<Integer> d2) {
        Deque<Integer> result = new ArrayDeque<>();
        int carry = 0; 
        while (!d1.isEmpty() || !d2.isEmpty()) { 
            int x = d1.isEmpty() ? 0 : d1.removeFirst(); 
            int y = d2.isEmpty() ? 0 : d2.removeFirst(); 
            int sum = x + y + carry; 
            result.addLast(sum % 10); 
            carry = sum / 10; 
        }
        if (carry > 0) { 
            result.addLast(carry);
        }
        return result;
    }
}