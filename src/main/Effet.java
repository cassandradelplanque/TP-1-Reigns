package main;

import java.util.Map;
import java.util.TreeMap;

public class Effet {
    public Effet(String effetTexte) {
        this.effetTexte = effetTexte;
        this.effetJauge = new TreeMap<>();
    }
    public void appliqueEffets(Personnage personnage){
        this.appliqueEffets(effetJauge, personnage);
    }


    private void appliqueEffets(Map<TypeJauge,Integer> effets,
                                Personnage personnage){
        for(Map.Entry<TypeJauge,Integer> effet : effets.entrySet()){

            for(Jauge v : personnage.jauges.listeJauges) {
               v.setValeur(v.getValeur()+ effet.getValue());
            }

        }
    }

    public void ajouteEffet(TypeJauge jauge,
                                  int valeur){
       effetJauge.put(jauge,valeur);
    }


    String effetTexte;
    protected Map<TypeJauge, Integer> effetJauge;


}
