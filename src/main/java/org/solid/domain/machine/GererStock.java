package org.solid.domain.machine;

public interface GererStock {
    // Ici une interface pour la maintenance
    String getNom();

    String stockDescription();

    EtatStock consulteEtatStock();

    void ajouterGrainsDeCafe(int nbGrainsDeCafe);

    void ajouterSucre(int nbSucre);

    void ajouterLait(int nbLait);

}
