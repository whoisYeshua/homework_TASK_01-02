package TASK_02;
/*Напишите свой класс StringBuilder, с возможностью оповещения других объектов
об изменении своего состояния.*/

public class TASK2_2 {
    public static void main(String[] strings) {

        NewStringBuilder2 sb = new NewStringBuilder2();
        sb.setChangeListener(new Listener());
        sb.append("hello");
        sb.append("world");
    }
}

abstract class Changer {
    abstract void onChange(NewStringBuilder2 sBuilder);
}

class NewStringBuilder2 {

    private Changer listener;

    private StringBuilder sBuilder; // делегат

    // Сеттер для listener
    public void setChangeListener(Changer listener) {
        this.listener = listener;
    }

    public NewStringBuilder2() {
        sBuilder = new StringBuilder();
    }

    private void notifyChangeListener() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    public NewStringBuilder2 append(Object obj) {
        sBuilder.append(obj);
        notifyChangeListener();
        return this;
    }

    public String toString() {
        return sBuilder.toString();
    }
}

class Listener extends Changer {

    public void onChange(NewStringBuilder2 sBuilder) {
        System.out.println("Изменен: " + sBuilder);
    }
}

