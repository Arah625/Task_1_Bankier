import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoldPriceImporter {

    private static WebDriver driver;
    public static String goldPrice;

    @BeforeEach
    public static void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public static void driverQuit() {
        driver.quit();
    }

    @Test
    public static void priceImport() {
        driver.navigate().to("https://www.bankier.pl/inwestowanie/profile/quote.html?symbol=ZLOTO");
        goldPrice = driver.findElement(By.className("profilLast")).getText();
    }
}
