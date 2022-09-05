package ru.yandex.practicum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
public class QuestionsAboutImportant {
    private  WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.id("rcc-confirm-button")).click();
    }
    @After
    public void leave(){
        driver.quit();
    }
    @Test
    public void checkTextOfAnswer(){

        QuestionsAboutImportantPage firstAnswerOfQuestions = new QuestionsAboutImportantPage(driver);
        firstAnswerOfQuestions.clickOnQuestion(firstAnswerOfQuestions.firstQuestion);
        Assert.assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", firstAnswerOfQuestions.getAnswerOfQuestion(firstAnswerOfQuestions.answerOfFirstQuestion));

        QuestionsAboutImportantPage secondAnswerOfQuestions = new QuestionsAboutImportantPage(driver);
        secondAnswerOfQuestions.clickOnQuestion(secondAnswerOfQuestions.secondQuestion);
        Assert.assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", secondAnswerOfQuestions.getAnswerOfQuestion(secondAnswerOfQuestions.answerOfSecondQuestion));

        QuestionsAboutImportantPage thirdAnswerOfQuestions = new QuestionsAboutImportantPage(driver);
        thirdAnswerOfQuestions.clickOnQuestion(thirdAnswerOfQuestions.thirdQuestion);
        Assert.assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", thirdAnswerOfQuestions.getAnswerOfQuestion(thirdAnswerOfQuestions.answerOfThirdQuestion));

        QuestionsAboutImportantPage fourthAnswerOfQuestions = new QuestionsAboutImportantPage(driver);
        fourthAnswerOfQuestions.clickOnQuestion(fourthAnswerOfQuestions.fourthQuestion);
        Assert.assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", fourthAnswerOfQuestions.getAnswerOfQuestion(fourthAnswerOfQuestions.answerOfFourthQuestion));

        QuestionsAboutImportantPage fifthAnswerOfQuestions = new QuestionsAboutImportantPage(driver);
        fifthAnswerOfQuestions.clickOnQuestion(fifthAnswerOfQuestions.fifthQuestion);
        Assert.assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", fifthAnswerOfQuestions.getAnswerOfQuestion(fifthAnswerOfQuestions.answerOfFifthQuestion));

        QuestionsAboutImportantPage sixthAnswerOfQuestions = new QuestionsAboutImportantPage(driver);
        sixthAnswerOfQuestions.clickOnQuestion(sixthAnswerOfQuestions.sixthQuestion);
        Assert.assertEquals("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", sixthAnswerOfQuestions.getAnswerOfQuestion(sixthAnswerOfQuestions.answerOfSixthQuestion));

        QuestionsAboutImportantPage seventhAnswerOfQuestions = new QuestionsAboutImportantPage(driver);
        seventhAnswerOfQuestions.clickOnQuestion(seventhAnswerOfQuestions.seventhQuestion);
        Assert.assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", seventhAnswerOfQuestions.getAnswerOfQuestion(seventhAnswerOfQuestions.answerOfSeventhQuestion));

        QuestionsAboutImportantPage eighthAnswerOfQuestions = new QuestionsAboutImportantPage(driver);
        eighthAnswerOfQuestions.clickOnQuestion(eighthAnswerOfQuestions.eighthQuestion);
        Assert.assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", eighthAnswerOfQuestions.getAnswerOfQuestion(eighthAnswerOfQuestions.answerOfEighthQuestion));

    }
}
