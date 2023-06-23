package org.solid.domain.machine;

public class MachineACafePreparationException extends RuntimeException {


    public static final String ERREUR_LORS_DE_LA_PREPARATION_DU_CAFE = "Erreur lors de la préparation du café";

    public MachineACafePreparationException() {
        super(ERREUR_LORS_DE_LA_PREPARATION_DU_CAFE);
    }

    public MachineACafePreparationException(String message) {
        super(message);
    }

    public MachineACafePreparationException(String message, Throwable cause) {
        super(message, cause);
    }

    public MachineACafePreparationException(Throwable cause) {
        super(ERREUR_LORS_DE_LA_PREPARATION_DU_CAFE, cause);
    }

}
