import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class PayWrapperTest {

    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cookie-agree")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            System.out.println("Кнопка принятия файлов cookie не найдена или уже скрыта.");
        }
    }

    @Test
    public void test12PayWrapperHeader() {

        WebElement headerElement = driver.findElement(By.xpath("//*[@class='pay__wrapper']/h2"));
        String headerHtml = headerElement.getAttribute("innerHTML");
        String headerText = headerHtml.replaceAll("<br>", " ").replaceAll("\\s+", " ").trim();
        String expectedHeader = "Онлайн пополнение без комиссии";
        assertEquals("Онлайн пополнение без комиссии", expectedHeader, headerText);
    }

    @Test
    public void testPaymentSystemLogos() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement imgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg']")));
            assertTrue(imgElement.isDisplayed(), "Логотип Visa не отображается!");
            System.out.println("Логотип Visa успешно отображается.");
        } catch (
                NoSuchElementException e) {
            fail("Логотип Visa не найден на странице!");
        }
        try {
            WebElement imgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg']")));
            assertTrue(imgElement.isDisplayed(), "Логотип Verified By Visa не отображается!");
            System.out.println("Логотип Verified By Visa успешно отображается.");
        } catch (
                NoSuchElementException e) {
            fail("Логотип Verified By Visa не найден на странице!");
        }
        try {
            WebElement imgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg']")));
            assertTrue(imgElement.isDisplayed(), "Логотип MasterCard не отображается!");
            System.out.println("Логотип MasterCard успешно отображается.");
        } catch (
                NoSuchElementException e) {
            fail("Логотип MasterCard не найден на странице!");
        }
        try {
            WebElement imgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg']")));
            assertTrue(imgElement.isDisplayed(), "Логотип MasterCard Secure Code не отображается!");
            System.out.println("Логотип MasterCard Secure Code успешно отображается.");
        } catch (
                NoSuchElementException e) {
            fail("Логотип MasterCard Secure Code не найден на странице!");
        }
        try {
            WebElement imgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg']")));
            assertTrue(imgElement.isDisplayed(), "Логотип Белкарт не отображается!");
            System.out.println("Логотип Белкарт успешно отображается.");
        } catch (
                NoSuchElementException e) {
            fail("Логотип Белкарт не найден на странице!");
        }
    }

    @Test
    public void testMoreAboutServiceLink() {
        WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        moreInfoLink.click();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(expectedUrl, driver.getCurrentUrl(), "URL не соответствует ожидаемому после перехода по ссылке.");
        driver.navigate().back();
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://www.mts.by/", currentUrl, "Не удалось вернуться на исходную страницу.");
    }

    @Test
    public void testContinueButtonFunctionality() {
        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        phoneNumberInput.sendKeys("297777777");
        WebElement totalSummInput = driver.findElement(By.id("connection-sum"));
        totalSummInput.sendKeys("100");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        continueButton.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'checkout.bepaid.by/widget_v2/index.html')]")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement paymentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cc-number")));
        assertTrue(paymentElement.isDisplayed(), "Элемент оплаты не отображается!");
        driver.switchTo().defaultContent();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
