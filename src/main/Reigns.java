package main;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static main.TypeEffets.*;



public class Reigns {

    private static Personnage personnage;


    private static EnsembleQuestions questions;

    protected static EnsembleJauges jauges;


    public static void main(String[] args){


        System.out.println("Bienvenue sur Reigns");

        jauges= new EnsembleJauges();
        questions= new EnsembleQuestions();

        System.out.println("Création du personnage...");

        personnage= new Personnage();
        jauges.AfficheJauges();


        int nbTours = 0;
        while(!jauges.finDuJeu()){
            nbTours++;
            Question question = questions.getQuestionAleatoire();
            question.reponseQuestion(jauges);
            jauges.AfficheJauges();
        }


        System.out.println(
                personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        +nbTours
                        + " tours");

    }


}