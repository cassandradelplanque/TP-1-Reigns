package main;

/**
 * Représente un personnage ayant un nom, un genre, et des jauges de Clergé, Peuple, Armée et Finances.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */

public class Personnage {
    /**
     * Le nom du personnage
     */
    protected String nom;

     protected TypePerso genre;

    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     *
     */
    public Personnage(TypePerso perso, String nom ) {
        this.nom=nom;
        this.genre= perso;

    }


    /**
     * Retourne le nom du personnage
     * @return le nom du personnage
     */
    public String getNom() {
        return nom;
    }

    public String longRegne(){
        return "Long regne: "+ genre.toString()+" "+ nom;

    };

}