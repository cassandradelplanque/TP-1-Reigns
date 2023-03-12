package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Proposition {
    protected String propositionTexte;

    protected TypeEffets type;


    public Map<TypeJauge,Integer> effetJauge;



    public Proposition(String propositionTexte, TypeEffets type) {
        this.propositionTexte = propositionTexte;
        this.type = type;
        this.effetJauge = new HashMap<TypeJauge,Integer>();



    }

    public void appliqueEffets(EnsembleJauges jauges){


        for (Map.Entry<TypeJauge,Integer> effet : effetJauge.entrySet()) {

            for(Jauge v : jauges.listeJauges) {
                if(v.getNom().equals( effet.getKey().toString())) {

                    v.setValeur(v.getValeur() + effet.getValue());
                }
            }

        }
    }
    public void ajoutEffet(TypeJauge jauge,
                            int valeur){
        effetJauge.put(jauge,valeur);
    }
    public void AfficheProposition() {

        System.out.println(type.toString()+": "+ propositionTexte);


    }
    public void AfficheEffetsProposition() {
        String texte = type.toString()+": ";
        for (Map.Entry<TypeJauge,Integer> jauge : effetJauge.entrySet()) {
            texte += jauge.getKey().toString() + " "+ jauge.getValue()+ " ";
        }
        System.out.println(texte);

    }
}
