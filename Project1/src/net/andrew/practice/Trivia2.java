package net.andrew.practice;

import java.util.Scanner;

public class Trivia2 {
    public static void main(String[] args) {
        String questions[]=new String[5];
        String answers[]=new String[5];
        String userAnswers[]=new String[5];
        int points=0;
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


        repeat(points,questions,answers,userAnswers);

    }
    public static void getAnswer(String questions[], String userAnswers[],String answers[],int points){
        for(int i=0;i< questions.length;i++){
            Scanner scanner = new Scanner(System.in);
            System.out.println(questions[i]);
            String input = scanner.next();
            userAnswers[i]=input;
        }
        checkCorrect(userAnswers,answers,points);
    }
    public static void repeat(int points,String questions[],String answers[],String userAnswers[]){
        String wantrepeat="yes";
      // while(true){
            getAnswer(questions,userAnswers,answers,points);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Want to repeat the trivia?");
            String input2 = scanner.next();
            if(input2.toLowerCase().equals(wantrepeat)){
                points=0;
                repeat(points,questions,answers,userAnswers);
           //     continue;
            }
           // else{
               // break;
           // }
       // }
    }
    public static void checkCorrect(String userAnswers[],String answers[],int points){
        for(int n=0;n< answers.length;n++){
            int cuenta=n+1;
            if(userAnswers[n].toLowerCase().equals(answers[n])){
                points++;
                System.out.println("Pregunta "+ cuenta +" correcta");
            }
            else{
                System.out.println("Pregunta "+ cuenta +" incorrecta, la correcta era : " + answers[n]+". Tu respuesta era : "+userAnswers[n]);
            }
        }
        System.out.println("Has obtenido una puntuación de : "+ points);
    }

}
