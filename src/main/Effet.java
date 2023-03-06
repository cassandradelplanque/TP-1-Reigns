package main;

import java.sql.SQLOutput;
import java.util.Map;
import java.util.TreeMap;

public class Effet {
    public String effetTexte;
    public TreeMap effetJauge;
    public Effet(String effetName, String effetTexte ) {
        this.effetTexte = effetTexte;
        this.effetJauge = new TreeMap<>();
    }
    public void appliqueEffets(EnsembleJauges jauges){
        this.appliqueEffets(effetJauge, jauges);
    }


    private void appliqueEffets(Map<TypeJauge,Integer> effets,
                                EnsembleJauges jauges){

        for(Map.Entry<TypeJauge,Integer> effet : effets.entrySet()){

            for(Jauge v : jauges.listeJauges) {
                if(v.getNom().equals( effet.getKey().toString())) {
                    var ttes = v.getValeur() + effet.getValue();
                    v.setValeur(v.getValeur() + effet.getValue());
                }
            }

        }
    }

    public void ajouteEffet(TypeJauge jauge,
                                  int valeur){
       effetJauge.put(jauge,valeur);
    }


}
