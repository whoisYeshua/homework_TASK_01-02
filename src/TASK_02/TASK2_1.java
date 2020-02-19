package TASK_02;
/* Stringbuilder с поддержкой операции undo
Напишите свой класс StringBuilder с поддержкой операции undo. Для этого
делегируйте все методы стандартному StringBuilder, а в собственном классе
храните список всех операций для выполнения undo().*/

import java.util.Stack;

public class TASK2_1 {
    public static void main(String[] args) {

        NewStringBuilder sb = new NewStringBuilder();
        sb.append("hello");
        sb.append("world");
        sb.undo();
        System.out.println(sb);

    }
}

class NewStringBuilder {

    private StringBuilder sBuilder; // делегат

    private Stack<NewStringBuilder> stack = new Stack<>();

    // конструктор
    public NewStringBuilder() {
        sBuilder = new StringBuilder();
    }

    public void append(String str) {
        sBuilder.append(str);

        NewStringBuilder action = new NewStringBuilder() {
            public void undo() {
                sBuilder.delete(sBuilder.length() - str.length(), sBuilder.length());
            }
        };

        stack.add(action);
    }

    public void undo() {
        if (!stack.isEmpty()) {
            stack.pop().undo();
        }
    }

    public String toString() {
        return sBuilder.toString();
    }
}
