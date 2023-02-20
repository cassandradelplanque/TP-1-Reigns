package main;

public class Roi extends Personnage {
    public Roi(String nom) {
        super(nom);
    }

    @Override public String longRegne(){
        return "Long règne au roi ";
    }
}
