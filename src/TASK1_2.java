/*Напишите метод, который проверяет, входит ли в массив заданный элемент или нет.
Используйте перебор и двоичный поиск для решения этой задачи.
Сравните время выполнения обоих решений для больших
массивов (например, 100000000 элементов).*/

import java.util.Scanner;

public class TASK1_2 {
    public static boolean linearSearch(int[] arr, int el) {

        for (int i : arr) {
            if (i == el)
                return true;
        }
        return false;
    }



    public static void main(String[] args) {
        int[] arr = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            arr[i] = i;
        }

        System.out.print("Введите число, которое будем искать в массиве: ");
        Scanner scan = new Scanner(System.in);
        int el = scan.nextInt();

        boolean status = linearSearch(arr, el);
        print(el, status);

    }


    public static void print(int el, boolean status) {
        if (status) {
            System.out.println(el + " найден.");
        } else {
            System.out.println(el + " не найден.");
        }
    }


}
