package main;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


public class Question {

    protected String nomPersonnage;

    protected String question;

    protected ArrayList<Proposition> propositions;



    public Question(String nomPersonnage,
                    String question) {
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.propositions= new ArrayList<Proposition>();

    }



    public void afficheQuestion() {
        String result = "["+nomPersonnage+"] "
                + question;
        System.out.println(result);

        for(Proposition p: this.propositions){
            p.AfficheProposition();

        }
        String choix = "Entrez la réponse (";
        int test= 0;
        for(Proposition p: this.propositions){

            p.AfficheEffetsProposition();
            if (test != 0) {

                choix+= " ou ";

            }
            test=1;
            choix+= p.type.toString();
        }
        choix+=")";
        System.out.println(choix);

    }
    public void reponseQuestion(EnsembleJauges jauges){

        afficheQuestion();
        // récupère la réponse

        int compteur;
        String reponse;
        Scanner scanner = new Scanner(System.in);
        compteur=0;
        do {
            reponse = scanner.nextLine();

            for (Proposition proposition : propositions) {

                if (reponse.equals(proposition.type.toString())){
                    proposition.appliqueEffets(jauges);
                    compteur=1;

                }

            }

        } while(compteur==0);




    }







}
