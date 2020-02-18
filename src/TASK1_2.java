/*Напишите метод, который проверяет, входит ли в массив заданный элемент или нет.
Используйте перебор и двоичный поиск для решения этой задачи.
Сравните время выполнения обоих решений для больших
массивов (например, 100000000 элементов).*/

import java.util.Scanner;

public class TASK1_2 {
    // Перебираем элименты один за другим, временная сложнасть будет O(N).
    public static boolean linearSearch(int[] arr, int el) {

        for (int i : arr) {
            if (i == el)
                return true;
        }
        return false;
    }

    // Алгоритм делит входной массив на равные половины, и с каждой итерацией сравнивает элемент, который ищем, с элементом в середине, временная сложность O(log(N)).
    public static boolean iterativeBinarySearch(int[] arr, int el) {
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        // Условие прекращения
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;

            // Если средний элименты, тот элимент, что мы ищем, то возвращаем true
            if (arr[middleIndex] == el) {
                return true;
            } else if (arr[middleIndex] < el) // Если средний элимент меньше элемента, что ищем, то делаем индекс начала равным индексу среднего элимента + 1
                firstIndex = middleIndex + 1;

            else if (arr[middleIndex] > el) // Если средний элимент больше элемента, что ищем, то делаем индекс конца равным индексу среднего элимента - 1
                lastIndex = middleIndex - 1;

        }

        return false;
    }

    // Создаем массив из 100000000 упорядоченных элементов
    public static void main(String[] args) {
        int[] arr = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            arr[i] = i;
        }

        //Принимаем значение, которое введем с клавиатуры, значение будет целого типа
        System.out.print("Введите число, которое будем искать в массиве: ");
        Scanner scan = new Scanner(System.in);
        int el = scan.nextInt();

        // Записываем в переменню булевую переменную результат метода linearSearch. В метод linearSearch передаем наш массив и значение, которое ищем.
        long linearTime = System.nanoTime();
        boolean linearStatus = linearSearch(arr, el);
        print(el, linearStatus);
        linearTime = System.nanoTime() - linearTime;
        System.out.printf("Время на выполнение линейным поиском %d нс\n\n", linearTime);

        // Реализовали измерение времени через метод System.nanoTime() (он более подробный в данном случае (в отличие от System.currentTimeMillis()), так как поиск занимал меньше 1 мс), перед вызовом метода записываем текущее время в нс, после выполнения тоже записываем и потом просто вычитаем
        long iterativeBinaryTime = System.nanoTime();
        boolean iterativeBinaryStatus = iterativeBinarySearch(arr, el);
        print(el, iterativeBinaryStatus);
        iterativeBinaryTime = System.nanoTime() - iterativeBinaryTime;
        System.out.printf("Время на выполнение итеративным бинарным поиском %d нс\n", iterativeBinaryTime);

    }

    // Выводим найден, если true и не найден, если false, в параметры метода принимают элимент, который мы искали и статус (найден или нет)
    public static void print(int el, boolean status) {
        if (status) {
            System.out.println(el + " найден.");
        } else {
            System.out.println(el + " не найден.");
        }
    }


}
