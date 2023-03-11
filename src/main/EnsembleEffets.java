package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EnsembleEffets {

    //public ArrayList< Effet> listeEffets ;
    public Map<TypeEffets, Effet> listeEffets = new HashMap<>();

    public EnsembleEffets(ArrayList<String> rep) {


        int i=0;
        for(TypeEffets v : TypeEffets.values()){
            if (rep.size()>i){
                this.listeEffets.put( v, new Effet( rep.get(i)));
                i++;
            }


        }

    }
    public void AfficheEffets() {


        for (Map.Entry<TypeEffets, Effet> mapentry : listeEffets.entrySet()) {
            System.out.println(mapentry.getKey().toString()+":"+ mapentry.getValue().effetTexte);

        }


    }








}
