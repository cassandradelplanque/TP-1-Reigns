package main;

import java.lang.reflect.Type;
import java.util.ArrayList;
import main.TypeJauge;

public class EnsembleJauges {
    public ArrayList<Jauge> listeJauges ;



    public EnsembleJauges() {
        listeJauges= new ArrayList<>();

        for(TypeJauge v : TypeJauge.values()){
            listeJauges.add(new Jauge(v.toString()));
        }

    }

    public void AfficheJauges() {
        for(Jauge v : listeJauges) {
            afficheJauge(v);
        }
        System.out.println();
    }

    private void afficheJauge(Jauge jauge) {
        String resultat = "[";
        // valeur : ####
        for(int i=0;i<jauge.getValeur();i++){
            resultat += "#";
        }
        // on complète avec ____
        for(int i=0;i<50-(jauge.getValeur()>0?jauge.getValeur():0);i++){
            resultat += "_";
        }
        resultat += "] ";
        // affichage du nom
        resultat += jauge.getNom();
        System.out.println(resultat);
    }

    public Boolean finDuJeu(){

        for(Jauge v : listeJauges) {
            if (v.getValeur() <= 0 || v.getValeur()>= 50){
                return Boolean.TRUE;
            }
        }

        return Boolean.FALSE;

    }
}
