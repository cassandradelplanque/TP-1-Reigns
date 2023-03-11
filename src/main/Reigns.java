package main;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static main.TypeEffets.*;


/**
 * La classe Reigns représente le programme principal du jeu Reigns
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Reigns {
    /**
     * le personnage joué
     */
    private static Personnage personnage;

    /**
     * la banque de questions
     */


    private static EnsembleQuestions questions;

    protected static EnsembleJauges jauges;

    /**
     * La méthode main lance le jeu Reigns. Il initialise les questions, le personnage,
     * affiche les jauges du personnage et lance une boucle de jeu qui se termine lorsque le personnage perd.
     * Il affiche également le nombre de tours de jeu que le personnage a joué.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args){

        // début du jeu
        System.out.println("Bienvenue sur Reigns");

        jauges= new EnsembleJauges();
        questions= new EnsembleQuestions();

        System.out.println("Création du personnage...");

        initPersonnage();
        jauges.AfficheJauges();

        // tirage des questions
        int nbTours = 0;
        while(!jauges.finDuJeu()){
            nbTours++;
            Question question = questions.getQuestionAleatoire();
            reponseQuestion(question);
            jauges.AfficheJauges();
        }

        // fin du jeu
        System.out.println(
                personnage.getNom()
                        + " a perdu ! Son règne a duré "
                        +nbTours
                        + " tours");

    }

    /**
     * Cette fonction permet de gérer la réponse à une question donnée. Elle affiche la question, demande à
     * l'utilisateur d'entrer une réponse (soit "G" soit "D") et en fonction de la réponse, elle appelle la méthode
     * appropriée pour appliquer les conséquences sur les jauges du personnage.
     * @param question La question à laquelle il faut répondre
     */
    private static void reponseQuestion(Question question){

        question.afficheQuestion();
        // récupère la réponse

        int compteur;
        String reponse;
        Scanner scanner = new Scanner(System.in);
        compteur=0;
        do {
            reponse = scanner.nextLine();

            for (Map.Entry<TypeEffets, Effet> mapentry : question.effets.listeEffets.entrySet()) {

                if (reponse.equals(mapentry.getKey().toString())){
                    mapentry.getValue().appliqueEffets(jauges);
                    compteur=1;

                }

            }

        } while(compteur==0);




    }

    /**
     * Cette fonction permet d'initialiser le personnage joué. Elle demande à l'utilisateur de saisir le nom du personnage
     * et le genre (Roi ou Reine). Elle crée ensuite le personnage.
     */

    private static void initPersonnage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        String nom = scanner.nextLine();
        System.out.println("Faut-il vous appeler");
        int nb= 0;
        for(TypePerso tp : TypePerso.values()){
            System.out.println(tp + "("+ nb +")");
            nb++;
        }
        System.out.println("?");
        int genre;
        do {
            genre = scanner.nextInt();

        } while(genre<0 || genre > nb);

        Reigns.personnage = new Personnage(TypePerso.values()[genre], nom);
        System.out.println(Reigns.personnage.longRegne());

    }

    /**
     * Cette fonction initialise la banque de questions. Elle crée les questions et les ajoute à la banque.
     */

}