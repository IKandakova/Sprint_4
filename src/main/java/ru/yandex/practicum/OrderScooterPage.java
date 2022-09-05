package ru.yandex.practicum;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class OrderScooterPage {
    private final WebDriver driver;
    private String period;

    //Кнопка заказать (правый верхний угол возле кнопки "Статус заказа")
    private final By orderScooterFirstButton = By.xpath("//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    //Кнопка заказать (после инструкции как работает сервис)
    private final By orderScooterSecondButton = By.xpath("//div[@class='Home_FinishButton__1_cWm']/button");
    //Кнопка заказать (после заполнения формы заказа)
    private final By orderScooterAfterFormButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Кнопка согласия оформления заказала
    private final By orderApprovalsButton = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    //Кнопка "Далее" для перехода к форме аренды
    By goToRentalFormButton  = By.xpath("//div[@class='Order_NextButton__1_rCA']/button");
    //Поле имени клиента
    private final By customerNameField = By.xpath("//input[@placeholder='* Имя']");
    //Поле фамилии клиента
    private final By customerSurnameField = By.xpath("//input[@placeholder='* Фамилия']");
    //Поле адреса клиента
    private final By customerAddressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле станции метро
    private final By customerMetroField = By.xpath("//input[@placeholder='* Станция метро']");
    //Поле телефона клиента
    private final By customerTelephoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Поле даты доставки самоката
    private final By dateTransferField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Поле срока аренды самоката
    private final By rentalPeriodField = By.className("Dropdown-placeholder");
    //Поле комментария
    private final By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Поле информации о заказе
    private final By informationAboutOrderField = By.className("Order_Text__2broi");
    // Поле цвета самоката (черный)
    private final By blackColorOfScooter = By.xpath("//input[@id='black']");
    // Поле цвета самоката (серый)
    private final By greyColorOfScooter = By.xpath("//input[@id='grey']");
    // Дата доставки в всплывающем каленаре
    private final By dateDeliveryInCalendar = By.xpath("//div[@tabindex='0' and contains(@class,'react-datepicker__day--selected')]");
    public OrderScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по кнопке "Заказать", если номер кнопки "fitst", то клик по кнопке справа наверху, если номер кнопки "second", то клик по кнопке внизу страницы
    public void clickOnButtonOfOrder(String orderScooterButton) {
        if (Objects.equals(orderScooterButton, "first")) {
        driver.findElement(orderScooterFirstButton).click();
        } else if (Objects.equals(orderScooterButton, "second")) {
            driver.findElement(orderScooterSecondButton).click();
        }
    }

    //Клик по кнопке "Далее", для перехода на страницу "Про аренду"
    public void clickOnButtonToGoRentalForm(By goToRentalFormButton) {
        driver.findElement(goToRentalFormButton).click();
    }

    //Заполнить данные о клиенте на странице "Для кого самокат"
    public void setDataAboutCustomer (String name, String surname, String address, String metro, String telephone){
        //Заполнить поле "Имя"
        driver.findElement(customerNameField).sendKeys(name);
        //Заполнить поле "Фамилия"
        driver.findElement(customerSurnameField).sendKeys(surname);
        //Заполнить поле "Адрес"
        driver.findElement(customerAddressField).sendKeys(address);
        //Заполнить поле "Метро"
        driver.findElement(customerMetroField).sendKeys(metro); //заполнить поле необходимой станцией
        driver.findElement(By.xpath("//div[@class='Order_Text__2broi' and text()='"+metro+"']")).click(); //кликаем по значению = metro из списка
        //Заполняем поле "Телефон"
        driver.findElement(customerTelephoneField).sendKeys(telephone);
    }
    //Заполнить дату аренды самоката
    public void setValueOnFieldOfDateTransfer(String date) {
        driver.findElement(dateTransferField).sendKeys(date);
        driver.findElement(dateDeliveryInCalendar).click();
    }

    //Заполнить поле периода аренды
    public void setValueOnFieldOfRentalPeriod(String period) {
        driver.findElement(rentalPeriodField).click();
        driver.findElement(By.xpath("//div[@class='Dropdown-option' and text()='"+period+"']")).click();

    }
    //Заполнить поле цвета самоката
    public void setValueOnFieldOfColorScooter(String color) {
        if (Objects.equals(color, "чёрный жемчуг")) {
            driver.findElement(blackColorOfScooter).click();
        } else if (Objects.equals(color, "серая безысходность")) {
            driver.findElement(greyColorOfScooter).click();
        }
    }
    //Заполнить поле комментария
    public void setValueOnFieldOfComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
    //Кликнуть на кнопку "Заказать" после заполнения формы
    public void clickOnButtonOfOrderAfterOrderForm() {
        driver.findElement(orderScooterAfterFormButton).click();
    }
    //Кликнуть на кнопку "Да" для подтверждения заказа
    public void clickOnButtonOfOrderApprovals() {
        driver.findElement(orderApprovalsButton).click();
    }
    //Проверить, что информация о заказе отобразилась на экране
    public void isDisplayOrderInformation() {
        Assert.assertTrue(driver.findElement(informationAboutOrderField).isDisplayed());

    }
}