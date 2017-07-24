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
    }
    }
    

