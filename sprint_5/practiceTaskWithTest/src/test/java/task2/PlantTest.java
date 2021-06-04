package task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlantTest {

    @Test
    public void createPlant_whenColorIllegal_thenColorException() {
        Assertions.assertThrows(ColorException.class, () -> {
            try {
                new Plant("NotType", "WHITE", "name");
            } catch (TypeException e) {
                e.printStackTrace();
            } catch (ColorException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void createPlant_whenColorIllegal_thenTypeException() {
        Assertions.assertThrows(TypeException.class, () -> {
            try {
                new Plant("NotType", "WHITE", "name");
            } catch (TypeException e) {
                e.printStackTrace();
            } catch (ColorException e) {
                e.printStackTrace();
            }
        });
    }

    @Test
    public void createPlant_whenColorAndTypeWritesInLowerAndUpperCases() {
        try {
            new Plant("RARE", "WHITE", "name");
            new Plant("Rare", "White", "name");
            new Plant("rARE", "wHITE", "name");
        } catch (TypeException e) {
            e.printStackTrace();
        } catch (ColorException e) {
            e.printStackTrace();
        }

    }


    @Test
    void tryCreatePlant() {

        Plant plant = Plant.tryCreatePlant("RARE", "WHITE", "name");

        Assertions.assertEquals(Type.RARE, plant.getType());
        Assertions.assertEquals(Color.WHITE, plant.getColor());
        Assertions.assertEquals("name", plant.getName());
    }

    @Test
    void tryCreatePlant_whenColorIllegal_thenColorRED() {

        Plant plant = Plant.tryCreatePlant("RARE", "IllegalColor", "name");

        Assertions.assertEquals(Color.RED, plant.getColor());
    }

    @Test
    void tryCreatePlant_whenTypeIllegal_thenTypeORDINARY() {

        Plant plant = Plant.tryCreatePlant("IllegalType", "WHITE", "name");

        Assertions.assertEquals(Type.ORDINARY, plant.getType());
    }

    @Test
    void tryCreatePlant_whenTypeIllegalAndColorIllegal_thenTypeORDINARY_AndColorRED() {

        Plant plant = Plant.tryCreatePlant("IllegalType", "IllegalColor", "name");

        Assertions.assertEquals(Color.RED, plant.getColor());
        Assertions.assertEquals(Type.ORDINARY, plant.getType());
    }

}