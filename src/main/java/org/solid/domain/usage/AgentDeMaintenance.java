package org.solid.domain.usage;


import org.solid.domain.machine.EtatStock;
import org.solid.domain.machine.GererStock;

public class AgentDeMaintenance {
    public static final int SEUIL_MINIMAL_LAIT = 10;
    public static final int NB_LAIT = 100;
    public static final int SEUIL_MINIMAL_SUCRE = 10;
    public static final int NB_SUCRE = 100;
    public static final int SEUIL_MINIMAL_CAFE = 30;
    public static final int NB_GRAINS_DE_CAFE = 100;
    private final String nom;

    public AgentDeMaintenance(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void ajusterLeStock(GererStock gererStock) {
        EtatStock etatStock = gererStock.consulteEtatStock();
        ajusteStockCafeSiNecessaire(gererStock, etatStock);
        ajusteStockSucreSiNecessaire(gererStock, etatStock);
        ajusteStocklaitSiNecessaire(gererStock, etatStock);
    }

    private static void ajusteStocklaitSiNecessaire(GererStock gererStock, EtatStock etatStock) {
        if (etatStock.nbLait() < SEUIL_MINIMAL_LAIT) {
            gererStock.ajouterLait(NB_LAIT);
        }
    }

    private static void ajusteStockSucreSiNecessaire(GererStock gererStock, EtatStock etatStock) {
        if (etatStock.nbSucre() < SEUIL_MINIMAL_SUCRE) {
            gererStock.ajouterSucre(NB_SUCRE);
        }
    }

    private static void ajusteStockCafeSiNecessaire(GererStock gererStock, EtatStock etatStock) {
        if (etatStock.nbGrainsCafe() < SEUIL_MINIMAL_CAFE) {
            gererStock.ajouterGrainsDeCafe(NB_GRAINS_DE_CAFE);
        }
    }
}
