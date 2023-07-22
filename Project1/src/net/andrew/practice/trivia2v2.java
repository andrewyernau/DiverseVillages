package net.andrew.practice;

import java.util.Scanner;

public class trivia2v2 {
    public static void main(String[] args) {
        String[] questions=new String[5];
        String[] answers=new String[5];

        questions[0]="En qué continente está Canadá";
        questions[1]="Cuál es el símbolo del Hierro en la tabla periódica";
        questions[2]="Cuál es el proceso que realiza la planta para obtener Oxígeno del Dióxido de Carbono";
        questions[3]="Cuándo ha acabado la segunda guerra mundial";
        questions[4]="De qué está compuesto principalmente el Sol";
        answers[0]="america";
        answers[1]="fe";
        answers[2]="fotosintesis";
        answers[3]="1945";
        answers[4]="helio";

        Scanner scanner = new Scanner(System.in);
        int points=0;
        while(true){
            printTitle();
            for (int i = 0; i < questions.length; i++) {
                printQuestion(questions[i]);
                String userAnswers=scanner.next();
                if(checkCorrect(userAnswers,answers[i])){
                    printCorrect();
                    points=increasePoints(points);
                    printCurrentPoints(points);
                }
                else {
                    printIncorrect();
                    printCorrectAnswer(answers[i]);
                }
            }
            printTotalPoints(points);
            printPlayAgain();
            if(scanner.next().equals("yes")){
                points=0;
                continue;
            }
            else{
                break;
            }
        }


    }


    public static boolean checkCorrect(String userAnswers,String answers){

            return userAnswers.equals(answers);
    }
    public static void printTitle(){

        System.out.println("///TRIVIA///");
    }
    public static void printQuestion(String questions){
        System.out.println(questions);
    }
    public static int increasePoints(int points){
        points++;
        return points;
    }
    public static void printCurrentPoints(int points){
        System.out.println("You have "+ points + " points");
    }
    public static void printCorrect(){
        System.out.println("You are correct");
    }
    public static void printIncorrect(){
        System.out.println("You are wrong");
    }
    public static void printCorrectAnswer(String answers){
        System.out.println("The correct answer is: "+ answers);
    }
    public static void printTotalPoints(int points){
        System.out.println("The total points obtained are : "+ points);
    }
    public static void printPlayAgain(){
        System.out.println("Do you want to play again?");
    }
}