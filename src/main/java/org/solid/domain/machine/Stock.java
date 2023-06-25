package org.solid.domain.machine;

public class Stock implements GererStock {
    private int nbGrainsCafe;
    private int nbSucre; // Sucre en grammes
    private int nbLait; // Lait en nombre de doses

    Stock(int nbGrainsCafe, int nbSucre, int nbLait) {
        this.nbGrainsCafe = nbGrainsCafe;
        this.nbSucre = nbSucre;
        this.nbLait = nbLait;
    }

    public void consommerStock(int nbGrainsCafe, int sucre, boolean avecLait) {
        this.nbGrainsCafe -= nbGrainsCafe;
        this.nbSucre -= sucre;
        this.nbLait -= avecLait ? 1 : 0;
    }

    public boolean verifieStock(int nbGrainsCafe, int sucre, boolean avecLait) {
        return verifieStockCafe(nbGrainsCafe)
                && verifieStockSucre(sucre)
                && (!avecLait || verifieStockLait());
    }

    boolean verifieStockLait() {
        return this.nbLait >= 1;
    }

    boolean verifieStockSucre(int sucre) {
        return this.nbSucre >= sucre;
    }

    boolean verifieStockCafe(int nbGrainsCafe) {
        return this.nbGrainsCafe >= nbGrainsCafe;
    }

    public String getNom() {
            return "Stock de cafe, sucre et lait";
    }

    public String stockDescription() {
        return "Stock{" +
                "nbGrainsCafe=" + this.nbGrainsCafe +
                ", nbSucre=" + this.nbSucre +
                ", nbLait=" + this.nbLait +
                '}';
    }

    public EtatStock consulteEtatStock() {
        return new EtatStock(this.nbGrainsCafe, this.nbSucre, this.nbLait);
    }

    public void ajouterGrainsDeCafe(int nbGrainsDeCafe) {
        this.nbGrainsCafe += nbGrainsDeCafe;
    }
    public void ajouterSucre(int nbSucre) {
        this.nbSucre += nbSucre;
    }

    public void ajouterLait(int nbLait) {
        this.nbLait += nbLait;
    }
}