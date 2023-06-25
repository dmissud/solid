package org.solid.domain.machine;

public class MachineACafeExpresso extends MachineACafe {
    public MachineACafeExpresso(String nom) {
        super(nom);
    }

    public String machineDescription() {
        return "MachineACafeExpresso {" +
                "nom='" + this.nom + '\'' +
                '}';
    }

    protected Cafe produireLeCafe(int sucre, boolean avecLait) {
        if (avecLait) {
            return new Cafe("Capuccino", sucre > 0, true);
        }
        return new Cafe("Expresso", sucre > 0, false);
    }

    protected int nbGrainsDeCafePourProduireUnCafe() {
        return NB_GRAINS_CAFE*2;
    }

}
