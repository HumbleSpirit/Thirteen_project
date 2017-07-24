/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thirteen_project;
class X 
{
    int a;
    public X(int i) { a = i ; }
}

class Y 
{
    int a; 
    public Y(int i) { a = i ; }
}
class A
{
    public int i = 0;
}
// Создаем производный класс,
class В extends A
{
    int i; // Эта переменная i скрывает i класса А.
    public В(int a, int b)
    {
        super.i = a; // Так можно обратиться к i класса А.
        i = b; // Переменная i в классе В.
    }
    public void show()
    {
        // Эта инструкция отображает переменную i в классе А.
        System.out.println("i в базовом классе: " + super.i);
        // Эта инструкция отображает переменную i в классе В.
        System.out.println("i в производном классе: " + i);
    }
}

/**
 *
 * @author Boro_s99
 */
public class Thirteen_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        X x = new X(10);
        X x2;
        Y у = new Y(5);
        x2 = x; // OK, обе переменные имеют одинаковый тип.
        //х2 = у; // Ошибка, здесь переменные разного типа.
        В ob = new В(1, 2);
        ob.show();
        ob.i = 100;
        ob.show();
        
    }
    }
    
/*
1. Многоуровневая иерархия

// Эта программа не скомпилируется.
class X 
{
    int a;
    public X(int i) { a = i ; }
}

class Y 
{
    int a; 
    public Y(int i) { a = i ; }
}

public class Temp {

    
    public static void main(String[] args) {
        X x = new X(10);
        X x2;
        Y у = new Y(5);
        x2 = x; // OK, обе переменные имеют одинаковый тип.
        //х2 = у; // Ошибка, здесь переменные разного типа.
    }
    
}
************************************************************

2. Использование ссылки super для доступа к скрытому полю

class A
{
    public int i = 0;
}
// Создаем производный класс,
class В extends A
{
    int i; // Эта переменная i скрывает i класса А.
    public В(int a, int b)
    {
        super.i = a; // Так можно обратиться к i класса А.
        i = b; // Переменная i в классе В.
    }
    public void show()
    {
        // Эта инструкция отображает переменную i в классе А.
        System.out.println("i в базовом классе: " + super.i);
        // Эта инструкция отображает переменную i в классе В.
        System.out.println("i в производном классе: " + i);
    }
}

public class Temp {

    
    public static void main(String[] args) {
        В ob = new В(1, 2);
        ob.show();
        ob.i = 100;
        ob.show();
    }
    
}
3. Использование ссылки super для доступа к скрытому методу

class A
{
    int i = 0;
    public A(int a)
    {
        i = a; // Член i в классе A.
    }
    public void show()
    {
        System.out.println("Член i в базовом классе A: " + i);
    }
}

// Создаем производный класс
class B extends A
{
    int i; 
    public B(int a, int b)
    {
        super(a);
        i = b; // Член i в классе В.
    }
    public void show()
    {
        super.show();
        System.out.println("Член i в производном классе B: " + i);
    }
}

class C extends B
{
    int i;
    public C(int a, int b, int c)
    {
        super(a,b);
        i = c; // Член i в классе C.
    }
    public void show()
    {
        super.show();
        System.out.println("Член i в производном классе C: " + i);
    }
}

public class Temp {

    
    public static void main(String[] args) {
        C ob = new C(1, 2, 3);
        ob.show();
    }
    
}

4. Порядок вызова конструкторов

class A
{
    public A()
    {
        System.out.println("Создание класса А.");
    }
}

// Создаем класс, производный от А
class B extends A
{
    public B()
    {
        System.out.println("Создание класса В.");
    }
}

// Создаем класс, производный от В
class C extends B
{
    public C()
    {
        System.out.println("Создание класса С.");
    }
}

public class Temp {

    
    public static void main(String[] args) {
       C c = new C();
    }
    
}

5. Ссылки на базовый класс и объект производных классов

class X
{
    public int a;
    public X(int i)
    {
        a = i;
    }
}

class Y extends X
{
    public int b;
    public Y(int i, int j)
    {
        super(j);
        b = i;
    }
}

public class Temp {

    
    public static void main(String[] args) {
        X x = new X(10);
        X x2;
        Y у = new Y(5, 6);
        x2 = x; // OK, обе переменные имеют одинаковый тип.
        System.out.println("x2.a: " + x2.a);
        x2 = у; // Все равно ok, поскольку класс Y  выведен из класса X.
        System.out.println("х2.а: " + x2.a);
        // Х-ссылки "знают" только о членах класса X.
        x2.a = 19; // ОК
        //х2.b = 27; // Ошибка, в классе X нет члена b.
    }
    
}

6. Конструктор со ссылочным параметром
class TwoDShape
{
    private double pri_width; // Закрытый член
    private double pri_height; // Закрытый член

    // Конструктор по умолчанию
    public TwoDShape() 
    {
        this(0, 0);
    }
    // Конструктор класса TwoDShape
    public TwoDShape(double w, double h)
    {
        setWidth(w);
        setHeight(h);
    }
    // Конструктор, создающий объекты, у которых  ширина равна высоте
    public TwoDShape(double x)
    {
         this(x, x);
    }
    // Создаем объект из объекта
    public TwoDShape(TwoDShape ob)
    {
        setWidth(ob.getWidth());
        setHeight(ob.getHeight());
    }

    public void setWidth(double value)
    {
         pri_width = value; 
    }
    public double getWidth()
    {
         return pri_width; 
    }
    public double getHeight()
    {
         return pri_height; 
    }
    public void setHeight(double value)
    {
        pri_height = value; 
    }
    public void showDim()
    {
        System.out.println("Ширина и высота равны " + getWidth() + " и " + getHeight());
    }
}

// Класс треугольников, производный от класса TwoDShape.
class Triangle extends TwoDShape
{
    private String style; // Закрытый член.
    /* Конструктор по умолчанию. Он вызывает конструктор
    по умолчанию класса TwoDShape. 
    public Triangle() 
    {
        this(null, 0, 0);
    }
    // Конструктор с параметрами.
    public Triangle(String s, double w, double h)
    {
        super(w, h);
        style = s;
    }

    // Создаем равнобедренный треугольник,
    public Triangle(double x)
    {
        super(x);
        style = "равнобедренный";
    }

    // Создаем объект из объекта,
    public Triangle(Triangle ob)
    {
        super(ob);
        style = ob.style;
    }

    // Метод возвращает значение площади треугольника,
    public double area()
    {
        return getWidth() * getHeight() / 2;
    }
    // Метод отображает тип треугольника,
    public void showStyle()
    {
        System.out.println("Треугольник " + style);
    }
}


public class Temp {

    
    public static void main(String[] args) {
        Triangle t1 = new Triangle("прямоугольный", 8.0, 12.0);
        // Создаем копию объекта tl.
        Triangle t2 = new Triangle(t1);
        System.out.println("Информация о tl: ");
        t1.showStyle();
        t1.showDim();
        System.out.println("Площадь равна " + t1.area());
        System.out.println();
        System.out.println("Информация о t2: ");
        t2.showStyle();
        t2.showDim();
        System.out.println("Площадь равна " + t2.area());
    }
    
}
7. Динамическая диспетчеризация методов

class figure
{
    protected double x;
    protected double y;
    public void setDimension(double i, double j)
	{
		x=i;
		y=j;
	}
    public  void showSquare()
        {
                System.out.println("\nValue is undefined\n");
	}
}


class triangle extends figure
{
    public void showSquare()
	{
            System.out.println("\nSquare of triangle: " +  x * 0.5 * y);
	}
}

class rectangle extends figure
{
    public void showSquare()
	{
            System.out.println("\nSquare of rectangle: " + x * y);
	}
}

class circle extends figure
{
    public void showSquare()
	{
            System.out.println("\nSquare of circle: " + 3.14 * x * x);
	}
}


public class Temp {

    
    public static void main(String[] args) {
                        figure p = null;
         
		        p = new triangle();
		        p.setDimension(5.5, 10.0);
		        p.showSquare();
                        
                        p = new rectangle();
		        p.setDimension(5.5, 10.0);
                        p.showSquare();
	
                        p = new circle();
		        p.setDimension(10.0, 0);
                        p.showSquare();
    }
    
}

8. Многоуровневая иерархия
// Создаем базовый класс,
class A
{
    public A()
    {
        System.out.println("Создание класса А.");
    }
    public void Show()
    {
        System.out.println("Класс A");
    }
}

// Создаем класс, производный от А.
class B extends A
{
    public B()
    {
        System.out.println("Создание класса В.");
    }
    public void Show()
    {
        System.out.println("Класс B");
    }
}

// Создаем класс, производный от В.
class C extends B
{
    public C()
    {
        System.out.println("Создание класса С.");
    }
    public void Show()
    {
        System.out.println("Класс C");
    }
}

public class Thirteen_project {

    
    public static void main(String[] args) {
        A refer;
        A a = new A();
        B b = new B();
        C c = new C();
        refer = a;
        refer.Show();
        refer = b;
        refer.Show();
        refer = c;
        refer.Show();
    }
    
}

9. Абстрактный класс

abstract class figure
{
    protected double x;
    protected double y;
    public void setDimension(double i, double j)
    {
        x = i;
        y = j;
    }
    public abstract void showSquare();
}


class triangle extends figure
{
    public void showSquare()
    {
        System.out.println("\nSquare of triangle: " + x * 0.5 * y);
    }
}

class rectangle extends figure
{
    public  void showSquare()
    {
        System.out.println("\nSquare of rectangle: " + x * y);
    }
}

class circle extends figure
{
    public  void showSquare()
    {
        System.out.println("\nSquare of circle: " + 3.14 * x * x);
    }
}
public class Temp {

    
    public static void main(String[] args) {
               figure p = null;
               
                p = new triangle();
                p.setDimension(5.5, 10.0);
                p.showSquare();
                
                p = new rectangle();
                p.setDimension(5.5, 10.0);
                p.showSquare();
                
                p = new circle();
                p.setDimension(10.0, 0); 
        p.showSquare();
    }
    
}

10. Бесплодный класс

final class A
{
    protected int i, j; // в терминальном классе нет смысла создавать защищённые поля
    public A(int a, int b)
    {
        i = a;
        j = b;
    }
    public void show()
    {
        System.out.println(i + " " + j);

    }
}

class B /*: A // нельзя наследоваться от терминального класса
{
    protected int k;
    public B(int k)
    {
        this.k = k;
    }
    public void show()
    {
        System.out.println(k);
    }
}

class C extends B
{
    protected int m;
    public C(int k, int m)
    {
        super(k);
        this.m = m;
    }
    public final void show()
    {
        super.show();
        System.out.println(m);
    }
}

class D extends C
{
    protected int n;
    public D(int k, int m, int n)
    {
        super(k, m);
        this.n = n;
    }
//    
//    public  void show() // нельзя переопределять final-метод
//    {
//        super.show();
//        System.out.println(n);
//    }
    
}
public class Temp {

    
    public static void main(String[] args) {
        B ob = new B(10);
        ob.show();
        ob = new C(10, 20);
        ob.show();
    }
    
}

11. Приведение к объектному типу и восстановление значения


public class Temp {
static int sqr(Object оbj)
    {
        return (int)оbj * (int)оbj;
    }

    
    public static void main(String[] args) {
        int x;
        Object obj;
        x = 10;
        obj = x; // "Превращаем" х в объект.
        int у = (int)obj; // Обратное "превращение" объекта obj в int-значение.
        System.out.println(у);
        x = Temp.sqr(x);
        System.out.println("Значение x в квадрате равно: " + x);
        
        String str = obj.toString();
        System.out.println(str);
    }
    
}
12. Массив обобщённого типа

public class Temp {


    
    public static void main(String[] args) {
       Object[] ga = new Object[10];
        // Сохраняем int-значения.
        for (int i = 0; i < 3; i++)
            ga[i] = i;
        // Сохраняем double-значения.
        for (int i = 3; i < 6; i++)
            ga[i] = (double)i / 2;
        // Сохраняем две строки, bool- и char-значения,
        ga[6] = "Массив обобщенного типа";
        ga[7] = true;
        ga[8] = 'X';
        ga[9] = "Конец";
        for (int i = 0; i < ga.length; i++)
            System.out.println("gа[" + i + "] : " + ga[i] + " ");
    }
    
}


13. Явная реализация интерфейса

interface IMyIF_A
{
    int meth(int x);
}
// В классе MyClass реализован  интерфейс
class MyClass implements IMyIF_A
{
    // Явным образом реализуем  метод meth()
    public int meth(int x)
    {
        return x + x;
    }

    // Вызываем метод meth() посредством ссылки на интерфейс
    public int methA(int x)
    {
        IMyIF_A a_ob;
        a_ob = this;
        return a_ob.meth(x); // Имеется в виду интерфейс IMyIF_A
    }
}
public class Temp {





    
    public static void main(String[] args) {
        MyClass ob = new MyClass();
        System.out.println("Вызов метода IMyIF_A.meth(): ");
        System.out.println(ob.methA(3));
 
        IMyIF_A a = ob;
        System.out.println("Вызов метода IMyIF_A.meth(): ");
        System.out.println(a.meth(4));

    }
    
}

*/
