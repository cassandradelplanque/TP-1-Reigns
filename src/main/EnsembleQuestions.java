package main;

import java.util.ArrayList;

import static main.TypeEffets.D;
import static main.TypeEffets.G;

public class EnsembleQuestions {
    private static ArrayList<Question> questions;

    public EnsembleQuestions() {
        questions = new ArrayList<>();

        Question question1 = new Question("Main du roi", "Le peuple souhaite libérer les prisonniers");
        Proposition prop1= new Proposition("oui", G);
        Proposition prop2= new Proposition("non", D);
        prop1.ajoutEffet(TypeJauge.ARMEE, -5);
        prop1.ajoutEffet(TypeJauge.PEUPLE, +5);
        prop2.ajoutEffet(TypeJauge.PEUPLE, -7);
        question1.propositions.add(prop1);
        question1.propositions.add(prop2);
        questions.add(question1);

        Question question2 = new Question("Paysan", "Il n'y a plus rien à manger");
        Proposition prop3= new Proposition("Importer de la nourriture", G);
        Proposition prop4= new Proposition("Il n'y a plus rien à manger", D);
        prop3.ajoutEffet(TypeJauge.FINANCE,-5);
        prop3.ajoutEffet(TypeJauge.PEUPLE, +5);
        prop4.ajoutEffet(TypeJauge.PEUPLE, -5);
        question2.propositions.add(prop3);
        question2.propositions.add(prop4);
        questions.add(question2);

        Question question3 = new Question("Prêtre", "Les dieux sont en colère");
        Proposition prop5= new Proposition("Faire un sacrifice", G);
        Proposition prop6= new Proposition("Ne rien faire", D);
        prop5.ajoutEffet(TypeJauge.CLERGE, +5);
        prop5.ajoutEffet(TypeJauge.PEUPLE, -3);
        prop6.ajoutEffet(TypeJauge.PEUPLE, -3);
        question3.propositions.add(prop5);
        question3.propositions.add(prop6);
        questions.add(question3);

        Question question4 = new Question("Main du roi", "Le roi Baratheon rassemble son armée");
        Proposition prop7= new Proposition("Le soutenir", G);
        Proposition prop8= new Proposition("Rester neutre", D);
        prop7.ajoutEffet(TypeJauge.ARMEE, +3);
        prop7.ajoutEffet(TypeJauge.FINANCE, -3);
        prop7.ajoutEffet(TypeJauge.CLERGE, -3);
        prop8.ajoutEffet(TypeJauge.PEUPLE, +3);
        question4.propositions.add(prop7);
        question4.propositions.add(prop8);
        questions.add(question4);

        Question question5 = new Question("Paysan", "Abondance de récoltes cette année");
        Proposition prop9= new Proposition("Taxer énormément", G);
        Proposition prop10= new Proposition("Taxer un tout petit peu", D);
        prop9.ajoutEffet(TypeJauge.FINANCE, +10);
        prop9.ajoutEffet(TypeJauge.PEUPLE, -5);
        prop10.ajoutEffet(TypeJauge.FINANCE, +1);
        prop10.ajoutEffet(TypeJauge.PEUPLE, -3);
        question5.propositions.add(prop9);
        question5.propositions.add(prop10);
        questions.add(question5);




    }



    public static Question getQuestionAleatoire(){
        int numQuestion = (int) (Math.random()*questions.size());
        return questions.get(numQuestion);
    }
}