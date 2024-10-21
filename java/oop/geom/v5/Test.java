package oop.geom.v5;

import java.io.Console;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IllegalArgumentException {


        Scanner scanner = new Scanner(System.in);
        boolean ok =false;
        Circle circle=null;

        do{

            System.out.println("give me the radius");
            String s=scanner.next();
            double r=Double.parseDouble(s);
             try{
                circle = new Circle(r);
                ok=true;
            }catch (NegativeRadiusException e){
                 System.out.println("Please do not joke!");
                 //throw  e;
             }finally {
                 System.out.println("Sto creando cerchi veri!");
             }
        }while (!ok);
        System.out.println(" l'area del cerchio è "+circle.area());
        //Circle c= new Circle(-4);


    }
}
