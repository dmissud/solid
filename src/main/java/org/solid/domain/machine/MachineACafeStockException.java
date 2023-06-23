package org.solid.domain.machine;

public class MachineACafeStockException extends RuntimeException {


    public static final String ERREUR_SUR_LE_STOCK_DE_LA_MACHINE_A_CAFE = "ERREUR SUR LE STOCK DE LA MACHINE A CAFE";

    public MachineACafeStockException() {
        super(ERREUR_SUR_LE_STOCK_DE_LA_MACHINE_A_CAFE);
    }

    public MachineACafeStockException(String message) {
        super(message);
    }

    public MachineACafeStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public MachineACafeStockException(Throwable cause) {
        super(ERREUR_SUR_LE_STOCK_DE_LA_MACHINE_A_CAFE, cause);
    }

}
