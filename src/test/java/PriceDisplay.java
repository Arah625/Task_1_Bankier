import org.junit.jupiter.api.Test;

public class PriceDisplay {


    @Test
    public static void displayCurrentPrice() {
        GoldPriceImporter gpi = new GoldPriceImporter();
        System.out.println("Current gold price: " + gpi.goldPrice);
    }
}
