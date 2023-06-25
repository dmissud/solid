package org.solid.domain.machine;

public class MachineACafeImpl implements GererStock, MachineACafe {
    public static final int NB_GRAINS_CAFE = 5;
    public static final String CAFE_AU_LAIT = "Café au lait";
    public static final String CAFE_SIMPLE = "Café simple";
    public static final int QUANTITE_SUCRE_MAXIMUM = 5;
    protected final String nom;
    protected final Stock stock;

    public MachineACafeImpl(String nom) {
        this.nom = nom;
        // Fixme : Ici il faudrait passer par une factory (a voir dans un prochain TP)
        this.stock = new Stock(100, 100, 50);
    }


    @Override
    public String getNom() {
        return this.nom;
    }

    @Override
    public String stockDescription() {
        return stock.stockDescription();
    }

    @Override
    public Cafe commanderUnCafe(int sucre, boolean avecLait) {
        verifieQuantiteSucre(sucre);
        if (stock.verifieStock(nbGrainsDeCafePourProduireUnCafe(), sucre, avecLait)) {
            stock.consommerStock(nbGrainsDeCafePourProduireUnCafe(), sucre, avecLait);
            return produireLeCafe(sucre, avecLait);
        } else {
            throw new MachineACafeStockException("Lors d'une commande a été détecté un stock insuffisant");
        }
    }

    private void verifieQuantiteSucre(int sucre) {
        if (sucre < 0) {
            throw new MachineACafePreparationException("Quantité de sucre négative");
        }
        if (sucre > QUANTITE_SUCRE_MAXIMUM) {
            throw new MachineACafePreparationException("Quantité de sucre trop importante max:" + QUANTITE_SUCRE_MAXIMUM);
        }
    }


    @Override
    public EtatStock consulteEtatStock() {
        return stock.consulteEtatStock();
    }
    @Override
    public void ajouterGrainsDeCafe(int nbGrainsDeCafe) {
        stock.ajouterGrainsDeCafe(nbGrainsDeCafe);
    }
    @Override
    public void ajouterSucre(int nbSucre) {
        stock.ajouterSucre(nbSucre);
    }
    @Override
    public void ajouterLait(int nbLait) {
        stock.ajouterLait(nbLait);
    }

    public DescriptionMachines description() {
        return new DescriptionMachines(this.machineDescription(), this.stockDescription());
    }

    public String machineDescription() {
        return "MachineACafeBasic{" +
                "nom='" + this.nom + '\'' +
                '}';
    }

    protected Cafe produireLeCafe(int sucre, boolean avecLait) {
        if (avecLait) {
            return new Cafe(CAFE_AU_LAIT, sucre > 0, true);
        }
        return new Cafe(CAFE_SIMPLE, sucre > 0, false);
    }

    protected int nbGrainsDeCafePourProduireUnCafe() {
        return NB_GRAINS_CAFE;
    }

}
