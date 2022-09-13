package ru.yandex.practicum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
@RunWith(Parameterized.class)
public class orderScooter {
    private WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id("rcc-confirm-button")).click();
    }
    @After
    public void leave(){
        driver.quit();
    }

    private final String orderScooterButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String telephone;
    private final String date;
    private final String period;
    private final String color;
    private final String comment;

    public orderScooter(String orderScooterButton, String name, String surname, String address, String metro, String telephone, String date, String period, String color, String comment) {
        this.orderScooterButton=orderScooterButton;
        this.name = name;
        this.surname  = surname;
        this.address = address;
        this.metro = metro;
        this.telephone = telephone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDataForForm() {
        //Сгенерируй тестовые данные (нам нужно название городов и результат поиска)
        return new Object[][] {
                {"first","Василий", "Петров", "г.Москва, ул.Ленина,д.5,кв.6", "Лубянка", "89372335613", "13.10.2022", "двое суток", "чёрный жемчуг", "Позвонить за 2 часа до доставки"},
                {"second","Галина", "Смирнова", "г.Москва, ул.Школьная,д.28,кв.10", "Спортивная", "+79171005213", "29.09.2022", "семеро суток", "серая безысходность", "Удобное время доставки после 15.00"},

        };
    }
    @Test
    public void checkOrderScooter(){
        OrderScooterPage orderScooterPage = new OrderScooterPage(driver);
        orderScooterPage.clickOnButtonOfOrder(orderScooterButton);
        orderScooterPage.setDataAboutCustomer(name, surname, address, metro, telephone);
        orderScooterPage.clickOnButtonToGoRentalForm(orderScooterPage.goToRentalFormButton);
        orderScooterPage.setValueOnFieldOfDateTransfer(date);
        orderScooterPage.setValueOnFieldOfRentalPeriod(period);
        orderScooterPage.setValueOnFieldOfColorScooter(color);
        orderScooterPage.setValueOnFieldOfComment(comment);
        orderScooterPage.clickOnButtonOfOrderAfterOrderForm();
        orderScooterPage.clickOnButtonOfOrderApprovals();
        orderScooterPage.isDisplayOrderInformation();

    }
}
