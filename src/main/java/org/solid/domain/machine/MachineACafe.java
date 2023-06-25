package org.solid.domain.machine;

public interface MachineACafe {
    // Ici une interface pour la consomation
    Cafe commanderUnCafe(int sucre, boolean avecLait);
}
