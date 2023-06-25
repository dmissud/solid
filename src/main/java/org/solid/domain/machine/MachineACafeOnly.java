package org.solid.domain.machine;

public class MachineACafeOnly extends MachineACafe {

    public static final String CAFE_ONLY = "Café Only";

    public MachineACafeOnly(String nom) {
        super(nom);
    }

    @Override
    public String machineDescription() {
        return "MachineACafeOnly{" +
                "nom='" + this.nom + '\'' +
                '}';
    }

    @Override
    // Fixme : Produit une exception au lieu de faire un Café au lait
    protected Cafe produireLeCafe(int sucre, boolean avecLait) {
        if (avecLait) {
            throw new MachineACafePreparationException("Cette machine ne fait pas de café au lait");
        }
        return new Cafe(CAFE_ONLY, sucre > 0, false);
    }

    @Override
    // Fixme : Comment faire pour faire varier la dose de café et si on veut un café long ou court ?
    protected int nbGrainsDeCafePourProduireUnCafe() {
        return NB_GRAINS_CAFE;
    }

}
