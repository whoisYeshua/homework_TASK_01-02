/*Реализуйте иерархию классов с использованием абстрактных классов
Класс Box является контейнером, он можем содержать в себе другие
фигуры. Метод add() принимает на вход Shape. Нужно добавлять новые
фигуры до тех пор, пока для них хватаем места в Box (будем считать
только объём, игнорируя форму. Допустим, мы переливаем жидкость).
Если места для добавления новой фигуры не хватает, то метод должен
вернуть false.*/

import java.util.ArrayList;

public class TASK1_3 {
    public static void main(String[] args) {

        Cylinder cylinder = new Cylinder(10, 20);
        Ball ball = new Ball(15);
        Pyramid pyramid = new Pyramid(15, 23);
        Box box = new Box(190); // Так как для куба нам не говорили, что нужно считать объем, сразу передадим ему это значение


    }
}

abstract class Shape {

    private double volume; // Ограничиваем видимость переменной в пределах этого класса через protect, модификатор задан в условиях задачи

    public abstract double getVolume(); // Создаем абстрактный метод getVolume, который потом будут переопределять наследники нашего класса Shape
}

abstract class SolidOfRevolution extends Shape {

    protected double radius; // Делаем модификатор доступа protected дабы мы могли использовать переменную в классах-наследниках

    // Конструктор
    public SolidOfRevolution(double radius) {
        this.radius = radius; // Ключевое слово this говорит о том, что radius до равно - это перменная класса, а после это та, что пришла при обращении
    }

    // Метод задан в условиях задачи
    public double getRadius(){
        return radius;
    }

}

class Cylinder extends SolidOfRevolution {

    private double height;

    public Cylinder(double radius, double height) {
        super(radius); // Дабы использовать наследование на полную, мы не объявляем в этом классе radius, так как он уже объявлен в родительском классе SolidOfRevolution. Мы используем ключевое слово super, чтобы вызвать конструктор суперкласса, где radius является уже инициализированной переменной (в родительском классе SolidOfRevolution)
        this.height = height; // Ключевое слово this говорит о том, что height до равно - это перменная класса, а после это та, что пришла при обращении
    }

    // Переопределяем метод getVolume главного класса Shape под цилиндр, его объем V = PI * r^2 * h
    @Override
    public double getVolume() {
        return Math.PI * radius * radius * height;
    }

}

class Ball extends SolidOfRevolution {

    public Ball(double radius) {
        super(radius);
    }

    @Override
    public double getVolume() {
        return Math.PI * radius * radius * radius * 4 / 3;
    }
}

class Pyramid extends Shape {

    private double s;
    private double h;

    public Pyramid(double s, double h){
        this.s = s;
        this.h = h;
    }

    @Override
    public double getVolume() {
        return s * h * 1 / 3;
    }
}

class Box extends Shape {

    private double volume;
    private ArrayList<Shape> figure = new ArrayList<>();

    public Box(double volume) {
        this.volume = volume;
    }

    public boolean Add (Shape shape) {
        if (volume >= shape.getVolume()) {
            figure.add(shape);
            volume -= shape.getVolume();
            return true;
        } else {
            return false;
        }
    }

    // если метод помечен словом abstract (здесь я говорю о getVolume), каждый класс-наследник должен его реализовать или быть объявленным как абстрактный. Иначе компилятор выбросит ошибку. Поэтому делаем наследование, хоть и не будем его использовать
    @Override
    public double getVolume() {
        return volume;
    }
}

