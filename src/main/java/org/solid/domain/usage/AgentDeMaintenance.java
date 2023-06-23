package org.solid.domain.usage;


import org.solid.domain.machine.EtatStock;
import org.solid.domain.machine.MachineACafe;

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

    public void ajusterLeStock(MachineACafe machineACafe) {
        EtatStock etatStock = machineACafe.consulteEtatStock();
        ajusteStockCafeSiNecessaire(machineACafe, etatStock);
        ajusteStockSucreSiNecessaire(machineACafe, etatStock);
        ajusteStocklaitSiNecessaire(machineACafe, etatStock);
    }

    private static void ajusteStocklaitSiNecessaire(MachineACafe machineACafe, EtatStock etatStock) {
        if (etatStock.nbLait() < SEUIL_MINIMAL_LAIT) {
            machineACafe.ajouterLait(NB_LAIT);
        }
    }

    private static void ajusteStockSucreSiNecessaire(MachineACafe machineACafe, EtatStock etatStock) {
        if (etatStock.nbSucre() < SEUIL_MINIMAL_SUCRE) {
            machineACafe.ajouterSucre(NB_SUCRE);
        }
    }

    private static void ajusteStockCafeSiNecessaire(MachineACafe machineACafe, EtatStock etatStock) {
        if (etatStock.nbGrainsCafe() < SEUIL_MINIMAL_CAFE) {
            machineACafe.ajouterGrainsDeCafe(NB_GRAINS_DE_CAFE);
        }
    }
}
