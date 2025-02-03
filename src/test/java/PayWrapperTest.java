import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.AfterEach;
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
    @Description("Тест проверки надписей в незаполненных полях для различных опций")
    @Severity(SeverityLevel.MINOR)
    @Story("Поочередный выбор опций и проверка отображаемых плейсхолдеров")
    public void testSelectOptions() {
        String selectOption1 = "Услуги связи";
        String selectOption2 = "Домашний интернет";
        String selectOption3 = "Рассрочка";
        String selectOption4 = "Задолженность";

        paidPage.selectOption(selectOption1);
        paidPage.checkEmptyFieldPlaceholders(selectOption1);
        paidPage.selectOption(selectOption2);
        paidPage.checkEmptyFieldPlaceholders(selectOption2);
        paidPage.selectOption(selectOption3);
        paidPage.checkEmptyFieldPlaceholders(selectOption3);
        paidPage.selectOption(selectOption4);
        paidPage.checkEmptyFieldPlaceholders(selectOption4);

    }

    @Test
    @Description("Тест для проверки окна оплаты для варианта Услуги связи")
    @Severity(SeverityLevel.NORMAL)
    @Story("Проверка соответствия данных в окне оплаты")
    public void testCheckContunieButton() {

        String phoneNumber = "297777777";
        String totalSumm = "100";
        paidPage.inputPhoneSumm(phoneNumber,totalSumm);
        paidPage.clickContinueButton();
        paidPage.switchIframe();
        paidPage.verifyPaymentDetails(totalSumm,phoneNumber);
        paidPage.checkLogoIframe();
        paidPage.switchDefaultContent();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
