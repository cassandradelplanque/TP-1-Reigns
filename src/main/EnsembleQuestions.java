package main;

import java.util.ArrayList;

import static main.TypeEffets.D;
import static main.TypeEffets.G;

public class EnsembleQuestions {
    private static ArrayList<Question> questions;

    public EnsembleQuestions() {
        questions = new ArrayList<>();
        var choix1= new ArrayList<String>();
        choix1.add("oui");
        choix1.add("non");
        Question question1 = new Question(
                "Main du roi",
                "Le peuple souhaite libérer les prisonniers",choix1);

        question1.effets.listeEffets.get(G).ajouteEffet(TypeJauge.ARMEE, -5);
        question1.effets.listeEffets.get(G).ajouteEffet(TypeJauge.PEUPLE, +5);
        question1.effets.listeEffets.get(D).ajouteEffet(TypeJauge.PEUPLE, -7);
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
    public static Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*questions.size());
        return questions.get(numQuestion);
    }
}
