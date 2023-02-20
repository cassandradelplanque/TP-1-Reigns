package main;

/**
 * Représente un personnage ayant un nom, un genre, et des jauges de Clergé, Peuple, Armée et Finances.
 *
 * @author Julie Jacques / Lucien Mousin
 * @version 1.0
 */
public abstract class Personnage {
    /**
     * Le nom du personnage
     */
    protected String nom;


    protected EnsembleJauges jauges;


    public EnsembleJauges getJauges() {
        return jauges;
    }

    public void setJauges(EnsembleJauges jauges) {
        this.jauges = jauges;
    }

    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom Le nom du personnage
     */
    public Personnage(String nom) {
        this.nom = nom;

        this.jauges= new EnsembleJauges();

    }



    /**
     * Retourne le nom du personnage
     * @return le nom du personnage
     */
    public String getNom() {
        return nom;
    }
    /**
     * Modifie le nom du personnage
     * @param nom Le nouveau nom du personnage
     */
    public void setNom(String nom) {
        this.nom = nom;
    }




    public abstract String longRegne();

}