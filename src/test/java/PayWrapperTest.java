import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.example.PaidPage;


public class PayWrapperTest {

    public static WebDriver driver;
    private static PaidPage paidPage;
    private static WebDriverWait wait;
    private static Actions actions;


    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        actions = new Actions(driver);

        try {
            WebElement acceptCookiesButton = new WebDriverWait(driver, Duration.ofSeconds(20))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.id("cookie-agree")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Кнопка принятия файлов cookie не найдена или уже скрыта.");
            }
        paidPage = new PaidPage(driver);
    }

    @Test
    public void testSelectOptions() {
        String selectOption1 = "Услуги связи";
        String selectOption2 = "Домашний интернет";
        String selectOption3 = "Рассрочка";
        String selectOption4 = "Задолженность";

        paidPage.selectOption(selectOption1);
        paidPage.checkEmptyFieldPlaceholders(selectOption1);
        paidPage.selectOption(selectOption2);
        paidPage.checkEmptyFieldPlaceholders(selectOption2);
        paidPage.selectOption(selectOption2);
        paidPage.checkEmptyFieldPlaceholders(selectOption3);
        paidPage.selectOption(selectOption3);
        paidPage.checkEmptyFieldPlaceholders(selectOption4);
        paidPage.selectOption(selectOption4);
    }

    @Test
    public void testCheckContunieButton() {

        String phoneNumber = "297777777";
        String totalSumm = "100";
        paidPage.inputPhoneSumm(phoneNumber,totalSumm);
        paidPage.clickContinueButton();
        paidPage.switchIframe();
        paidPage.verifyPaymentDetails();
        paidPage.checkLogoIframe();
        paidPage.switchDefaultContent();
    }

    @AfterEach
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
