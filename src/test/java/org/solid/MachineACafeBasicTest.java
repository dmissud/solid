package org.solid;

import org.junit.jupiter.api.*;
import org.solid.domain.machine.Cafe;
import org.solid.domain.machine.MachineACafe;
import org.solid.domain.machine.MachineACafeBasic;
import org.solid.domain.machine.MachineACafeStockException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Validation Machine à café Basic")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MachineACafeBasicTest {

    private MachineACafe machineACafe;
    private String TypeCafe;
    private String TypeCafeAuLait;

    @BeforeEach
    void setUp() {
        machineACafe = new MachineACafeBasic("Basic");
        TypeCafe = MachineACafeBasic.CAFE_SIMPLE;
        TypeCafeAuLait = MachineACafeBasic.CAFE_AU_LAIT;
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
        MachineACafeStockException machineACafeException = Assertions.assertThrows(MachineACafeStockException.class, () -> machineACafe.commanderUnCafe(10, false));

        // THEN
        assertEquals("Quantité de sucre trop importante max:5", machineACafeException.getMessage());
    }

    @Test
    @DisplayName("Impossible de commander un café quand plus de stock")
    @Order(6)
    void commanderUnCafeQuandPlusDeStockBasic() {
        // GIVEN

        // WHEN
        MachineACafeStockException machineACafeStockException = Assertions.assertThrows(MachineACafeStockException.class, () -> {
            while (true) {
                machineACafe.commanderUnCafe(3, true);
            }
        });

        // THEN
        assertEquals("Stock insuffisant", machineACafeStockException.getMessage());
    }

}