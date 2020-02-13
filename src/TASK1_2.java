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

    public static boolean recursiveBinarySearch(int[] arr, int firstElement, int lastElement, int el) {

        if (lastElement >= firstElement) {
            int mid = firstElement + (lastElement - firstElement) / 2;

            if (arr[mid] == el)
                return true;

            if (arr[mid] > el)
                return recursiveBinarySearch(arr, firstElement, mid - 1, el);

            return recursiveBinarySearch(arr, mid + 1, lastElement, el);
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

        boolean status0 = linearSearch(arr, el);
        print(el, status0);

        boolean status1 = iterativeBinarySearch(arr, el);
        print(el, status1);

        boolean status2 = recursiveBinarySearch(arr, arr[0],arr.length, el);
        print(el, status2);

    }


    public static void print(int el, boolean status) {
        if (status) {
            System.out.println(el + " найден.");
        } else {
            System.out.println(el + " не найден.");
        }
    }


}
