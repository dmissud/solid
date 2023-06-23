package org.solid.domain.machine;

public record Cafe(String type, boolean avecSucre, boolean avecLait) {
    public boolean estDeType(String typeCafe) {
        return this.type.equals(typeCafe);
    }
}
