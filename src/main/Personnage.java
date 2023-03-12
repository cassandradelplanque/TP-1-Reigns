package main;

import java.util.Scanner;


public class Personnage {

    protected String nom;

    protected TypePerso genre;


    public Personnage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le nom du personnage: ");
        System.out.flush();
        this.nom = scanner.nextLine();
        System.out.println("Faut-il vous appeler");
        int nb= 0;
        for(TypePerso tp : TypePerso.values()){
            System.out.println(tp + "("+ nb +")");
            nb++;
        }
        System.out.println("?");
        int genreInd;
        do {
            genreInd = scanner.nextInt();

        } while(genreInd<0 || genreInd > nb);

        this.genre= TypePerso.values()[genreInd];
        longRegne();

    }



    public String getNom() {
        return nom;
    }

    public void longRegne(){
        System.out.println("Long regne: "+ genre.toString()+" "+ nom);

    };


}