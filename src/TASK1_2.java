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


    public static boolean iterativeBinarySearch(int[] arr, int el) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;

            if (arr[middleIndex] == el) {
                return true;
            } else if (arr[middleIndex] < el)
                firstIndex = middleIndex + 1;

            else if (arr[middleIndex] > el)
                lastIndex = middleIndex - 1;

        }

        return false;
    }


    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }

        System.out.print("Введите число, которое будем искать в массиве: ");
        Scanner scan = new Scanner(System.in);
        int el = scan.nextInt();

        long time = System.nanoTime();
        boolean status0 = linearSearch(arr, el);
        print(el, status0);
        time = System.nanoTime() - time;
        System.out.printf("Время на выполнение линейным поиском %d нс\n\n", time );

        long time1 = System.nanoTime();
        boolean status1 = iterativeBinarySearch(arr, el);
        print(el, status1);
        time1 = System.nanoTime() - time1;
        System.out.printf("Время на выполнение иттеративным бинарным поиском %d нс\n", time1);

    }


    public static void print(int el, boolean status) {
        if (status) {
            System.out.println(el + " найден.");
        } else {
            System.out.println(el + " не найден.");
        }
    }


}
