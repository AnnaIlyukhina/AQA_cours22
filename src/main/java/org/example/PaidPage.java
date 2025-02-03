package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class PaidPage {

    private WebDriver driver;
    private static WebDriverWait wait;
    private Actions actions;

    public PaidPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    By srcIframeVisaLocator = By.xpath("//img[@src='assets/images/payment-icons/card-types/visa-system.svg']");
    By srcIframeMirLocator = By.xpath("//img[@src='assets/images/payment-icons/card-types/mir-system-ru.svg']");
    By srcIframeMastercardLocator = By.xpath("//img[@src='assets/images/payment-icons/card-types/mastercard-system.svg']");
    By srcIframeMaestroLocator = By.xpath("//img[@src='assets/images/payment-icons/card-types/maestro-system.svg']");
    By srcIframeBelkartLocator = By.xpath("//img[@src='assets/images/payment-icons/card-types/belkart-system.svg']");
    By selectListLocator = By.xpath("//ul[@class='select__list']");
    By selectHederLocator = By.xpath("//*[@class='select__header']");

    @Step("Найти выпадающий список и выбрать опцию")
    public void selectOption(String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(selectHederLocator));
        WebElement span = button.findElement(By.xpath("//span[@class='select__arrow']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", span);
        WebElement list = wait.until(ExpectedConditions.visibilityOfElementLocated(selectListLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", list);
        By optionSelectLocator = By.xpath("//p[@class='select__option' and text()='" + optionText + "']");
        WebElement selectOption = wait.until(ExpectedConditions.elementToBeClickable(optionSelectLocator));
        actions.moveToElement(selectOption).click().perform();
    }

    @Step("Проверка плейсхолдеров в соответствии с выбранной опцией")
    public void checkEmptyFieldPlaceholders(String selectedOption) {

        String[] expectedPlaceholders;
        switch (selectedOption) {
            case "Услуги связи":
                expectedPlaceholders = new String[]{
                        "Номер телефона",
                        "Сумма",
                        "E-mail для отправки чека"
                };
                break;
            case "Домашний интернет":
                expectedPlaceholders = new String[]{
                        "Номер абонента",
                        "Сумма",
                        "E-mail для отправки чека"
                };
                break;
            case "Рассрочка":
                expectedPlaceholders = new String[]{
                        "Номер счета на 44",
                        "Сумма",
                        "E-mail для отправки чека"
                };
                break;
            case "Задолженность":
                expectedPlaceholders = new String[]{
                        "Номер счета на 2073",
                        "Сумма",
                        "E-mail для отправки чека"
                };
                break;
            default:
                expectedPlaceholders = new String[]{};
        }
        for (String placeholder : expectedPlaceholders) {
            WebElement inputField = driver.findElement(By.xpath("//input[@placeholder='" + placeholder + "']"));
            assertEquals(placeholder, inputField.getAttribute("placeholder"), "Плейсхолдер не соответсвует ожидаемому: " + placeholder);
        }

    }


    @Step("Проверка отображаемой суммы оплаты и номера телефона")
    public void verifyPaymentDetails(String expectedAmount, String expectedPhoneNumber) {
        WebElement paymentAmountElement = driver.findElement(By.id("cc-amount"));
        assertEquals(expectedAmount, paymentAmountElement.getText(), "Сумма не совпадает!");
        WebElement phoneNumberElement = driver.findElement(By.id("cc-phone"));
        assertEquals(expectedPhoneNumber, phoneNumberElement.getText(), "Номер телефона не совпадает!");

    }


    @Step("Ввод данных с номером телефона и суммой оплаты")
    public void inputPhoneSumm(String phoneNumber, String totalSumm) {
        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        phoneNumberInput.sendKeys(phoneNumber);
        WebElement totalSummInput = driver.findElement(By.id("connection-sum"));
        totalSummInput.sendKeys(totalSumm);
    }
    @Step("Нажатие кнопки Продолжить")
    public void clickContinueButton() {

        WebElement continueButton = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        continueButton.click();

    }
    @Step("Переход в окно принятия оплаты")
    public void switchIframe() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'checkout.bepaid.by/widget_v2/index.html')]")));

    }

    @Step("Поверка логотипов в окне принятия оплаты")
    public void checkLogoIframe() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        checkLogoVisibility(srcIframeVisaLocator, "Логотип Visa не отображается!", "Логотип Visa успешно отображается.");
        checkLogoVisibility(srcIframeMirLocator, "Логотип Мир не отображается!", "Логотип Мир успешно отображается.");
        checkLogoVisibility(srcIframeMastercardLocator, "Логотип MasterCard не отображается!", "Логотип MasterCard успешно отображается.");
        checkLogoVisibility(srcIframeMaestroLocator, "Логотип MasterCard Secure Code не отображается!", "Логотип Maestro успешно отображается.");
        checkLogoVisibility(srcIframeBelkartLocator, "Логотип Белкарт не отображается!", "Логотип Белкарт успешно отображается.");
    }

    @Step("Доп метод для поверка логотипов в окне принятия оплаты")
    public void checkLogoVisibility(By locator, String notDisplayedMessage, String displayedMessage) {
        try {
            WebElement imgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            assertTrue(imgElement.isDisplayed(), notDisplayedMessage);
            System.out.println(displayedMessage);
        } catch (NoSuchElementException e) {
            fail(notDisplayedMessage);
        }
    }

    @Step("Переключение фокуса с окна принятия оплаты")
    public void switchDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
