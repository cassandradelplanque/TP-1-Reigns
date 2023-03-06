package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static main.TypeEffets.*;
import static main.TypePerso.*;


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
    private static ArrayList<Question> questions;

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

        initBanqueQuestions();

        System.out.println("Création du personnage...");

        initPersonnage();


        personnage.jauges.AfficheJauges();

        // tirage des questions
        int nbTours = 0;
        while(!personnage.jauges.finDuJeu()){
            nbTours++;
            Question question = getQuestionAleatoire();
            reponseQuestion(question);
            personnage.jauges.AfficheJauges();
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
        String reponse = "";
        Scanner scanner = new Scanner(System.in);
        reponse = scanner.nextLine();

        int compteur=0;
        for (Map.Entry<TypeEffets, Effet> mapentry : question.effets.listeEffets.entrySet()) {



            if (reponse.equals(mapentry.getKey().toString())){
                compteur+=1;
            }

        }

        while(compteur==0){


            compteur=0;
            for (Map.Entry<TypeEffets, Effet> mapentry : question.effets.listeEffets.entrySet()) {

                if (reponse.equals(mapentry.getKey().toString())){
                    compteur+=1;
                }

            }
            System.out.println("Entrez la réponse (G ou D)");
            System.out.flush();
            reponse = scanner.nextLine();
        }


        // applique les malus
        for (Map.Entry<TypeEffets, Effet> mapentry : question.effets.listeEffets.entrySet()) {
            System.out.println("rep"+reponse);
            System.out.println("key"+mapentry.getKey());
            if (reponse.equals(mapentry.getKey().toString())){

                mapentry.getValue().appliqueEffets(personnage);
            }

        }


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

        int genre = scanner.nextInt();


        Reigns.personnage = new Personnage(TypePerso.values()[genre], nom);
        System.out.println(Reigns.personnage.longRegne());





    }

    /**
     * Cette fonction initialise la banque de questions. Elle crée les questions et les ajoute à la banque.
     */
    private static void initBanqueQuestions(){
        questions = new ArrayList<>();
        var choix1= new ArrayList<String>();
        choix1.add("oui");
        choix1.add("non");
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",choix1);

        question1.effets.listeEffets.get(G).ajouteEffet(TypeJauge.ARMEE, -5);
        question1.effets.listeEffets.get(G).ajouteEffet(TypeJauge.PEUPLE, +5);
        question1.effets.listeEffets.get(G).ajouteEffet(TypeJauge.PEUPLE, -7);
        questions.add(question1);
        var choix2= new ArrayList<String>();
        choix2.add("Importer de la nourriture");
        choix2.add("Ne rien faire");
        Question question2 = new Question(
                "Paysan",
                "Il n'y a plus rien à manger",
                choix2);
        question2.effets.listeEffets.get(G).ajouteEffet(TypeJauge.FINANCE,-5);
        question2.effets.listeEffets.get(G).ajouteEffet(TypeJauge.PEUPLE, +5);
        question2.effets.listeEffets.get(D).ajouteEffet(TypeJauge.PEUPLE, -5);
        questions.add(question2);
        var choix3= new ArrayList<String>();
        choix3.add("Faire un sacrifice");
        choix3.add("Ne rien faire");
        Question question3 = new Question(
                "Prêtre",
                "Les dieux sont en colère",
                choix3);
        question3.effets.listeEffets.get(G).ajouteEffet(TypeJauge.CLERGE, +5);
        question3.effets.listeEffets.get(G).ajouteEffet(TypeJauge.PEUPLE, -3);
        question3.effets.listeEffets.get(D).ajouteEffet(TypeJauge.CLERGE, -5);
        questions.add(question3);
        var choix4= new ArrayList<String>();
        choix4.add("Le soutenir");
        choix4.add("Rester neutre");
        Question question4 = new Question(
                "Main du roi",
                "Le roi Baratheon rassemble son armée",
               choix4);
        question4.effets.listeEffets.get(G).ajouteEffet(TypeJauge.ARMEE, +3);
        question4.effets.listeEffets.get(G).ajouteEffet(TypeJauge.FINANCE, -3);
        question4.effets.listeEffets.get(G).ajouteEffet(TypeJauge.CLERGE, -3);
        question4.effets.listeEffets.get(D).ajouteEffet(TypeJauge.PEUPLE, +3);
        questions.add(question4);
        var choix5= new ArrayList<String>();
        choix5.add("Taxer énormément");
        choix5.add( "Taxer un tout petit peu");
        Question question5 = new Question(
                "Paysan",
                "Abondance de récoltes cette année",
               choix5);
        question5.effets.listeEffets.get(G).ajouteEffet(TypeJauge.FINANCE, +10);
        question5.effets.listeEffets.get(G).ajouteEffet(TypeJauge.PEUPLE, -5);
        question5.effets.listeEffets.get(D).ajouteEffet(TypeJauge.FINANCE, +1);
        question5.effets.listeEffets.get(D).ajouteEffet(TypeJauge.PEUPLE, -3);
        questions.add(question5);
    }

    /**
     * Cette fonction permet de tirer une question aléatoire dans la banque de questions.
     * @return Une question aléatoire
     */
    private static Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*questions.size());
        return questions.get(numQuestion);
    }
}