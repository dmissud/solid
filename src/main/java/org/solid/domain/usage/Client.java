package org.solid.domain.usage;


import org.solid.domain.machine.Cafe;
import org.solid.domain.machine.MachineACafe;
import org.solid.domain.machine.MachineACafeStockException;


public class Client {
    public static final int SEUIL_SATISFACTION = 10;
    private final String nom;
    private final int sucre;
    private final boolean lait;

    public String getNom() {
        return nom;
    }

    private int indiceSatisfaction = 0;

    public boolean estSatisfait() {
        return this.indiceSatisfaction > SEUIL_SATISFACTION;
    }

    public Client(String nom, int sucre, boolean lait) {
        this.sucre = sucre;
        this.lait = lait;
        this.nom = nom;
    }

    public void consommer(MachineACafe machineACafe) {
        try {
            machineACafe.commanderUnCafe(this.sucre, this.lait);
            this.indiceSatisfaction++;
        } catch (MachineACafeStockException machineACafeStockException) {
            this.indiceSatisfaction--;
        }
    }
}
