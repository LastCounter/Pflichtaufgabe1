import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;


import static org.junit.jupiter.api.Assertions.*;

class ComponentManagerTest {
    private final int maxlength = 10;



    @Test
    //1. prüfen des Normalfalls
    public void testSearchComponentHappyPath() {
        Component HardDisk = new Component(70, true, "SSD");
        ComponentManager shoppingList1 = new ComponentManager();
        shoppingList1.buyComponent(HardDisk);

        assertEquals(HardDisk, shoppingList1.searchComponent("SSD"));
    }
    //2. Sucheingabe nicht gefunden, Rückgabewert null
    @Test
    public void testSearchComponentNotFound() {
        Component hardDisk = new Component(70, true, "SSD");
        ComponentManager shoppingList1 = new ComponentManager();
        shoppingList1.buyComponent(hardDisk);

        assertEquals(null, shoppingList1.searchComponent("HDD"));
    }
    //3. suchen in eines leeren Arrays (Liste)
    @Test
    public void testSearchComponentListEmpty() {
        ComponentManager shoppingList = new ComponentManager();

        assertThrows(NullPointerException.class, () -> {
            shoppingList.searchComponent("SSD");
        });
    }
    //4. suchen in einem vollen Array Objekt
    @Test
    public void testSearchComponentsByFullList() {

        Component hardDisk = new Component(22, true, "SSD");
        ComponentManager shoppingList1 = new ComponentManager();

        for (int i = 0; i < maxlength; i++){
            shoppingList1.buyComponent(hardDisk);
            }

        assertEquals(hardDisk, shoppingList1.searchComponent("SSD"));
    }
    //5. nimmt bei gleichen Namen, den ersten den er findet, hier SSD von hardDisk3
    @Test
    public void testSearchComponentTakeTheFirstSameName() {
        Component hardDisk1 = new Component(22, true, "HDD");
        Component hardDisk2 = new Component(22, true, "HDD");
        Component hardDisk3 = new Component(22, true, "SSD");
        Component hardDisk4 = new Component(22, true, "SSD");
        ComponentManager shoppingList = new ComponentManager();
        shoppingList.buyComponent(hardDisk1);
        shoppingList.buyComponent(hardDisk2);
        shoppingList.buyComponent(hardDisk3);
        shoppingList.buyComponent(hardDisk4);
        assertEquals(hardDisk3, shoppingList.searchComponent("SSD"));
    }

    //1. Normalfall
    @Test
    public void testCalculatePriceHappyPath() {
        Component hardDisk = new Component(50, true, "SSD");
        ComponentManager shoppingList1 = new ComponentManager();
        shoppingList1.buyComponent(hardDisk);
        shoppingList1.calculatePrice();

        assertEquals(50, shoppingList1.calculatePrice());
    }
    //2. mehrere Normalfälle, zusammengerechnet
    @Test
    public void testCalculatePriceForMultipleItems() {
        Component hardDisk = new Component(50, true, "SSD");
        Component monitor = new Component(200, true, "FHD-Monitore");
        ComponentManager shoppinglist1 = new ComponentManager();
        shoppinglist1.buyComponent(hardDisk);
        shoppinglist1.buyComponent(monitor);

        assertEquals(250, shoppinglist1.calculatePrice());
    }
    //3. Was passiert bei einem minus Ergebnis
    @Test
    public void testCalculatePriceMinusRange() {
        ComponentManager shoppingList1 = new ComponentManager();
        assertThrows(NullPointerException.class, () -> {
                shoppingList1.searchComponent("SSD");
        });
        }


    //4.
    @Test
    public void testCalculatePriceHappyPathActive() {
        Component hardDisk = new Component(22, true, "SSD");
        ComponentManager shoppingList1 = new ComponentManager();
        shoppingList1.buyComponent(hardDisk);
        assertEquals(22, shoppingList1.calculatePrice(true));
    }

    //5.
    @Test
    public void testCalculatePriceHappyPathPassiv() {
        Component hardDisk = new Component(22, true, "SSD");
        ComponentManager shoppingList1 = new ComponentManager();
        shoppingList1.buyComponent(hardDisk);
        assertEquals(22, shoppingList1.calculatePrice(true));
    }

    //6.
    @Test
    public void testCalculatePriceOnceActivePassiv() {
        Component hardDisk = new Component(22, true, "SSD");
        Component monitor = new Component(22, false, "FHD-Monitor");
        ComponentManager shoppingList1 = new ComponentManager();
        shoppingList1.buyComponent(hardDisk);
        shoppingList1.buyComponent(monitor);

        assertEquals(22, shoppingList1.calculatePrice(true));

    }
    //
    @Test
    public void testCalculateMinimumOrder() {
        Component hardDisk = new Component(0.5, true, "SSD");
        ComponentManager shoppingList1 = new ComponentManager();
        shoppingList1.buyComponent(hardDisk);
        assertThrows(IllegalArgumentException.class, shoppingList1::calculatePrice);

    }
}