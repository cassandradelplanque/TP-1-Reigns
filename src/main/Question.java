package main;

import java.util.ArrayList;
import java.util.Map;

/**
 * La classe Question représente une question avec ses effets sur les jauges d'un personnage
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public class Question {
    /**
     * nom du personnage associé à la question
     */
    protected String nomPersonnage;
    /**
     * la question
     */
    protected String question;
    /**
     * l'effet de la réponse de gauche
     */
   protected EnsembleEffets effets;


    /**
     * Construit une nouvelle question avec les informations données
     *
     * @param nomPersonnage Le nom du personnage associé à la question
     * @param question La question à poser
     *
     */
    public Question(String nomPersonnage,
                    String question,
                    ArrayList<String> rep) {
        this.nomPersonnage = nomPersonnage;
        this.question = question;
        this.effets= new EnsembleEffets(rep);

    }

    /**
     * Affiche la question avec les effets associés aux choix gauche et droit.
     */


    public void afficheQuestion() {
        String result = "["+nomPersonnage+"] "
                + question;
        System.out.println(result);

        effets.AfficheEffets();
        String choix = "Entrez la réponse (";
        int test=0;
        for (Map.Entry<TypeEffets, Effet> mapentry : effets.listeEffets.entrySet()) {
            System.out.println(mapentry.getKey().toString() + afficheEffets(mapentry.getValue().effetJauge));
            if (test!=0){
                choix+=" ou ";

            }
            choix+=mapentry.getKey().toString();
            test=1;
        }
        choix+=")";

        System.out.flush();
        System.out.println(choix);
    }

    /**
     * Retourne une chaîne de caractères représentant les effets d'une jauge.
     *
     * @param effets La map des effets de jauge
     * @return la chaîne de caractères représentant les effets de la jauge
     */
    private String afficheEffets(Map<TypeJauge, Integer> effets) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<TypeJauge, Integer> effet : effets.entrySet()) {
            result.append("; jauge ").append(effet.getKey()).append(":");
            if (effet.getValue() > 0) {
                result.append("+");
            }
            result.append(effet.getValue());
        }
        return result.toString();
    }

}
