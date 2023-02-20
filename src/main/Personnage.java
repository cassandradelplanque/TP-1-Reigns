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

    /**
     * La jauge de Clergé
     */
    protected Jauge jaugeClerge;
    /**
     * La jauge de Peuple
     */
    protected Jauge jaugePeuple;
    /**
     * La jauge d'Armée
     */
    protected Jauge jaugeArmee;
    /**
     * La jauge de Finances
     */
    protected Jauge jaugeFinance;

    /**
     * Crée un nouveau personnage avec le nom et le genre spécifiés,
     * puis initialise les jauges de Clergé, Peuple, Armée et Finances.
     *
     * @param nom Le nom du personnage
     */
    public Personnage(String nom) {
        this.nom = nom;

        // Initialisation des jauges entre 15 et 35 points
        jaugeClerge = new JaugeClerge();
        jaugePeuple = new JaugePeuple();
        jaugeArmee = new JaugeArmee();
        jaugeFinance = new JaugeFinance();
    }

    /**
     * Affiche les jauges de Clergé, Peuple, Armée et Finances du personnage.
     */
    public void AfficheJauges() {
        afficheJauge(jaugeClerge);
        afficheJauge(jaugePeuple);
        afficheJauge(jaugeArmee);
        afficheJauge(jaugeFinance);
        System.out.println();
    }

    /**
     * Vérifie si le jeu est fini en vérifiant si une des jauges est à 0 ou 50.
     *
     * @return true si le jeu est fini, false sinon
     */
    public boolean finDuJeu(){
        if(jaugeClerge.getValeur()<=0
                || jaugeClerge.getValeur()>=50
                || jaugePeuple.getValeur()<=0
                || jaugePeuple.getValeur()>=50
                || jaugeArmee.getValeur()<=0
                || jaugeArmee.getValeur()>=50
                || jaugeFinance.getValeur()<=0
                || jaugeFinance.getValeur()>=50){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Affiche une jauge avec un format graphique, en utilisant des "#" pour représenter la valeur de la jauge
     * et des "_" pour représenter la valeur manquante.
     *
     * @param jauge La jauge à afficher
     */
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

    /**
     * Retourne la jauge du clergé
     * @return la jauge du clergé
     */
    public Jauge getJaugeClerge() {
        return jaugeClerge;
    }

    /**
     * Modifie la jauge du clergé
     * @param jaugeClerge La nouvelle jauge du clergé
     */
    public void setJaugeClerge(Jauge jaugeClerge) {
        this.jaugeClerge = jaugeClerge;
    }

    /**
     * Retourne la jauge du peuple
     * @return la jauge du peuple
     */
    public Jauge getJaugePeuple() {
        return jaugePeuple;
    }
    /**
     * Modifie la jauge du peuple
     * @param jaugePeuple La nouvelle jauge du peuple
     */
    public void setJaugePeuple(Jauge jaugePeuple) {
        this.jaugePeuple = jaugePeuple;
    }

    /**
     * Retourne la jauge de l'armée
     * @return la jauge de l'armée
     */
    public Jauge getJaugeArmee() {
        return jaugeArmee;
    }
    /**
     * Modifie la jauge de l'armée
     * @param jaugeArmee La nouvelle jauge de l'armée
     */
    public void setJaugeArmee(Jauge jaugeArmee) {
        this.jaugeArmee = jaugeArmee;
    }

    /**
     * Retourne la jauge des finances
     * @return la jauge des finances
     */
    public Jauge getJaugeFinance() {
        return jaugeFinance;
    }
    /**
     * Modifie la jauge des finances
     * @param jaugeFinance La nouvelle jauge des finances
     */
    public void setJaugeFinance(Jauge jaugeFinance) {
        this.jaugeFinance = jaugeFinance;
    }

    public abstract String longRegne();

}