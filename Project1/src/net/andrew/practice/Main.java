package net.andrew.practice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*EJERCICIO 1
        * JUEGO TRIVIA PARA PRACTICAR
        */
        String pregunta1 = "¿Cuál es la capital de Italia?";
        String pregunta2 = "¿Cuántos continentes hay?";
        String pregunta3 = "¿En qué año apareció el Euro?";
        String respuesta1 = "Roma";
        int respuesta2 = 7;
        int respuesta3 = 2002;
        int points = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println(pregunta1);
        String input=scanner.next();
        if(input.equals(respuesta1)){
            System.out.println("Correcto!");
            points++;
        }
        else {
            System.out.println("Incorrecto, la respuiesta correcta es : Roma");
        }
        //PREGUNTA 2
        Scanner scanner2 = new Scanner(System.in);
        System.out.println(pregunta2);
        int input2 = scanner2.nextInt();
        if(input2 == respuesta2){
            System.out.println("Correcto!");
            points++;
        }
        else{
            System.out.println("Incorrecto, la respuiesta correcta es : 7");
        }
        //PREGUNTA 3
        Scanner scanner3 = new Scanner(System.in);
        System.out.println(pregunta3);
        int input3 = scanner2.nextInt();
        if(input3 == respuesta3){
            System.out.println("Correcto!");
            points++;
        }
        else{
            System.out.println("Incorrecto, la respuiesta correcta es : 2002");
        }
        System.out.println("Puntuación obtenida : "+ points);
    }
}