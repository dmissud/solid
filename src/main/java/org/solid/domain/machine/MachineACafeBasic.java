package org.solid.domain.machine;

public class MachineACafeBasic extends MachineACafe {

    public static final int NB_GRAINS_CAFE = 5;
    public static final int NB_CAFE_MAX = 100;
    public static final int NB_SUCRE = 500;
    public static final int NB_LAIT = 50;
    public static final String CAFE_AU_LAIT = "café au lait";
    public static final String CAFE_SIMPLE = "café simple";

    public MachineACafeBasic(String nom, Stock stock) {
        super(nom, stock);
    }

    public MachineACafeBasic(String nom) {
        super(nom, new Stock(NB_GRAINS_CAFE * NB_CAFE_MAX, NB_SUCRE, NB_LAIT));
    }

    @Override
    public String machineDescription() {
        return "MachineACafeBasic{" +
                "nom='" + this.nom + '\'' +
                '}';
    }

    @Override
    protected Cafe produireLeCafe(int sucre, boolean avecLait) {
        if (avecLait) {
            return new Cafe(CAFE_AU_LAIT, sucre > 0, true);
        }
        return new Cafe(CAFE_SIMPLE, sucre > 0, false);
    }

    @Override
    protected int nbGrainsDeCafePourProduireUnCafe() {
        return NB_GRAINS_CAFE;
    }

}
