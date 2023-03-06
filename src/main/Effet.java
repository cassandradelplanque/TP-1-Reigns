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
    public void appliqueEffets(Personnage personnage){
        this.appliqueEffets(effetJauge, personnage);
    }


    private void appliqueEffets(Map<TypeJauge,Integer> effets,
                                Personnage personnage){

        for(Map.Entry<TypeJauge,Integer> effet : effets.entrySet()){

            for(Jauge v : personnage.jauges.listeJauges) {
                if(v.getNom().equals( effet.getKey().toString())) {
                    var ttes = v.getValeur() + effet.getValue();
                    System.out.printf("nbav= " + v.getValeur());
                    System.out.println("key: " + effet.getKey() + " val: " + effet.getValue());
                    System.out.println("nb " + ttes);
                    v.setValeur(v.getValeur() + effet.getValue());
                }
            }

        }
    }

    public void ajouteEffet(TypeJauge jauge,
                                  int valeur){
       effetJauge.put(jauge,valeur);
    }

    public String getEffetTexte() {
        return effetTexte;
    }

    public void setEffetTexte(String effetTexte) {
        this.effetTexte = effetTexte;
    }




}
