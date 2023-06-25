package org.solid;

import org.junit.jupiter.api.*;
import org.solid.domain.machine.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Validation Machine à café Basic")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Uniquement pour lister les tests dans le bon ordre
class MachineACafeExpressoTest {

    private MachineACafe machineACafe;
    private String TypeCafe;
    private String TypeCafeAuLait;

    @BeforeEach
    void setUp() {
        machineACafe = new MachineACafeExpresso("Expresso");
        TypeCafe = "Expresso";
        TypeCafeAuLait = "Capuccino";
    }

    @Test
    @DisplayName("Commander un café")
    @Order(1)
    void commanderUnCafeSurUneMachineBasic() {
        // GIVEN

        // WHEN
        Cafe cafe = machineACafe.commanderUnCafe(0, false);

        // THEN
        assertEquals(TypeCafe, cafe.type());
        assertFalse(cafe.avecLait());
    }

    @Test
    @DisplayName("Commander un café au lait")
    @Order(2)
    void commanderUnCafeAuLaitSansSucreSurUneMachineBasic() {
        // GIVEN

        // WHEN
        Cafe cafe = machineACafe.commanderUnCafe(0, true);

        // THEN
        assertEquals(TypeCafeAuLait, cafe.type());
        assertTrue(cafe.avecLait());
    }

    @Test
    @DisplayName("Commander un café Sucré")
    @Order(3)
    void commanderUnCafeSucre() {
        // GIVEN

        // WHEN
        Cafe cafe = machineACafe.commanderUnCafe(1, false);

        // THEN
        assertEquals(TypeCafe, cafe.type());
        assertTrue(cafe.avecSucre());
    }

    @Test
    @DisplayName("Commander un café Sans Sucre")
    @Order(4)
    void commanderUnCafeSansSucre() {
        // GIVEN

        // WHEN
        Cafe cafe = machineACafe.commanderUnCafe(0, false);

        // THEN
        assertEquals(TypeCafe, cafe.type());
        assertFalse(cafe.avecSucre());
    }

    @Test
    @DisplayName("Impossible de commander un café trop sucré")
    @Order(5)
    void commanderUnCafeTropSucre() {
        // GIVEN

        // WHEN
        MachineACafePreparationException machineACafePreparationException = Assertions.assertThrows(MachineACafePreparationException.class, () -> machineACafe.commanderUnCafe(10, false));

        // THEN
        assertEquals("Quantité de sucre trop importante max:5", machineACafePreparationException.getMessage());
    }

    @Test
    @DisplayName("Impossible de commander un café quand plus de stock")
    @Order(6)
    void commanderUnCafeQuandPlusDeStock() {
        // GIVEN

        // WHEN
        MachineACafeStockException machineACafeStockException = Assertions.assertThrows(MachineACafeStockException.class, () -> {
            while (true) {
                machineACafe.commanderUnCafe(3, true);
            }
        });

        // THEN
        assertEquals("Lors d'une commande a été détecté un stock insuffisant", machineACafeStockException.getMessage());
    }

}